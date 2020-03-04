package com.arayeh.hampa.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.NewsItem;

import java.util.List;

public class FirstNewsAdapter  extends  RecyclerView.Adapter<FirstNewsAdapter.MyViewHolder> {
    private List<NewsItem> mDataset;

    public FirstNewsAdapter(List<NewsItem> newsItems) {
        this.mDataset = newsItems;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            headerView = (TextView)itemView.findViewById(R.id.txtHeader);
            textView = (TextView)itemView.findViewById(R.id.txtContext);
        }
    }


    @Override
    public FirstNewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_first, parent, false);
        FirstNewsAdapter.MyViewHolder pvh = new FirstNewsAdapter.MyViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(FirstNewsAdapter.MyViewHolder newsViewHolder, int i) {
        newsViewHolder.headerView.setText(mDataset.get(i).getHeader());
        newsViewHolder.textView.setText(mDataset.get(i).getNewsContext());
        //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
