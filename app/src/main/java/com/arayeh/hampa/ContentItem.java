package com.arayeh.hampa;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class ContentItem implements Parcelable {
    private int newsIcon;
    private int newsBannedr;
    private String header;
    private String newsContext;

    public ContentItem(String header,String newsContext, int newsIcon,int newsBannedr) {
        this.newsContext=newsContext;
        this.header=header;
        this.newsIcon=newsIcon;
        this.newsBannedr=newsBannedr;
    }

    protected ContentItem(Parcel in) {
        newsIcon = in.readInt();
        newsBannedr = in.readInt();
        header = in.readString();
        newsContext = in.readString();
    }

    public static final Creator<ContentItem> CREATOR = new Creator<ContentItem>() {
        @Override
        public ContentItem createFromParcel(Parcel in) {
            return new ContentItem(in);
        }

        @Override
        public ContentItem[] newArray(int size) {
            return new ContentItem[size];
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
