package com.arayeh.hampa.Interfaces;


import android.os.Parcelable;

import com.arayeh.hampa.models.IranianDate;

public interface SelectDateClick extends Parcelable {
    public void onDateClick(IranianDate selectedDate);
}
