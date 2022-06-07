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

public class crypto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        RecyclerView rv;
        ArrayList<Btcoin> btcoinArrayList=new ArrayList<Btcoin>();
        rv=findViewById(R.id.cryptorecyclerView);
        btcoinArrayList.add(new Btcoin(R.drawable.coinbtc,"Bitcoin","BTC","$601,615,491,262","$31,573.46","7.29%"));
        btcoinArrayList.add(new Btcoin(R.drawable.coin_etherum,"Ethereum","ETH","$237,394,114,551","$1,962.02","-0.23%"));
        btcoinArrayList.add(new Btcoin(R.drawable.cointheter,"Tether","USDT","$72,495,070,852","$0.9994","0.04%"));
        btcoinArrayList.add(new Btcoin(R.drawable.coinusdc,"USD Coin","USDC","$53,912,728,049","$1.00","0.2%"));
        btcoinArrayList.add(new Btcoin(R.drawable.coinbnb,"BNB","BNB","$51,933,823,263","$318.07","-1.68%"));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        CoinAdapter adapter=new CoinAdapter(btcoinArrayList,crypto.this);
        rv.setAdapter(adapter);
    }
}
class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder>
{
    ArrayList<Btcoin> btcoinArrayList;
    Context context;

    public CoinAdapter(ArrayList<Btcoin> btcoinArrayList, Context context) {
        this.btcoinArrayList = btcoinArrayList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Btcoin s=btcoinArrayList.get(position);
        holder.images.setImageResource(s.getImgid());
        holder.compname.setText((String)s.getCoinname());
        holder.high.setText((String) s.getSymbool());
        holder.low.setText((String)s.getMarketcap());
        holder.lastprice.setText((String)s.getPrice());
        holder.per.setText((String) s.getLchng());


    }

    @Override
    public int getItemCount() {
        return btcoinArrayList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cryptolistitems, parent, false);

        // Passing view to ViewHolder
        CoinAdapter.ViewHolder viewHolder = new CoinAdapter.ViewHolder(view);
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

class Btcoin
{
    private int imgid;
    private  String Coinname;
    private String symbool, marketcap,price,lchng;

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getCoinname() {
        return Coinname;
    }

    public void setCoinname(String coinname) {
        Coinname = coinname;
    }

    public String getSymbool() {
        return symbool;
    }

    public void setSymbool(String symbool) {
        this.symbool = symbool;
    }

    public String getMarketcap() {
        return marketcap;
    }

    public void setMarketcap(String marketcap) {
        this.marketcap = marketcap;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLchng() {
        return lchng;
    }

    public void setLchng(String lchng) {
        this.lchng = lchng;
    }

    public Btcoin(int imgid, String coinname, String symbool, String marketcap, String price, String lchng) {
        this.imgid = imgid;
        Coinname = coinname;
        this.symbool = symbool;
        this.marketcap = marketcap;
        this.price = price;
        this.lchng = lchng;
    }
}