package com.arayeh.hampa.Interfaces;

import android.os.Parcelable;

import com.arayeh.hampa.models.User;

public interface OnClick extends Parcelable {
    public void onOkClick();
    public void onOkClick(String s1);
    public void onOkClick(User user);
    public void onCancelClick();
}
