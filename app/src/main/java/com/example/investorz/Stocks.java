package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Stocks extends AppCompatActivity  implements Adapter.ViewHolder.onStockClickListener {

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
        stockArrayList.add(new Stock("1","TCS"));
        stockArrayList.add(new Stock("2","Infosys"));
        stockArrayList.add(new Stock("3","Hind. Unilever"));
        stockArrayList.add(new Stock("4","HCL Tech"));
        stockArrayList.add(new Stock("5","Wipro"));
        stockArrayList.add(new Stock("6","Nestle India"));
        stockArrayList.add(new Stock("7","Tata Steel"));
        stockArrayList.add(new Stock("8","Pidilite"));
        stockArrayList.add(new Stock("9","Tech Mahindra"));
        stockArrayList.add(new Stock("10","Divi's Lab"));
        stockArrayList.add(new Stock("11","Dabur India"));
        stockArrayList.add(new Stock("12","Havells India"));
        stockArrayList.add(new Stock("13","Marico"));
        stockArrayList.add(new Stock("14","L&T Infotech"));
        stockArrayList.add(new Stock("15","SRF"));
        stockArrayList.add(new Stock("16","Berger Piants"));
        stockArrayList.add(new Stock("17","United Spirits"));
        stockArrayList.add(new Stock("18","Tata Elixi"));
        stockArrayList.add(new Stock("19","Page Industries"));
        stockArrayList.add(new Stock("20","Mindtree"));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        Adapter adapter=new Adapter(stockArrayList,Stocks.this, this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onStockClick(int postion) {
        if(postion==0)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/TCS/consolidated/")));
        }
        if(postion==1)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/INFY/consolidated/")));
        }
        if(postion==2)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/HINDUNILVR/consolidated/")));
        }
        if(postion==3)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/HCLTECH/consolidated/")));
        }
        if(postion==4)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/WIPRO/consolidated/")));
        }
        if(postion==5)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/NESTLEIND/")));
        }
        if(postion==6)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/TATASTEEL/consolidated/")));
        }
        if(postion==7)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/PIDILITIND/consolidated/")));
        }
        if(postion==8)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/TECHM/consolidated/")));
        }
        if(postion==9)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/DIVISLAB/consolidated/")));
        }
        if(postion==10)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/DABUR/consolidated/")));
        }
        if(postion==11)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/HAVELLS/consolidated/")));
        }
        if(postion==12)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/MARICO/consolidated/")));
        }
        if(postion==13)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/LTI/consolidated/")));
        }
        if(postion==14)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/SRF/consolidated/")));
        }
        if(postion==15)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/BERGEPAINT/consolidated/")));
        }
        if(postion==16)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/MCDOWELL-N/consolidated/")));
        }
        if(postion==17)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/TATAELXSI/")));
        }
        if(postion==18)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/PAGEIND/")));
        }
        if(postion==19)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.screener.in/company/MINDTREE/consolidated/")));
        }

    }
}
class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    ArrayList<Stock> stockArrayList;
    Context context;
private ViewHolder.onStockClickListener onStockClickListener;
    public Adapter(ArrayList<Stock> stockArrayList, Context context, ViewHolder.onStockClickListener onStockClickListener) {
        this.stockArrayList = stockArrayList;
        this.context = context;
        this.onStockClickListener=onStockClickListener;
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
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view, onStockClickListener);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView compname,high;
onStockClickListener onStockClickListener;
        public ViewHolder(View view,onStockClickListener onStockClickListener) {
            super(view);
            compname = (TextView) view.findViewById(R.id.disschmename);
            high = (TextView) view.findViewById(R.id.srno);
             view.setOnClickListener(this);
              this.onStockClickListener=onStockClickListener;

        }

        @Override
        public void onClick(View v) {
            onStockClickListener.onStockClick(getAdapterPosition());
        }

        public  interface onStockClickListener{
            void onStockClick(int postion);
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
