//package com.arayeh.hampa.services;
//
//import android.app.IntentService;
//import android.content.Intent;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.FragmentTransaction;
//
//import com.arayeh.hampa.R;
//import com.arayeh.hampa.fragments.ConsultantListFragment;
//import com.arayeh.hampa.fragments.PersianCalendarFragment;
//import com.arayeh.hampa.models.IranianDate;
//
//public class LoadFragmentService extends IntentService {
//    public LoadFragmentService() {
//        super("LoadFragmentService");
//    }
//
//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//        IranianDate iranianDate=intent.getex(VEHICLE_LIST_URL_ADDRESS);
//        PersianCalendarFragment myf = new PersianCalendarFragment(iranianDate, ConsultantListFragment.this, 500);
//        //  myf.show(getChildFragmentManager(),"");
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment, myf);
//        transaction.commit();
//    }
//}
