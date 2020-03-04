package com.arayeh.hampa.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;


import com.arayeh.hampa.models.ContextItem;
import com.arayeh.hampa.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<ContextItem> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headerView;
        public WebView contextView;
        public ImageView imgView;
        public VideoView videoView;

        public MyViewHolder(View v) {
            super(v);
            headerView = (TextView) itemView.findViewById(R.id.txtHeader);
            contextView = (WebView) itemView.findViewById(R.id.txtContext);
            imgView = itemView.findViewById(R.id.imgView);
            videoView = itemView.findViewById(R.id.videoView);
        }
    }

    public RecyclerViewAdapter(List<ContextItem> myDataset) {
        this.mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.context_item, parent, false);
        final MyViewHolder pvh = new MyViewHolder(v);

        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder personViewHolder, int i) {
        personViewHolder.headerView.setText(mDataset.get(i).getHeader());
        personViewHolder.contextView.loadDataWithBaseURL(null, getHtmlData(mDataset.get(i).getContext()), "text/html", "utf-8", null);
       // personViewHolder.imgView.setImageResource(mDataset.get(i).get);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/IRANSans.ttf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style>" +
                "</head>";
        return "<html>" + head + "<body  dir=\"rtl\">" + bodyHTML + "</body></html>";
    }
}