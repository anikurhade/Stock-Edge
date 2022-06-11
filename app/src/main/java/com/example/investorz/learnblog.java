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

public class learnblog extends AppCompatActivity implements LearnAdapter.ViewHolder.onblogClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        RecyclerView rv;
        ArrayList<Learn> learninfoList=new ArrayList<>();
        rv=findViewById(R.id.learnrecyclerView);
        learninfoList.add(new Learn("How to Invest in the Stock Market for Beginners ?","Investing in the stock market for beginners is one of the\nbest ways to create a sustainable pool of savings.When\nsearching for the best way to multiply the money you\nsaved, what’s the first thought that comes to your mind?\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t...Read More"));
        learninfoList.add(new Learn("7 Best Indian Stock Market Blogs to Follow","If you are looking for a few best Indian stock market blogs\nto follow,then you have reached the right place. Although\nthere are hundreds of stock investing blogs in India,\nhowever, in this post we have hand-picked 7 best Indian\nstock market blogs that every Indian equity investor \nshould follow\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t...Read More"));
        learninfoList.add(new Learn("Demonetization Impact on the Stock Market \nand Stock Investors","Under normal conditions, the investors are bullish or\nbearish on certain sectors. The overall bullish trend in\nthe stock market does not mean that all the sectors are\nexpected to perform well. For example, PSU and\nmetal stocks are underperforming despite bullish trend.\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t...Read More"));
        learninfoList.add(new Learn("Top 5 Stock Market YouTube Channels In India","People today are increasingly becoming financially aware.\nThe stock market has become the buzzword – all the\nmore with ‘Scam 1992’ playing on every other device\nand we’re all looking for ways to navigate the market\nsuccessfully.We bring you a comprehensive list of the\nbest Indian stock market YouTubers that can help you \nleverage your YouTube influencer marketing.\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t...Read More"));
         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        LearnAdapter adapter=new LearnAdapter(learninfoList,learnblog.this, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onblogClick(int postion) {
        if(postion==0)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.elearnmarkets.com/blog/stock-market-for-beginners-in-2019/")));
        }
        if(postion==1)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://tradebrains.in/7-best-indian-stock-market-blogs/")));
        }if(postion==2)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.motilaloswal.com/blog-details/Demonetization-Effect-on-Share-Market/1157")));
        }if(postion==3)
        {
            startActivity(new Intent(getApplicationContext(), blog1.class));
        }
    }

}
class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.ViewHolder>
{
    ArrayList<Learn> learninfoList;
    Context context;
    private ViewHolder.onblogClickListener onblogClickListener;
    public LearnAdapter(ArrayList<Learn> learninfoList, Context context, ViewHolder.onblogClickListener onblogClickListener) {
        this.learninfoList = learninfoList;
        this.context = context;
        this.onblogClickListener=onblogClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull LearnAdapter.ViewHolder holder, int position) {
        Learn s=learninfoList.get(position);
        holder.title.setText((String)s.getTitle());
        holder.msg.setText((String) s.getMsg());



    }

    @Override
    public int getItemCount() {
        return learninfoList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learnlistitems, parent, false);

        // Passing view to ViewHolder
        LearnAdapter.ViewHolder viewHolder = new LearnAdapter.ViewHolder(view, onblogClickListener);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView title,msg;
        static onblogClickListener onblogClickListener;
        public ViewHolder(View view,onblogClickListener onblogClickListener ) {
            super(view);
            title = (TextView) view.findViewById(R.id.blgtitle);
            msg = (TextView) view.findViewById(R.id.msg);
            view.setOnClickListener(this);
            this.onblogClickListener=onblogClickListener;

        }

        @Override
        public void onClick(View v) {
            onblogClickListener.onblogClick(getAdapterPosition());
        }

        public  interface onblogClickListener{
            void onblogClick(int postion);
        }
    }
}
class Learn
{
    private String title;
    private  String msg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Learn(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }
}
