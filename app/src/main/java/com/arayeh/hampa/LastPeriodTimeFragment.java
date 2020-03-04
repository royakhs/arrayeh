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
import android.widget.NumberPicker;

import com.google.android.material.bottomappbar.BottomAppBar;


public class LastPeriodTimeFragment extends Fragment {
private AppCompatButton btnOk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_last_period_time, container, false);
        btnOk=view.findViewById(R.id.btnOK);
        NumberPicker yearPicker = view.findViewById(R.id.yearPicker);
        NumberPicker monthPicker = view.findViewById(R.id.monthPicker);
        NumberPicker dayPicker = view.findViewById(R.id.dayPicker);
        String[] year3char = get3CharYears();
        String[] month3char = get3CharMonth();
        String[]day3char = get3CharMonth();
        yearPicker.setMaxValue(year3char.length - 1); // important
        yearPicker.setDisplayedValues(year3char); // custom values
        monthPicker.setMaxValue(month3char.length - 1); // important
        monthPicker.setDisplayedValues(month3char);
        dayPicker.setMaxValue(day3char.length - 1); // important
        dayPicker.setDisplayedValues(day3char);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if(activity instanceof MainActivity){
                    MainActivity myactivity = (MainActivity) activity;
                    myactivity.loadBabyGenderFragment();
                }
            }
        });

        return view;
    }
    private String[] get3CharYears() {
        String[] years = new String[2];
        for (int i=0; i<years.length;i++){
            years[i]=String.valueOf(i+1398);
        }
        return years;
    }
    private String[] get3CharMonth() {
        String[] months= new String[12];
        for (int i=0; i<months.length;i++){
            months[i]=String.valueOf(i+1);
        }
        return months;
    }
    private String[] get3CharDay() {
        String[] days = new String[31];
        for (int i=0; i<days.length;i++){
            days[i]=String.valueOf(i+1);
        }
        return days;
    }

}
