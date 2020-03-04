package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.arayeh.hampa.models.ContentItem;
import com.arayeh.hampa.R;


public class ShowNewsDetailFragment extends Fragment {
    private TextView mTxtDate;
    private TextView mTxtDirection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_news_detail, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ContentItem newsItem = (ContentItem) bundle.get("NEWS_ITEM");
            WebView mTxtNewsContent = view.findViewById(R.id.txtNewsContent);
            ImageView mImgBanner = view.findViewById(R.id.imgBanner);
            mImgBanner.setImageResource(newsItem.getNewsBannedr());
            TextView mTxtHeader = view.findViewById(R.id.txtHeader);
            mTxtHeader.setText(newsItem.getHeader());
            mTxtDate = view.findViewById(R.id.txtDate);
            mTxtDirection = view.findViewById(R.id.txtDirection);
            mTxtNewsContent.setBackgroundColor(0);
            WebSettings webSettings = mTxtNewsContent.getSettings();
            String text = newsItem.getNewsContext();
            mTxtNewsContent.loadDataWithBaseURL(null, getHtmlData(text), "text/html", "utf-8", null);
        }
        // mTxtNewsContent.getLayoutParams().width=(3*width)/4;
        return view;
    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/IRANSans.ttf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style>" +
                "</head>";
        return "<html>" + head + "<body  dir=\"rtl\">" + bodyHTML + "</body></html>";
    }
}
