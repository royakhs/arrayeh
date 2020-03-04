package com.arayeh.hampa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
     // loadProfileFragment();
        loadBabayContextFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        loadBabayContextFragment();
                       // loadProfileFragment();
                        break;
                    case R.id.community:
                        loadCommunityFragment();
                        break;
                    case R.id.advice:
                        loadCommunityFragment();
                        break;
                    case R.id.more:
                        loadCommunityFragment();
                        break;
                }
                return true;
            }
        });
//        loadCommunityListFragment();
//        loadProductListFragment();
    }


    protected void loadCommunityFragment() {
        CommunityFragment myf = new CommunityFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }
    protected void loadBabayContextFragment() {
        BabyContextFragment myf = new BabyContextFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }
    protected void loadProfileFragment() {
        ProfileFragment myf = new ProfileFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack("Pregnancy");
        //transaction.disallowAddToBackStack();
        transaction.commit();
    }
    public void loadShowNewsDetail(ContentItem newsItem){
        ShowNewsDetailFragment myf = new ShowNewsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("NEWS_ITEM", newsItem);
        myf.setArguments(args);
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    protected void loadBabyStatusFragment() {
        BabyStatusFragment myf = new BabyStatusFragment();
        myf.show(getSupportFragmentManager(),"");
    }


}
