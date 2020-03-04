package com.arayeh.hampa.models;

import android.os.Parcel;
import android.os.Parcelable;

public class IranianDate implements Parcelable {
    private int year;
    private int month;
    private int day;

    public IranianDate(Parcel in) {
        year = in.readInt();
        month = in.readInt();
        day = in.readInt();
    }

    public static final Creator<IranianDate> CREATOR = new Creator<IranianDate>() {
        @Override
        public IranianDate createFromParcel(Parcel in) {
            return new IranianDate(in);
        }

        @Override
        public IranianDate[] newArray(int size) {
            return new IranianDate[size];
        }
    };

    public IranianDate() {

    }

    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(year);
        parcel.writeInt(month);
        parcel.writeInt(day);
    }
}
