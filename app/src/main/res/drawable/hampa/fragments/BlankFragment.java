package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.arayeh.hampa.R;


public class BlankFragment extends DialogFragment {

    private TextView txx;
    String text;

    public BlankFragment(String s) {
    this.text=s;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        txx = view.findViewById(R.id.txt);
        txx.setText(text);
        return view;
    }

}
