package com.arayeh.hampa.models;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsItem implements Parcelable {
    private int newsIcon;
    private int newsBannedr;
    private String header;
    private String newsContext;

    public NewsItem(String header,String newsContext, int newsIcon,int newsBannedr) {
        this.newsContext=newsContext;
        this.header=header;
        this.newsIcon=newsIcon;
        this.newsBannedr=newsBannedr;
    }

    protected NewsItem(Parcel in) {
        newsIcon = in.readInt();
        newsBannedr = in.readInt();
        header = in.readString();
        newsContext = in.readString();
    }

    public static final Creator<NewsItem> CREATOR = new Creator<NewsItem>() {
        @Override
        public NewsItem createFromParcel(Parcel in) {
            return new NewsItem(in);
        }

        @Override
        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };

    public int getNewsIcon() {
        return newsIcon;
    }

    public void setNewsIcon(int newsIcon) {
        this.newsIcon = newsIcon;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNewsContext() {
        return newsContext;
    }

    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext;
    }

    public int getNewsBannedr() {
        return newsBannedr;
    }

    public void setNewsBannedr(int newsBannedr) {
        this.newsBannedr = newsBannedr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(newsIcon);
        parcel.writeInt(newsBannedr);
        parcel.writeString(header);
        parcel.writeString(newsContext);
    }
}
