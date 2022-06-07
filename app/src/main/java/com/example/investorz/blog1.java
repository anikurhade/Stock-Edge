package com.example.investorz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class blog1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public void GotoDFinnovation(View V)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCUMccND2H_CVS0dMZKCPCXA/featured")));

    }
    public void Gotoprakshkamra(View V)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/pranjalkamra/about")));

    }public void Gotocarachnac(View V)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/rachanaphadke/about")));

    }public void Gotoelearn(View V)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCMec1m9iUC3agiEK-nsndSg")));

    }public void Gotosuniil(View V)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/TheSunilminglani/featured")));

    }
    public void GotoDashboard(View V)
    {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
    }
}