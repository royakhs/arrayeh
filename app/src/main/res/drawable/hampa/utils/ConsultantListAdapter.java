package com.arayeh.hampa.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.Consultant;

import java.util.List;

public class ConsultantListAdapter extends  RecyclerView.Adapter<ConsultantListAdapter.MyViewHolder> {
    private List<Consultant> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView;
        public TextView addressView;
        public TextView phoneNumberView;
        public ImageView profileIcon;
        public MyViewHolder(View v) {
            super(v);
            nameView = (TextView)itemView.findViewById(R.id.txtName);
            addressView = (TextView)itemView.findViewById(R.id.txtAddress);
            phoneNumberView=(TextView)itemView.findViewById(R.id.txtPhoneNumber);
            profileIcon=(ImageView) itemView.findViewById(R.id.iv_image);
        }
    }


    public ConsultantListAdapter(List<Consultant> myDataset) {
        this.mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ConsultantListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.consultant_item, parent, false);
        MyViewHolder pvh = new MyViewHolder(v);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder personViewHolder, int i) {
        personViewHolder.nameView.setText(mDataset.get(i).getName());
        personViewHolder.addressView.setText(mDataset.get(i).getAddress());
        personViewHolder.phoneNumberView.setText(mDataset.get(i).getPhoneNumbedr());
        personViewHolder.profileIcon.setBackgroundResource(mDataset.get(i).getProfileIcon());
       // personViewHolder.profileIcon.setImageIcon(mDataset.get(i).setProfileIcon());
        //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}