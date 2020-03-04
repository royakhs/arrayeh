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

public class NewsViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsItem> mDataset;
    private SelectItemClick caller;

    public NewsViewAdapter(List<NewsItem> newsItems,SelectItemClick caller) {
        this.mDataset = newsItems;
        this.caller=caller;
    }



    public static class MyViewHolder0 extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;
        public ImageView imgNews;

        public MyViewHolder0(View v) {
            super(v);
            headerView = (TextView) itemView.findViewById(R.id.txtHeader);
            textView = (TextView) itemView.findViewById(R.id.txtContext);
            imgNews=(ImageView)itemView.findViewById(R.id.imgNewsIcon);
        }

    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;

        public MyViewHolder1(View v) {
            super(v);
            headerView = (TextView) itemView.findViewById(R.id.txtHeader);
            textView = (TextView) itemView.findViewById(R.id.txtContext);
        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;

        public MyViewHolder2(View v) {
            super(v);
            headerView = (TextView) itemView.findViewById(R.id.txtHeader);
            textView = (TextView) itemView.findViewById(R.id.txtContext);
        }
    }

    public static class MyViewHolder3 extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;

        public MyViewHolder3(View v) {
            super(v);
            headerView = (TextView) itemView.findViewById(R.id.txtHeader);
            textView = (TextView) itemView.findViewById(R.id.txtContext);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent,
                                                      final int viewType) {
        View v = null;
        switch (viewType) {
            case 0:
                // create a new view
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_first, parent, false);
                final NewsViewAdapter.MyViewHolder0 pvh = new NewsViewAdapter.MyViewHolder0(v);
                pvh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        caller.onItemClick(0, pvh.getAdapterPosition());
                       // Toast.makeText()
                    }
                });
                return pvh;
            case 1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_second, parent, false);
                NewsViewAdapter.MyViewHolder1 pvh1 = new NewsViewAdapter.MyViewHolder1(v);
                return pvh1;
            case 2:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_first, parent, false);
                NewsViewAdapter.MyViewHolder2 pvh2 = new NewsViewAdapter.MyViewHolder2(v);
                return pvh2;
            case 3:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_first, parent, false);
                NewsViewAdapter.MyViewHolder3 pvh3 = new NewsViewAdapter.MyViewHolder3(v);
                return pvh3;
        }
        return  null;

    }

//    @Override
////    public int getItemViewType(int position) {
////        // Just as an example, return 0 or 2 depending on position
////        // Note that unlike in ListView adapters, types don't have to be contiguous
////        return position % 2 * 2;
////    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder newsViewHolder, int i) {
        switch (newsViewHolder.getItemViewType()) {
            case 0:
                MyViewHolder0 viewHolder0 = (MyViewHolder0) newsViewHolder;
                viewHolder0.headerView.setText(mDataset.get(i).getHeader());
                viewHolder0.textView.setText("("+String.valueOf(i)+")"+"نظرات");
                viewHolder0.imgNews.setImageResource(mDataset.get(i).getNewsIcon());
                break;

            case 1:
                MyViewHolder1 viewHolder1 = (MyViewHolder1) newsViewHolder;
                viewHolder1.headerView.setText(mDataset.get(i).getHeader());
                viewHolder1.textView.setText(mDataset.get(i).getNewsContext());

                break;
            case 2:
                MyViewHolder0 viewHolder2 = (MyViewHolder0) newsViewHolder;
                break;

            case 3:
                MyViewHolder1 viewHolder3 = (MyViewHolder1) newsViewHolder;
                break;
        }

        //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
