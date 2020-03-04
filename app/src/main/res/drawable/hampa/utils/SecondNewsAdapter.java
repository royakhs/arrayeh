package com.arayeh.hampa.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.Interfaces.SelectItemClick;
import com.arayeh.hampa.R;
import com.arayeh.hampa.models.NewsItem;

import java.util.List;

public class SecondNewsAdapter  extends  RecyclerView.Adapter<SecondNewsAdapter.MyViewHolder> {
    private List<NewsItem> mDataset;
    private SelectItemClick caller;
    public SecondNewsAdapter(List<NewsItem> newsItems,SelectItemClick caller) {
        this.mDataset = newsItems;
        this.caller=caller;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;
        public ImageView imgNews;
        public MyViewHolder(View v) {
            super(v);
            headerView = (TextView)itemView.findViewById(R.id.txtHeader);
            textView = (TextView)itemView.findViewById(R.id.txtContext);
            imgNews=(ImageView)itemView.findViewById(R.id.imgNewsIcon);
        }
    }


    @Override
    public SecondNewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_second, parent, false);
        final SecondNewsAdapter.MyViewHolder pvh = new SecondNewsAdapter.MyViewHolder(v);
        pvh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caller.onItemClick(1, pvh.getAdapterPosition());
                // Toast.makeText()
            }
        });
        return pvh;
    }

    @Override
    public void onBindViewHolder(SecondNewsAdapter.MyViewHolder newsViewHolder, int i) {
        newsViewHolder.headerView.setText(mDataset.get(i).getHeader());
        newsViewHolder.textView.setText("("+String.valueOf(i)+")"+"نظرات");
        newsViewHolder.imgNews.setImageResource(mDataset.get(i).getNewsIcon());
        //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
