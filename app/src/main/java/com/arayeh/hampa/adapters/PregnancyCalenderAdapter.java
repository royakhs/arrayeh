package com.arayeh.hampa.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.PregnancyCalender;
import com.arayeh.hampa.R;
import com.arayeh.hampa.interfaces.SelectItemClick;

import java.util.List;

public class PregnancyCalenderAdapter extends RecyclerView.Adapter<PregnancyCalenderAdapter.MyViewHolder> {
    private List<PregnancyCalender> mDataset;
    private SelectItemClick caller;
    private static final int VIEW_TYPE_ITEM = 2;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtWeekNumber;

        public MyViewHolder(View v) {
            super(v);
            mTxtWeekNumber = (TextView)itemView.findViewById(R.id.txtWeekNumber);
        }
    }

    public PregnancyCalenderAdapter(List<PregnancyCalender> myDataset,SelectItemClick caller) {
        this.mDataset = myDataset;
        this.caller=caller;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PregnancyCalenderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        if(viewType == VIEW_TYPE_ITEM){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pregnancy_calender_selected_item, parent, false);
            return new PregnancyCalenderAdapter.MyViewHolder(v);
        }else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pregnancy_calender_item, parent, false);
            final PregnancyCalenderAdapter.MyViewHolder pvh = new PregnancyCalenderAdapter.MyViewHolder(v);

            pvh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //   caller.onItemClick(0, pvh.getAdapterPosition());
                    // Toast.makeText()
                }
            });
            return pvh;
        }
        // create a new view

    }

    @Override
    public void onBindViewHolder(PregnancyCalenderAdapter.MyViewHolder personViewHolder, int i) {
        personViewHolder.mTxtWeekNumber.setText(mDataset.get(i).getWeekNumber());
       // if(i==12){
//            personViewHolder.mTxtWeekNumber.setBackground(null);
//            personViewHolder.mTxtWeekNumber.setTextSize(20);
      //  }

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
