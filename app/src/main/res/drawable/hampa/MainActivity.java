package com.arayeh.hampa;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.arayeh.hampa.Interfaces.OnClick;
import com.arayeh.hampa.Interfaces.SelectDateClick;
import com.arayeh.hampa.fragments.AlarmDialogFragment;
import com.arayeh.hampa.fragments.ConsultantListFragment;
import com.arayeh.hampa.fragments.FavoritesFragment;
import com.arayeh.hampa.fragments.HomeFragment;
import com.arayeh.hampa.fragments.ProfileFragment;
import com.arayeh.hampa.fragments.ShowNewsDetailFragment;
import com.arayeh.hampa.models.IranianDate;
import com.arayeh.hampa.models.LoginData;
import com.arayeh.hampa.models.NewsItem;
import com.arayeh.hampa.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ParcelCreator")
public class MainActivity extends AppCompatActivity implements OnClick, SelectDateClick {
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        BottomAppBar bar =  findViewById(R.id.bar);
//        bar.replaceMenu(R.menu.bottom_navigation_menu);
       // loadProfileFragment();
        loadHomeFragment();
//        bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                switch (id){
//                    case R.id.like:
//                      //  loadConsultantListFragment();
//                      //  Toast.makeText(MainActivity.this,"Like Clicked",Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.search:
//                        Toast.makeText(MainActivity.this,"Search Clicked",Toast.LENGTH_SHORT).show();
//                        break;
////                    case R.id.settings:
////                        Toast.makeText(MainActivity.this,"Settings Clicked",Toast.LENGTH_SHORT).show();
////                        break;
////                    case R.id.logout:
//
//                       // Toast.makeText(MainActivity.this,"Logout Clicked",Toast.LENGTH_SHORT).show();
////                        break;
//                }
//                return false;
//            }
//        });
     //   setSupportActionBar(bar);
     //   setSupportActionBar(bar);

      //  setSupportActionBar(bar);

//        bottomNavigationView= findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.navigation_profile:
//                            loadProfileFragment();
//                            break;
//                        case R.id.navigation_news:
//                            break;
//                    }
//                    return false;
//                }
//        });
    }

    private void loadProfileFragment(){
        ProfileFragment myf = new ProfileFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.disallowAddToBackStack();
        transaction.commit();
    }
    private void loadHomeFragment(){
        HomeFragment myf = new HomeFragment();
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.disallowAddToBackStack();
        transaction.commit();
    }
    public void loadShowNewsDetail(NewsItem newsItem){
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
    private void loadConsultantListFragment(){
        ConsultantListFragment myf = new ConsultantListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        getSupportFragmentManager().executePendingTransactions();
        transaction.disallowAddToBackStack();
        transaction.commit();
    }
    public void loadShowMoreFirstList(List<NewsItem> newsItems){
        FavoritesFragment myf = new FavoritesFragment();
//        Bundle args = new Bundle();
//        args.putParcelableArray("NEWS_ITEM", newsItems);
//        myf.setArguments(args);
        androidx.fragment.app.FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment, myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onFabClick(View view) {
        LoginData loginData=new LoginData(getApplicationContext());
        if(loginData.getRegister()){
            loadProfileFragment();
        }
        else {
            AlarmDialogFragment alarmDialogFragment = new AlarmDialogFragment(this);
            alarmDialogFragment.show(this.getSupportFragmentManager(), "DialogShow");
        }

    }

    public void onConsultantClick(View view) {

        loadConsultantListFragment();
    }

    public void onHomeClick(View view) {
        loadHomeFragment();
    }

    @Override
    public void onOkClick() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    @Override
    public void onOkClick(String s1) {


    }



    @Override
    public void onOkClick(User user) {

    }

    @Override
    public void onCancelClick() {

    }

    @Override
    public void onDateClick(IranianDate selectedDate) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public class LoadFragmentService extends IntentService {
    public LoadFragmentService() {
        super("LoadFragmentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
     //  loadConsultantListFragment();
    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.bottom_navigation_menu,menu);
//        return true;
//    }

//override fun onCreateOptionsMenu(menu:Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.bottomappbar_menu, menu)
//        return true
//    }
}
