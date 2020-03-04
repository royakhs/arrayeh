package com.arayeh.hampa.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.arayeh.hampa.Interfaces.SelectDateClick;
import com.arayeh.hampa.R;
import com.arayeh.hampa.models.IranianDate;
import com.arayeh.hampa.utils.CalendarTool;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint("ValidFragment")
public class CalendarFragment extends Fragment {
    private int year;
    private int month;
    @BindView(R.id.tDateTime)TextView mTDateTime;
//    private TextView mTDateTime;
    private IranianDate selectedDate;
    private int selectedDay;
    private SelectDateClick caller;
    private int selectedID = 0;
    private CalendarTool calendarTool;
    private int isDateIn = 0;
    private int endDay=31;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.calender_month, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle=this.getArguments();
        this.year = bundle.getInt("YEAR");
        this.month=bundle.getInt("MONTH");
        this.selectedDate=bundle.getParcelable("DATE");
        this.caller=bundle.getParcelable("CALLER");
        if(6<month){
            if(month!=12)
                endDay=30;
            else {
                if(year!=1395&&year!=1399&&year!=1403&&year!=1407){
                    endDay=29;
                }
                else {
                    endDay=30;
                }
            }
        }
        calendarTool = new CalendarTool();
        if (calendarTool.getIranianYear() == year && calendarTool.getIranianMonth() == month) {
            isDateIn = calendarTool.getIranianDay();
        }
        calendarTool.setIranianDate(year, month, 1);
        for (int i = 0; i < 7; i++) {
            setViewData(i - calendarTool.getIranianWeekDay() + 1, i, view);
        }
        mTDateTime.setText(getMonth(month) + "\t" + year);
        return view;
    }

    private void setViewData(int startDayoflayout, int layoutTag, final View v) {
        int a = startDayoflayout;
        LinearLayout linearLayout = v.findViewWithTag(String.valueOf(layoutTag));
        for (int i = 1; i < 7; i++) {
            if (endDay < a) {

                ((AppCompatButton) linearLayout.getChildAt(i)).setBackgroundColor(getResources().getColor(R.color.colorDeepPurpleLight));
                //((AppCompatButton) linearLayout.getChildAt(i)).setVisibility(View.INVISIBLE);

                continue;
            }
            if (a <= 0) {
                ((AppCompatButton) linearLayout.getChildAt(i)).setBackgroundColor(getResources().getColor(R.color.colorDeepPurpleLight));
                //  ((AppCompatButton) linearLayout.getChildAt(i)).setVisibility(View.INVISIBLE);
                a = a + 7;
                continue;
            }
            if (a == isDateIn) {
                ((AppCompatButton) linearLayout.getChildAt(i)).setBackgroundColor(getResources().getColor(R.color.colorTealDark));
            }
            ((AppCompatButton) linearLayout.getChildAt(i)).setText(String.valueOf(a));
            ((AppCompatButton) linearLayout.getChildAt(i)).setId(a);
            ((AppCompatButton) linearLayout.getChildAt(i)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                    if (0 < selectedID){
                        if (isDateIn == selectedID)
                            v.findViewById(selectedID).setBackgroundColor(getResources().getColor(R.color.colorTealDark));
                        else
                            v.findViewById(selectedID).setBackgroundColor(getResources().getColor(R.color.colorBlueGrey));
                    }

                    selectedID = view.getId();
                    selectedDate.setDate(year,month,selectedID);
                    caller.onDateClick(selectedDate);


                }
            });
            a = a + 7;
        }
    }


    public String getMonth(int month) {
        switch (month) {
            case 1:
                return "فروردین";
            case 2:
                return "اردیبهشت";
            case 3:
                return "خرداد";
            case 4:
                return "تیر";
            case 5:
                return "مرداد";
            case 6:
                return "شهریور";
            case 7:
                return "مهر";
            case 8:
                return "آبان";
            case 9:
                return "آذر";
            case 10:
                return "دی";
            case 11:
                return "بهمن";
            case 12:
                return "اسفند";
        }
        return "";
    }

//    public void addButtons() {
//        CalendarTool calendarTool = new CalendarTool();
//        // calendarTool.get
//    }

