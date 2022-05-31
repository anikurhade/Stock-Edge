package com.example.stockinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class userprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public void GotoDashboard(View V)
    {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
    }
    public void Logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
    public void Update(View V)
    {

    }
}