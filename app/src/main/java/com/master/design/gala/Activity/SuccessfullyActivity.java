package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.master.design.gala.R;

public class SuccessfullyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully);

        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {

                startActivity(new Intent(SuccessfullyActivity.this, MainActivity.class));
                finish();

            }
        }, secondsDelayed * 1000);
    }
}
