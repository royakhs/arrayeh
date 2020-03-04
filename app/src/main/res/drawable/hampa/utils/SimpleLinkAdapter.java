package com.arayeh.hampa.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.NewsItem;

import java.util.List;

public class SimpleLinkAdapter extends  RecyclerView.Adapter<SimpleLinkAdapter.MyViewHolder> {
    private List<NewsItem> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtLink;
        public MyViewHolder(View v) {
            super(v);
            txtLink = (TextView)itemView.findViewById(R.id.txtLink);
        }
    }


    public SimpleLinkAdapter(List<NewsItem> myDataset) {
        this.mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SimpleLinkAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_link_item, parent, false);
        SimpleLinkAdapter.MyViewHolder pvh = new SimpleLinkAdapter.MyViewHolder(v);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SimpleLinkAdapter.MyViewHolder newsViewHolder, int i) {
        newsViewHolder.txtLink.setText(mDataset.get(i).getHeader());
        // personViewHolder.profileIcon.setImageIcon(mDataset.get(i).setProfileIcon());
        //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
