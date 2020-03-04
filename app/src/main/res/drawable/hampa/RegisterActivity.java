package com.arayeh.hampa;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.arayeh.hampa.Interfaces.OnClick;
import com.arayeh.hampa.adapters.ViewPagerAdapter;
import com.arayeh.hampa.fragments.RegisterFragmentOne;
import com.arayeh.hampa.fragments.RegisterFragmentTwo;
import com.arayeh.hampa.models.LoginData;
import com.arayeh.hampa.models.User;
import com.arayeh.hampa.services.MobileConfirmedService;
import com.arayeh.hampa.services.RegisterService;
import com.arayeh.hampa.utils.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

@SuppressLint("ParcelCreator")
public class RegisterActivity extends AppCompatActivity implements OnClick {
   public static androidx.viewpager.widget.ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        LocalBroadcastManager.getInstance(this).registerReceiver(sendRegisterDataReceiver, new IntentFilter(RegisterService.REGISTER_RECEIVER));
        LocalBroadcastManager.getInstance(this).registerReceiver(mobileConfirmReceiver, new IntentFilter(MobileConfirmedService.MOBILE_CONFIRME_RECEIVER));
      //  loadRegisterFragment();
        pager = findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RegisterFragmentOne(this), "ONE");
        adapter.addFragment(new RegisterFragmentTwo(this), "TWO");
        pager.setAdapter(adapter);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        adapter.registerDataSetObserver(indicator.getDataSetObserver());
    }

//    public void onButtonClickNext(View view) {
//
//
//    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onButtonClickAccept(View view) {
//        final View androidRobotView = findViewById(R.id.btnNext);
//        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
////        ActivityOptions options = ActivityOptions
////                .makeSceneTransitionAnimation(this, androidRobotView, "robot");
//        startActivity(intent);
//     // Toast.makeText(RegisterActivity.this,"iurf",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onOkClick() {

    }

    private void loadRegisterFragment() {
        RegisterFragmentOne myf = new RegisterFragmentOne(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        getSupportFragmentManager().executePendingTransactions();
        transaction.disallowAddToBackStack();
        transaction.commit();
    }

    private void loadMobileConfirmFragment() {
        RegisterFragmentTwo myf = new RegisterFragmentTwo(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        getSupportFragmentManager().executePendingTransactions();
        transaction.disallowAddToBackStack();
        transaction.commit();
    }

    @Override
    public void onOkClick(String s1) {
        startMobileConfirmed(s1);
        // Toast.makeText(RegisterActivity.this, s1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOkClick(User user) {

        //Toast.makeText(RegisterActivity.this, user.getFamily(), Toast.LENGTH_SHORT).show();
        startSendRegisterData(user);
        LoginData loginData = new LoginData(this);
//        loginData.setRegister(true);
//       loginData.setEmailAddress();
        loginData.setUserName(user.getName());
    }

    private void startSendRegisterData(User user) {
        Intent myIntent = new Intent(this, RegisterService.class);
        myIntent.putExtra(RegisterService.REGISTER_URL_ADDRESS, getSendRegisterUrl());
        myIntent.putExtra(RegisterService.REGISTER_DATA, user);
        startService(myIntent);
    }

    private void startMobileConfirmed(String sms) {
        Intent myIntent = new Intent(this, RegisterService.class);
        myIntent.putExtra(MobileConfirmedService.MOBILE_CONFIRME_URL_ADDRESS, getConfirmedUrl());
        myIntent.putExtra(MobileConfirmedService.MOBILE_CONFIRME_DATA, sms);
        startService(myIntent);
    }

    private BroadcastReceiver sendRegisterDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context contextt, Intent intent) {
            boolean isOk = intent.getBooleanExtra(RegisterService.REGISTER_RESPONSE_STATUS, false);
            String response = intent.getStringExtra(RegisterService.REGISTER_RESPONSE);
//            BlankFragment blankFragment=new BlankFragment(response);
//            blankFragment.show(getSupportFragmentManager());
//
//            // progressBarManager.closeProgressDialog();
            if (isOk) {
                //        LoginData loginData=new LoginData(this);
                LoginData loginData = new LoginData(RegisterActivity.this);
                loginData.setRegister(true);
                finish();
              //  loadMobileConfirmFragment();
                Toast.makeText(RegisterActivity.this, "اطلاعات شما با موفقیت ثبت شد", Toast.LENGTH_SHORT).show();
                //  pager.setCurrentItem(2, true);
            } else {
                Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();

            }
//            selectAction();
        }
    };
    private BroadcastReceiver mobileConfirmReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context contextt, Intent intent) {
            boolean isOk = intent.getBooleanExtra(MobileConfirmedService.MOBILE_CONFIRME_RESPONSE_STATUS, false);
            String response = intent.getStringExtra(MobileConfirmedService.MOBILE_CONFIRME_RESPONSE);
            if (isOk) {
                finish();
            } else {

            }
//            selectAction();
        }
    };

    public String getSendRegisterUrl() {
        String url = "http://77.237.74.40:8086/api/user/register?data=";
        return url;
    }

    public String getConfirmedUrl() {
        String url = "http://77.237.74.40:8086/api/mobileconfirmed?data=";
        return url;
    }

    @Override
    public void onCancelClick() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(sendRegisterDataReceiver);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
