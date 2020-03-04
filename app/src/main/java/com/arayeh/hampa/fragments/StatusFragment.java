package com.arayeh.hampa.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.arayeh.hampa.MainActivity;
import com.arayeh.hampa.R;


public class StatusFragment extends Fragment {
private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_status, container, false);
        radioGroup=view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                    Activity activity = getActivity();
                    if(activity instanceof MainActivity){
                        MainActivity myactivity = (MainActivity) activity;
                        myactivity.loadPregnancyTimeFragment();

                }
            }
        });

        return view;
    }


}
