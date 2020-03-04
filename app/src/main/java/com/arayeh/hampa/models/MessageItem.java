package com.arayeh.hampa.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.arayeh.hampa.models.ContentItem;

public class MessageItem implements Parcelable {
    private String header;
    private String newsContext;

    public MessageItem(String header,String newsContext) {
        this.newsContext=newsContext;
        this.header=header;
    }

    protected MessageItem(Parcel in) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(header);
        parcel.writeString(newsContext);
    }
}
