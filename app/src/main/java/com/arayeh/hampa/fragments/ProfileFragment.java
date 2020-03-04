package com.arayeh.hampa.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.fragments.FoodFragment;
import com.arayeh.hampa.fragments.ShowStatusFragment;


public class ProfileFragment extends Fragment {
    private Toolbar mTopToolbar;
    private ImageView imgBaby;
    private ImageView imgFood;
    private FrameLayout frameBaby;
    private FrameLayout frameFood;
    private ImageView imgMom;
    private ImageView imgArticles;
    private FrameLayout frameMom;
    private FrameLayout frameArticles;
    //private ViewPager pager;
//private TabLayout tabLayout;
    MenuItem fav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setHasOptionsMenu(true);
        loadStatusFragment();



       // Toast.makeText(getContext(),"ujdhfu",Toast.LENGTH_SHORT).show();
//        mTopToolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        imgBaby = view.findViewById(R.id.imgBaby);
//        imgFood = view.findViewById(R.id.imgFood);
//        frameBaby = view.findViewById(R.id.frameBaby);
//        frameFood = view.findViewById(R.id.frameFood);
//        imgMom = view.findViewById(R.id.imgMom);
//        imgArticles = view.findViewById(R.id.imgArticles);
//        frameMom = view.findViewById(R.id.frameMom);
//        frameArticles = view.findViewById(R.id.frameArticles);
//        //  frameBaby.setBackgroundResource(R.drawable.ring_background);

//        ((HomeActivity) getActivity()).setSupportActionBar(mTopToolbar);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
//        imgBaby.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadStatusFragment();
//                frameBaby.setBackgroundResource(R.drawable.ring_background);
//                frameArticles.setBackground(null);
//                frameMom.setBackground(null);
//                frameFood.setBackground(null);
//            }
//        });
//        imgFood.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFoodFragment();
//                frameBaby.setBackground(null);
//                frameArticles.setBackground(null);
//                frameMom.setBackground(null);
//                frameFood.setBackgroundResource(R.drawable.ring_background);
//            }
//        });
//        imgMom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFoodFragment();
//                frameBaby.setBackground(null);
//                frameArticles.setBackground(null);
//                frameMom.setBackgroundResource(R.drawable.ring_background);
//                frameFood.setBackground(null);
//            }
//        });
//        imgArticles.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFoodFragment();
//                frameBaby.setBackground(null);
//                frameArticles.setBackgroundResource(R.drawable.ring_background);
//                frameMom.setBackground(null);
//                frameFood.setBackground(null);
//            }
//        });

        //loadStatusFragment();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
        fav = menu.add("add");
        fav.setIcon(R.drawable.ic_back);
    }

    protected void loadStatusFragment() {
        ShowStatusFragment myf = new ShowStatusFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment1, myf);
        transaction.addToBackStack("Status");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    protected void loadFoodFragment() {
        FoodFragment myf = new FoodFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragment1, myf);
        transaction.addToBackStack("Status");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

}
