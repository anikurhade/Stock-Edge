package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mutualfund extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutualfund);
        RecyclerView rv;
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ArrayList<Mfunds> mfundsArrayList=new ArrayList<Mfunds>();
        rv=findViewById(R.id.mfrecyclerView);
        mfundsArrayList.add(new Mfunds(R.drawable.mftata,"Tata Digital Direct Plan","16.71","30.79","30.21","Growth"));
        mfundsArrayList.add(new Mfunds(R.drawable.mfbirla,"Birla Sun Life Digital India Direct Fund","12.07","31.77","27.88","Growth"));
        mfundsArrayList.add(new Mfunds(R.drawable.mfcanara,"Canara Robeco Small Cap Fund","16.71","30.79","30.21","Growth"));
        mfundsArrayList.add(new Mfunds(R.drawable.mfsbi,"SBI Small Cap Direct IDWC Payout","14.02","25.40","20.17","Dividend Payout"));
        mfundsArrayList.add(new Mfunds(R.drawable.icicimf,"ICIC Prudential Fund Direct IDWC Payout","17.68","33.81","28.58","Dividend Payout"));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        MFAdapter adapter=new MFAdapter(mfundsArrayList,mutualfund.this);
        rv.setAdapter(adapter);
    }

}
class MFAdapter extends RecyclerView.Adapter<MFAdapter.ViewHolder>
{
    ArrayList<Mfunds> mfundsArrayList;
    Context context;

    public MFAdapter(ArrayList<Mfunds> mfundsArrayList, Context context) {
        this.mfundsArrayList = mfundsArrayList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mfunds s=mfundsArrayList.get(position);
        holder.images.setImageResource(s.getImgId());
        holder.compname.setText((String)s.getSchemename());
        holder.high.setText((String) s.getOneyret());
        holder.low.setText((String)s.getThyret());
        holder.lastprice.setText((String)s.getFyret());
        holder.per.setText((String) s.getOptions());


    }

    @Override
    public int getItemCount() {
        return mfundsArrayList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mflistitems, parent, false);

        // Passing view to ViewHolder
        MFAdapter.ViewHolder viewHolder = new MFAdapter.ViewHolder(view);
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView compname,high,low,per,lastprice;

        public ViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.stockImg);
            compname = (TextView) view.findViewById(R.id.disschmename);
            high = (TextView) view.findViewById(R.id.dis1y);
            low = (TextView) view.findViewById(R.id.dis3y);
            per = (TextView) view.findViewById(R.id.disoption);
            lastprice = (TextView) view.findViewById(R.id.dis5y);

        }
    }
}
class Mfunds
{
    private  int imgId;
    private  String Schemename;
    private String oneyret, thyret,fyret,options;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getSchemename() {
        return Schemename;
    }

    public void setSchemename(String schemename) {
        Schemename = schemename;
    }

    public String getOneyret() {
        return oneyret;
    }

    public void setOneyret(String oneyret) {
        this.oneyret = oneyret;
    }

    public String getThyret() {
        return thyret;
    }

    public void setThyret(String thyret) {
        this.thyret = thyret;
    }

    public String getFyret() {
        return fyret;
    }

    public void setFyret(String fyret) {
        this.fyret = fyret;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Mfunds(int imgId, String schemename, String oneyret, String thyret, String fyret, String options) {
        this.imgId = imgId;
        Schemename = schemename;
        this.oneyret = oneyret+"%";
        this.thyret = thyret+"%";
        this.fyret = fyret+"%";
        this.options = options;
    }
}