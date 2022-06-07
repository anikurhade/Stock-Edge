package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class Brokers extends AppCompatActivity {
    GridView brokers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brokers);
        brokers=findViewById(R.id.brokergridvi);
        ArrayList<brokeroptions> brokeroptionsArrayList =new ArrayList<brokeroptions>();
        brokeroptionsArrayList.add(new brokeroptions("Angel One",R.drawable.angelbrokeing, (float) 9.36));
        brokeroptionsArrayList.add(new brokeroptions("Zerodha",R.drawable.zerodha,(float)9.18 ));
        brokeroptionsArrayList.add(new brokeroptions("Kotak Securities",R.drawable.kotak,(float)9.16));
        brokeroptionsArrayList.add(new brokeroptions("Upstox",R.drawable.upstox11,(float)9.15));
        brokeroptionsArrayList.add(new brokeroptions("Groww",R.drawable.groww,(float)9.03));
        brokeroptionsArrayList.add(new brokeroptions("Motilal Oswal",R.drawable.motilalaoswal,(float)9.00));
        brokeroptionsArrayList.add(new brokeroptions("ICICI Securities",R.drawable.icicistock,(float)8.86));
        brokeroptionsArrayList.add(new brokeroptions("HDFC Securities",R.drawable.hdfcstock,(float)8.82));
        brokeroptionsArrayList.add(new brokeroptions("Edelweiss Securities",R.drawable.edelweiss,(float)8.75));
        brokeroptionsArrayList.add(new brokeroptions(" IIFL Securities",R.drawable.iifl,(float)8.48));
        brokeroptionsArrayList.add(new brokeroptions());
        brokeroptionsArrayList.add(new brokeroptions());

        BrokOptionAdapter op=new BrokOptionAdapter(this, brokeroptionsArrayList);
        brokers.setAdapter(op);
        brokers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.angelone.in/")));
                }
                else if(position==1)
                {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://zerodha.com/")));
                }
                else if(position==2)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kotaksecurities.com/")));
                }
                else if(position==3)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://upstox.com/")));
                }
                else if(position==4)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://groww.in/")));
                }
                else if(position==5)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.motilaloswal.com/")));
                }
                else if(position==6)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicisecurities.com/")));
                }
                else if(position==7)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hdfcsec.com/")));
                }else if(position==8)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://edelweiss.in")));
                }else if(position==9)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicisecurities.com/")));
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

class brokeroptions
{
    private String optionname;
    private int imgid;
    private  float score;
    public brokeroptions()
{

}
    public brokeroptions(String optionname, int imgid, float score) {
        this.optionname = optionname+"\t"+score+"/10";
        this.imgid = imgid;

    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

class BrokOptionAdapter extends ArrayAdapter<brokeroptions>
{

    public BrokOptionAdapter(@NonNull Context context, ArrayList<brokeroptions> brokeroptionsArrayList) {
        super(context,0, brokeroptionsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_itemforrbroker, parent, false);
        }
        brokeroptions option = getItem(position);
        TextView optionTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView optionIV = listitemView.findViewById(R.id.idIVcourse);
        optionTV.setText(option.getOptionname());
        optionIV.setImageResource(option.getImgid());
        return listitemView;
    }
}