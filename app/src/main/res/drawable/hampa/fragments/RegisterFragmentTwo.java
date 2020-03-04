package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.arayeh.hampa.Interfaces.OnClick;
import com.arayeh.hampa.R;

public class RegisterFragmentTwo extends Fragment {
    private static Button btnAccept;
    private static  OnClick caller;
    private RadioGroup radioGroup;
   // private static EditText edtCode;
    public RegisterFragmentTwo(OnClick caller) {
        this.caller = caller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_fragment_two, container, false);
        btnAccept=v.findViewById(R.id.btnAccept);
        radioGroup=v.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case 1:
                        loadPregnantStatus();
                        break;
                    case 2:
                        loadAfterParturitionFragment();
                        break;
                    case 3:
                        loadMotherAndPregnantFragment();
                        break;
                }
            }
        });

//        edtCode=v.findViewById(R.id.edtCode);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //caller.onOkClick(edtCode.getText().toString());
            }
        });
        // TextView textView=v.findViewById(R.id.text);
        //  textView.setText("First Fragment");
        return v;
    }
    public void loadPregnantStatus(){
        PregnantFragment myf = new PregnantFragment();
//        Bundle args = new Bundle();
//        args.putParcelableArray("NEWS_ITEM", newsItems);
//        myf.setArguments(args);
        androidx.fragment.app.FragmentTransaction transaction =getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.statusFragment, myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public  void loadAfterParturitionFragment(){
        AfterParturitionFragment myf = new AfterParturitionFragment();
//        Bundle args = new Bundle();
//        args.putParcelableArray("NEWS_ITEM", newsItems);
//        myf.setArguments(args);
        androidx.fragment.app.FragmentTransaction transaction =getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.statusFragment, myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public  void loadMotherAndPregnantFragment(){
        MotherAndPregnantFragment myf = new MotherAndPregnantFragment();
//        Bundle args = new Bundle();
//        args.putParcelableArray("NEWS_ITEM", newsItems);
//        myf.setArguments(args);
        androidx.fragment.app.FragmentTransaction transaction =getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.statusFragment, myf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}