//    public void addButtons(final int year, final int month, boolean isDateIn) {
//        final List<Button> buttonList = new ArrayList<>();
//        final List<LinearLayout> linearLayouts = new ArrayList<>();
//        List<Integer> values1 = new ArrayList<>();
//        List<Integer> values2 = new ArrayList<>();
//        List<Integer> values3 = new ArrayList<>();
//        values1.add(1);
//        values2.add(7);
//        values1.add(2);
//        values2.add(8);
//        values1.add(3);
//        values2.add(9);
//        values1.add(4);
//        values2.add(10);
//        values1.add(5);
//        values2.add(11);
//        values1.add(6);
//        values3.add(1);
//        values3.add(5);
//        values3.add(9);
//        values3.add(13);
//        values3.add(17);
//        values3.add(22);
//        values3.add(26);
//        values3.add(30);
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        width = (int) (displayMetrics.widthPixels / displayMetrics.xdpi) * 160;
//        LinearLayout headerLayout = new LinearLayout(getActivity().getApplicationContext());
//        headerLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        headerLayout.setHorizontalGravity(1);
//        for (int j = 0; j < 7; j++) {
//            TextView txtDate = new TextView(getActivity().getApplicationContext());
//        }
//        for (int i = 0; i < 5; i++) {
//            LinearLayout linearLayout = new LinearLayout(getActivity().getApplicationContext());
//            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            linearLayout.setHorizontalGravity(1);
//            for (int j = 0; j < 7; j++) {
//                Button btnTag = new Button(getActivity().getApplicationContext());
//
//                if (600 < width) {
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(displayMetrics.widthPixels / 20, displayMetrics.widthPixels / 20);
//                    params.setMargins(displayMetrics.widthPixels / 40, 4, displayMetrics.widthPixels / 40, 4);
//                    btnTag.setLayoutParams(params);
//                    btnTag.setBackground(null);
//                    btnTag.setId((i * 7) + j + 1);
//                    btnTag.setTextSize(10);
//                } else {
//                    if (400 < width) {
//                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(displayMetrics.widthPixels / 15, displayMetrics.widthPixels / 15);
//                        params.setMargins(displayMetrics.widthPixels / 30, 4, displayMetrics.widthPixels / 30, 4);
//                        btnTag.setLayoutParams(params);
//                        btnTag.setBackground(null);
//                        btnTag.setId((i * 7) + j + 1);
//                        btnTag.setTextSize(10);
//                    } else {
//                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(displayMetrics.widthPixels / 10, displayMetrics.widthPixels / 10);
//                        params.setMargins(8, 4, 8, 4);
//                        btnTag.setLayoutParams(params);
//                        btnTag.setBackground(null);
//                        btnTag.setId((i * 7) + j + 1);
//                        btnTag.setTextSize(8);
//                    }
//
//                }
//
//                btnTag.setTextColor(getResources().getColor(R.color.colorBlack));
//                btnTag.setText(String.valueOf((i * 7) + j + 1));
//                linearLayout.addView(btnTag);
//                buttonList.add(btnTag);
//
//                if (values1.contains(month)) {
//                    if (31 <= (i * 7) + j + 1)
//                        break;
//                }
//                if (values1.contains(month)) {
//                    if (31 <= (i * 7) + j + 1)
//                        break;
//                }
//                if (values2.contains(month)) {
//                    if (30 <= (i * 7) + j + 1)
//                        break;
//                }
//                if (month == 12) {
//                    if (values3.contains(year % 33)) {
//                        if (30 <= (i * 7) + j + 1)
//                            break;
//                    } else if (29 <= (i * 7) + j + 1)
//                        break;
//                }
//            }
//            layout.addView(linearLayout);
//            linearLayouts.add(linearLayout);
//        }
//        final int[] selectedItemID = {0};
//        for (int i = 0; i < buttonList.size(); i++) {
//            final int finalI = i;
//            if (isDateIn) {
//                if (i + 1 == selectedDate.getDay()) {
//                    buttonList.get(i).setBackgroundResource(R.drawable.red_circle_backgraund);
//                    buttonList.get(i).setTextColor(getResources().getColor(R.color.colorYellow));
//                }
//            }
//            buttonList.get(i).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    selectedDate.setDay(finalI + 1);
//                    selectedDate.setYear(year);
//                    selectedDate.setMonth(month);
//                    buttonList.get(finalI).setBackgroundResource(R.drawable.red_circle_backgraund);
//                    buttonList.get(finalI).setTextColor(getResources().getColor(R.color.colorYellow));
//                    caller.onDateClick(selectedDate);
//                }
//            });
//        }
//    }
}
