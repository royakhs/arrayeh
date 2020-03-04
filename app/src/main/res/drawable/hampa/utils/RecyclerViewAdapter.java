package com.arayeh.hampa.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.NewsItem;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<NewsItem> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView tedxtView;
        public ImageView imgView;
        public CardView cv;
        public MyViewHolder(View v) {
            super(v);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            headerView = (TextView)itemView.findViewById(R.id.header_tx);
            tedxtView = (TextView)itemView.findViewById(R.id.text_tx);
            imgView=itemView.findViewById(R.id.iv_image);
        }
    }

    public RecyclerViewAdapter(List<NewsItem> myDataset) {
        this.mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_item, parent, false);
        MyViewHolder pvh = new MyViewHolder(v);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder personViewHolder, int i) {
        personViewHolder.headerView.setText(mDataset.get(i).getHeader());
        personViewHolder.tedxtView.setText(mDataset.get(i).getNewsContext());
        personViewHolder.imgView.setImageResource(mDataset.get(i).getNewsIcon());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}