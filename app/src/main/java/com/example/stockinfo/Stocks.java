package com.example.stockinfo;

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

public class Stocks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        RecyclerView rv;
        ArrayList<Stock> stockArrayList=new ArrayList<>();
        rv=findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        Adapter adapter=new Adapter(stockArrayList,Stocks.this);
        rv.setAdapter(adapter);
    }
}
class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    ArrayList<Stock> stockArrayList;
    Context context;

    public Adapter(ArrayList<Stock> stockArrayList, Context context) {
        this.stockArrayList = stockArrayList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Stock s=stockArrayList.get(position);
        holder.compname.setText((String)s.getCompanyname());
        holder.high.setText((String) s.getSrno());



    }

    @Override
    public int getItemCount() {
        return stockArrayList.size();
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems, parent, false);

        // Passing view to ViewHolder
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView compname,high;

        public ViewHolder(View view) {
            super(view);
            compname = (TextView) view.findViewById(R.id.disschmename);
            high = (TextView) view.findViewById(R.id.srno);


        }
    }
}


class Stock
{
    private String srno;
    private  String Companyname;

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getCompanyname() {
        return Companyname;
    }

    public void setCompanyname(String companyname) {
        Companyname = companyname;
    }

    public Stock(String srno, String companyname) {
        this.srno = srno;
        Companyname = companyname;
    }
}
