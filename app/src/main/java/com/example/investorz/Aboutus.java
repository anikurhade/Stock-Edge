package com.example.investorz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public void GotoDashboard(View V)
    {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
    }
}