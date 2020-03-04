package com.arayeh.hampa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.OnWheelChangedListener;
import antistatic.spinnerwheel.adapters.NumericWheelAdapter;


public class ShowStatusFragment extends Fragment implements SelectItemClick {
    private RecyclerView.LayoutManager layoutManager;
    private   RecyclerView recyclerView;
    private TextView txtWeekDays;
    private FrameLayout mBtnBabyStatus;
    private TextView mTxtWeek;
    private TextView mTxtRemain;
    private TextView mTxtElapsed;
    private TextView mTxtBabyWeight;
    private TextView mTxtBabyHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   Toast.makeText(getActivity().getApplicationContext(),"royaaaaaa",Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_status, container, false);
        mTxtWeek=view.findViewById(R.id.txtWeek);
        mTxtRemain=view.findViewById(R.id.txtRemain);
        mTxtElapsed=view.findViewById(R.id.txtElapsed);
        mTxtBabyWeight=view.findViewById(R.id.babyWeight);
        mTxtBabyHeight=view.findViewById(R.id.babyHeight);

        final AbstractWheel mins = (AbstractWheel) view.findViewById(R.id.mins);
        NumericWheelAdapter minAdapter = new NumericWheelAdapter(getContext(), 1, 41, "%02d");
        minAdapter.setItemResource(R.layout.wheel_text_centered_dark_back);
        minAdapter.setItemTextResource(R.id.text);
        mins.setViewAdapter(minAdapter);
        mins.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
                mTxtWeek.setText(String.valueOf(newValue+1));
                mTxtElapsed.setText(String.valueOf(oldValue));
                mTxtRemain.setText(String.valueOf(newValue));
                mTxtBabyHeight.setText(String.valueOf(oldValue));
                mTxtBabyWeight.setText(String.valueOf(newValue));
                //Toast.makeText(getContext(),"ujdhfu",Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView = view.findViewById(R.id.calender_rcv);
        mBtnBabyStatus=view.findViewById(R.id.btnBabyStatus);

        mBtnBabyStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity instanceof HomeActivity){
                    HomeActivity myactivity = (HomeActivity) activity;
                    myactivity.loadBabyStatusFragment();
                }

            }
        });

        return view;
    }

    @Override
    public void onItemClick(int groupID, int id) {

    }

    @Override
    public void onItemClick(int groupID, ContentItem contentItem) {

    }
}
