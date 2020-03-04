package com.arayeh.hampa.services;

import android.app.IntentService;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.arayeh.hampa.utils.HttpHelper;

public class MobileConfirmedService extends IntentService {
    public static final String MOBILE_CONFIRME_RECEIVER = "MobileConfirmReceiver";
    public static final String MOBILE_CONFIRME_RESPONSE = "MobileConfirmResponse";
    public static final String MOBILE_CONFIRME_URL_ADDRESS = "UrlAddress";
    public static final String MOBILE_CONFIRME_RESPONSE_STATUS = "MobileConfirmResponseStatus";
    public static final String MOBILE_CONFIRME_DATA = "MobileConfirmPointData";


    public MobileConfirmedService() {
        super("MobileConfirmedService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        String urlAddress = intent.getStringExtra(MOBILE_CONFIRME_URL_ADDRESS);
        String sms = intent.getStringExtra(MOBILE_CONFIRME_DATA);
        String responseData = "";
        boolean isOk = true;
        try {
            HttpHelper a=new HttpHelper();
            responseData = a.update(urlAddress,sms);
        } catch (Exception ex) {
            responseData=ex.toString();
            isOk = false;
        }
        Intent mIntent = new Intent(MOBILE_CONFIRME_RECEIVER);
        mIntent.putExtra(MOBILE_CONFIRME_RESPONSE, responseData);
        mIntent.putExtra(MOBILE_CONFIRME_RESPONSE_STATUS, isOk);
        LocalBroadcastManager.getInstance(this).sendBroadcast(mIntent);
    }
}
