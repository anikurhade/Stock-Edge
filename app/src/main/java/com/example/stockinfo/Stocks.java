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
        stockArrayList.add(new Stock(R.drawable.mrf,"MRF","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.tcs,"TCS","3368.40","3383.40","3325.0","-0.2"));
        stockArrayList.add(new Stock(R.drawable.titan,"Titan","2204.90","2176.90","2090.5","-2.73"));
        stockArrayList.add(new Stock(R.drawable.tatapower,"Tata Power","230.0","399.90","204.5","1.73"));
        stockArrayList.add(new Stock(R.drawable.tatamotor,"Tata Motors","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.relianceindustries,"Reliance Industries","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.reliancepower,"Reliance Power","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.coalindia,"Coal India","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.ongc,"ONGC","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.adanipower,"Adani Power","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.adaniwillmar,"Adani Wilmar","75900.0","75999.90","62944.5","0.73"));
        stockArrayList.add(new Stock(R.drawable.hal,"HAL","75900.0","75999.90","62944.5","0.73"));
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
        holder.images.setImageResource(s.getImgid());
        holder.compname.setText((String)s.getCompanyname());
        holder.high.setText((String) s.getHigh());
        holder.low.setText((String)s.getLow());
        holder.lastprice.setText((String)s.getPrice());
        holder.per.setText((String) s.getChng());


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
        ImageView images;
        TextView compname,high,low,per,lastprice;

        public ViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.stockImg);
            compname = (TextView) view.findViewById(R.id.discoinname);
            high = (TextView) view.findViewById(R.id.dissymbol);
            low = (TextView) view.findViewById(R.id.dismarketcap);
            per = (TextView) view.findViewById(R.id.discoinpercent);
            lastprice = (TextView) view.findViewById(R.id.dislatestcoinprice);

        }
    }
}


class Stock
{
    private int imgid;
    private  String Companyname;
    private String price, high,low,chng;

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getCompanyname() {
        return Companyname;
    }

    public void setCompanyname(String companyname) {
        Companyname = companyname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getChng() {
        return chng;
    }

    public void setChng(String chng) {
        this.chng = chng;
    }

    public Stock(int imgid, String companyname, String price, String high, String low, String chng) {
        this.imgid = imgid;
        Companyname = companyname;
        this.price = price;
        this.high = high;
        this.low = low;
        this.chng = chng;
    }
}
