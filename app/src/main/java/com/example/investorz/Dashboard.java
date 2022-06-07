package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
 GridView options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        options=findViewById(R.id.gridvi);
        ArrayList<dashboardoption> dasboarddoptionArraylist =new ArrayList<dashboardoption>();
        dasboarddoptionArraylist.add(new dashboardoption("Learn",R.drawable.learn));
        dasboarddoptionArraylist.add(new dashboardoption("Stocks",R.drawable.stocks));
        dasboarddoptionArraylist.add(new dashboardoption("Mutual Funds",R.drawable.mutualfund));
        dasboarddoptionArraylist.add(new dashboardoption("Crypto",R.drawable.crypto));
        dasboarddoptionArraylist.add(new dashboardoption("Brokers",R.drawable.broker));
        dasboarddoptionArraylist.add(new dashboardoption("Profile",R.drawable.profile));
        dasboarddoptionArraylist.add(new dashboardoption("About Us",R.drawable.aboutus));
        dasboarddoptionArraylist.add(new dashboardoption("Logout",R.drawable.logout));
        OptionAdapter op=new OptionAdapter(this, dasboarddoptionArraylist);
        options.setAdapter(op);
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    startActivity(new Intent(getApplicationContext(),learnblog.class));
                }if(position==1)
                {
                    startActivity(new Intent(getApplicationContext(),Stocks.class));
                }
                else if(position==2)
                {
                    startActivity(new Intent(getApplicationContext(),mutualfund.class));

                }
                else if(position==3)
                {
                    startActivity(new Intent(getApplicationContext(),crypto.class));

                }
                else if(position==4)
                {
                    startActivity(new Intent(getApplicationContext(),Brokers.class));
                }
                else if(position==5)
                {
                    startActivity(new Intent(getApplicationContext(),userprofile.class));
                }
                else if(position==6)
                {
                    startActivity(new Intent(getApplicationContext(),Aboutus.class));
                }
                else if(position==7)
                {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                }

            }
        });

    }

    public void Logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}

class dashboardoption
{
    private String optionname;
    private int imgid;

    public dashboardoption(String optionname, int imgid) {
        this.optionname = optionname;
        this.imgid = imgid;
    }

    public String getOptionname() {
        return optionname;
    }

    public void setOptionname(String optionname) {
        this.optionname = optionname;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}

class OptionAdapter extends ArrayAdapter<dashboardoption>
{

    public OptionAdapter(@NonNull Context context, ArrayList<dashboardoption> dasboarddoptionArraylist) {
        super(context,0, dasboarddoptionArraylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        dashboardoption option = getItem(position);
        TextView optionTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView optionIV = listitemView.findViewById(R.id.idIVcourse);
        optionTV.setText(option.getOptionname());
        optionIV.setImageResource(option.getImgid());
        return listitemView;
    }
}