package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
TextView tv_status;
Button tv_buttonRegister;
String message="";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_status = findViewById(R.id.tv_status);
        tv_buttonRegister = findViewById(R.id.tv_buttonRegister);
        if (isDeviceRooted()) {
            // Device is rooted

            message = "Device Is Rooted";
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            tv_status.setText(message);
            tv_buttonRegister.setVisibility(View.GONE);
        } else {
            // Device is not rooted

            message = "Device Is Not Rooted";
            tv_status.setText(message);
            tv_buttonRegister.setVisibility(View.VISIBLE);

            //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        }
        tv_buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(MainActivity.this,Registration.class);
                startActivity(i1);
            }
        });


    }
    public boolean isDeviceRooted() {
        String[] paths = {
                "/sbin/su",
                "/system/sd/xbin/su",
                "/system/bin/su",
                "/system/xbin/su"
        };
//g
        for (String path : paths) {
            if (new File(path).exists()) {
                return true;
            }
        }

        return false;
    }

}