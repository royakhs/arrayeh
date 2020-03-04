package com.arayeh.hampa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadStartFragment();
    }

    public void loadStartFragment() {
        StartFragment myf = new StartFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadStatusFragment() {
        StatusFragment myf = new StatusFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Status");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }


    protected void loadPregnancyTimeFragment() {
        PregnancyTimeFragment myf = new PregnancyTimeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadLastPeriodTimeFragment() {
        LastPeriodTimeFragment myf = new LastPeriodTimeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadShowStatusFragment() {
        ShowStatusFragment myf = new ShowStatusFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadBabyGenderFragment() {
        BabyGenderFragment myf = new BabyGenderFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadSelectedNameFragment() {
        SelectedNameFragment myf = new SelectedNameFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadLoginFragment() {
        LoginFragment myf = new LoginFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void startHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
