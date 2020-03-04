package com.arayeh.hampa.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.models.MessageItem;
import com.arayeh.hampa.R;
import com.arayeh.hampa.interfaces.SelectItemClick;

import java.util.List;

public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>  {
    private List<MessageItem> mDataset;
    private SelectItemClick caller;
    public MessageAdapter(List<MessageItem> newsItems,SelectItemClick caller) {
        this.mDataset = newsItems;
        this.caller=caller;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headerView;
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            headerView = (TextView)itemView.findViewById(R.id.header_tx);
            textView = (TextView)itemView.findViewById(R.id.text_tx);
        }
    }


    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        final MessageAdapter.MyViewHolder pvh = new MessageAdapter.MyViewHolder(v);
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
    public void onBindViewHolder(MessageAdapter.MyViewHolder newsViewHolder, int i) {
        newsViewHolder.headerView.setText(mDataset.get(i).getHeader());
        newsViewHolder.textView.setText(mDataset.get(i).getNewsContext());
        //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
