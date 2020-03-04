package com.arayeh.hampa.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.arayeh.hampa.MainActivity;
import com.arayeh.hampa.R;


public class BabyGenderFragment extends Fragment {
private AppCompatButton btnOk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_baby_gender, container, false);
        btnOk=view.findViewById(R.id.btnOK);
        NumberPicker genderPicker = view.findViewById(R.id.genderPicker);
        String[] genderChar ={"پسر","دختر"};
        genderPicker.setMaxValue(genderChar.length - 1);
        genderPicker.setDisplayedValues(genderChar);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity instanceof MainActivity){
                    MainActivity myactivity = (MainActivity) activity;
                    myactivity.loadSelectedNameFragment();
                }
            }
        });

        return view;
    }


}
