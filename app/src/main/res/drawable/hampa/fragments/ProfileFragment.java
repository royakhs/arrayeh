package com.arayeh.hampa.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.LoginData;
import com.arayeh.hampa.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ValidFragment")
public class ProfileFragment extends Fragment {
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.txtWellcom)  TextView mTxtWellcom;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
//    private static ViewPager pager;

//    private TextView mTxtWellcom;
//    private static TabLayout tabLayout;


    @SuppressLint("ValidFragment")
    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
      //  mTxtWellcom = view.findViewById(R.id.txtWellcom);
        LoginData loginData = new LoginData(getActivity().getApplicationContext());
        mTxtWellcom.setText(loginData.getUserNamed() + '\n' + " عزیز به همپای کودک خوش امدید");
        adapter.addFragment(new YourReviewsFragment(), "مراجعات شما");
        adapter.addFragment(new FavoritesFragment(), "علاقه مندی ها");
       // pager = view.findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setCurrentItem(1);
        //tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
//
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putBoolean(SAVED_STATE_WELCOME_DIALOG_SHOWN, mWelcomeDialogHasAlreadyBeenShown);
    }

//    private void loadProfileFragment() {
//        FavoritesFragment myf = new FavoritesFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment, myf);
//        transaction.commit();
//    }
}
