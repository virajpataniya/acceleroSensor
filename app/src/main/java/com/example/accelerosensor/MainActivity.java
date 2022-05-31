package com.example.accelerosensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter=new IntentFilter("com.viral.broadCastMsg");
        Button btnNxt, acceleroSensr;

        btnNxt=findViewById(R.id.btnNxt);

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNxt=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(iNxt);
            }
        });


        //Accelermeter sensor code
        acceleroSensr=findViewById(R.id.acceleroSensr);
        acceleroSensr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intentToAcc=new Intent(MainActivity.this,ThirdActivity.class);
               startActivity(intentToAcc);


            }
        });


        //SMS Receiver
        SmsReceiver smsReceiver=new SmsReceiver();
        registerReceiver(smsReceiver,intentFilter);

        //Broadcast Receiver
//       MyBroadcastReceiver myBroadcastReceiver= new MyBroadcastReceiver();
//       registerReceiver(myBroadcastReceiver,intentFilter);

    }

}