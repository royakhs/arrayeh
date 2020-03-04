package com.arayeh.hampa;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SelectedNameFragment extends Fragment {
private AppCompatButton btnOk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selected_name, container, false);
        btnOk=view.findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity instanceof MainActivity){
                    MainActivity myactivity = (MainActivity) activity;
                    myactivity.loadLoginFragment();
                }
            }
        });

        return view;
    }

}
