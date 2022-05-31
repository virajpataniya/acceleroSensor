package com.example.accelerosensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager!=null){

            Sensor acclroSensr=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if (acclroSensr!=null){
                sensorManager.registerListener(this,acclroSensr, SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        else {
            Toast.makeText(this, "Sensor Service not detected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER);
        {
            ((TextView)findViewById(R.id.txtValus)).setText("X: "+sensorEvent.values[0] +", Y" + sensorEvent.values[1] + ", Z" +sensorEvent.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}