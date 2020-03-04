package com.arayeh.hampa.services;

import android.app.IntentService;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.arayeh.hampa.models.User;
import com.arayeh.hampa.utils.HttpHelper;

public class RegisterService extends IntentService {

    public static final String REGISTER_RECEIVER = "InsertPointReceiver";
    public static final String REGISTER_RESPONSE = "InsertPointResponse";
    public static final String REGISTER_URL_ADDRESS = "UrlAddress";
    public static final String REGISTER_RESPONSE_STATUS = "InsertPointResponseStatus";
    public static final String REGISTER_DATA = "InsertPointData";


    public RegisterService() {
        super("RegisterService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        String urlAddress = intent.getStringExtra(REGISTER_URL_ADDRESS);
        User user=intent.getParcelableExtra(REGISTER_DATA);
        String responseData = "";
        boolean isOk = true;
        try {
            HttpHelper a=new HttpHelper();
            responseData = a.update(user,urlAddress);
        } catch (Exception ex) {
            responseData=ex.toString();
            isOk = false;
        }
        Intent mIntent = new Intent(REGISTER_RECEIVER);
        mIntent.putExtra(REGISTER_RESPONSE, responseData);
        mIntent.putExtra(REGISTER_RESPONSE_STATUS, isOk);
        LocalBroadcastManager.getInstance(this).sendBroadcast(mIntent);
    }
}
