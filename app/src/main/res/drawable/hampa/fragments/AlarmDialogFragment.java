package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import com.arayeh.hampa.Interfaces.OnClick;
import com.arayeh.hampa.R;

public class AlarmDialogFragment extends DialogFragment {
    private OnClick caller;

    public AlarmDialogFragment(OnClick caller) {
        this.caller = caller;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alarm_dialog, null);
        // TextView alert = (TextView) view.findViewById(R.id.txtAlert);
        Button mBtnRegister = (Button) view.findViewById(R.id.btnRegister);
        Button mBtnExit = (Button) view.findViewById(R.id.btnExit);
//        mBtnAccept.setTypeface(myFont);
//        alert.setTypeface(myFont);
//        alert.setText(text);
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caller.onOkClick();
                dismiss();
            }
        });
        return view;
    }
}
