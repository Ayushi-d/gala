package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.master.design.gala.Helper.User;
import com.master.design.gala.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdvertiseSelector extends AppCompatActivity {
    User user;

    @OnClick(R.id.englishTxt)
    public void english()
    {
     startActivity(new Intent(AdvertiseSelector.this,LoginActivity.class));
     finish();
    }

    @OnClick(R.id.arabicTxt)
    public void arabic()
    {
        startActivity(new Intent(AdvertiseSelector.this,LoginActivity.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise_selector);
        ButterKnife.bind(this);
        user = new User(AdvertiseSelector.this);



    }
}

