package com.example.stockinfo;

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
        ArrayList<dashboardoption> dashboardoptionArrayList=new ArrayList<dashboardoption>();
        dashboardoptionArrayList.add(new dashboardoption("Stocks",R.drawable.stocks));
        dashboardoptionArrayList.add(new dashboardoption("Mutual Funds",R.drawable.mutualfund));
        dashboardoptionArrayList.add(new dashboardoption("Crypto",R.drawable.crypto));
        dashboardoptionArrayList.add(new dashboardoption("Brokers",R.drawable.broker));
        dashboardoptionArrayList.add(new dashboardoption("Profile",R.drawable.profile));
        dashboardoptionArrayList.add(new dashboardoption("About Us",R.drawable.aboutus));
        OptionAdapter op=new OptionAdapter(this,dashboardoptionArrayList);
        options.setAdapter(op);
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                }
                else if(position==1)
                {

                }
                else if(position==2)
                {

                }
                else if(position==3)
                {
                    startActivity(new Intent(getApplicationContext(),Brokers.class));
                }
                else if(position==4)
                {
                    startActivity(new Intent(getApplicationContext(),userprofile.class));
                }
                else if(position==5)
                {

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

    public OptionAdapter(@NonNull Context context, ArrayList<dashboardoption> dashboardoptionArrayList) {
        super(context,0, dashboardoptionArrayList);
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