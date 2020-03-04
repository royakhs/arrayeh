package com.arayeh.hampa.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LoginData {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Boolean isRegister;
    private static String USER_NAME_KEY="userName";
    private static String EMAIL_ADDRESS_KEY="emailAddress";
    private static String IS_REGISTER="isRegister";
    public LoginData(Context context)
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }
    public void setUserName(String userName){
        editor.putString(USER_NAME_KEY, userName);
        editor.apply();
    }
    public void setEmailAddress(String emailAddress){
        editor.putString(EMAIL_ADDRESS_KEY, emailAddress);
        editor.apply();
    }
    public String getUserNamed(){
        return preferences.getString(USER_NAME_KEY,"Default");
    }
    public String getEmailAddress(){
        return preferences.getString(EMAIL_ADDRESS_KEY,"Default");
    }


    public Boolean getRegister() {
        return preferences.getBoolean(IS_REGISTER,false);
    }

    public void setRegister(Boolean register) {
        editor.putBoolean(IS_REGISTER, register);
        editor.apply();
    }
}
