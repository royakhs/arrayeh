package com.arayeh.hampa.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.Interfaces.SelectDateClick;
import com.arayeh.hampa.R;
import com.arayeh.hampa.models.Consultant;
import com.arayeh.hampa.models.IranianDate;
import com.arayeh.hampa.utils.CalendarTool;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint({"ValidFragment", "ParcelCreator"})
public class ConsultantListFragment extends Fragment implements SelectDateClick {
    @BindView(R.id.fl_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edtSelectedDay)
    EditText mEdtSelectedDay;
    @BindView(R.id.imgChowCalender)
    ImageView imgShowCalender;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private IranianDate iranianDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_consultant_list, container, false);
        ButterKnife.bind(this, v);
        imgShowCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCalenderFragment();
            }
        });
        loadCalenderFragment();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        final List<Consultant> consultants;
        consultants = new ArrayList<>();
        consultants.add(new Consultant("محمد رضا مرادی", "ونک، خیابان سعید، کوچه دوازدهم",
                "02165565", R.drawable.ic_pic1));
        consultants.add(new Consultant("محمد رضا مرادی", "ونک، خیابان سعید، کوچه دوازدهم",
                "02165565", R.drawable.ic_pic2));
        consultants.add(new Consultant("محمد رضا مرادی", "ونک، خیابان سعید، کوچه دوازدهم",
                "02165565", R.drawable.ic_pic3));
        consultants.add(new Consultant("محمد رضا مرادی", "ونک، خیابان سعید، کوچه دوازدهم",
                "02165565", R.drawable.ic_pic4));
        consultants.add(new Consultant("محمد رضا مرادی", "ونک، خیابان سعید، کوچه دوازدهم",
                "02165565", R.drawable.ic_pic5));
        iranianDate = new IranianDate();
        CalendarTool calendarTool = new CalendarTool();
        mEdtSelectedDay.setText(calendarTool.getIranianDate());
        iranianDate.setDay(calendarTool.getIranianDay());
        iranianDate.setMonth(calendarTool.getIranianMonth());
        iranianDate.setYear(calendarTool.getIranianYear());
        loadCalenderFragment();
        return v;
    }

    private void loadCalenderFragment() {
        PersianCalendarFragment myf = new PersianCalendarFragment();
        Bundle args = new Bundle();
        args.putParcelable("DATE", iranianDate);
        args.putParcelable("CALLER", this);
        myf.setArguments(args);
        //  myf.show(getChildFragmentManager(),"");
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, myf);
        transaction.commit();
    }

    @Override
    public void onDateClick(IranianDate selectedDate) {
        this.iranianDate = selectedDate;
        mEdtSelectedDay.setText(String.valueOf(iranianDate.getYear()) + "/" +
                String.valueOf(iranianDate.getMonth()) + "/" + String.valueOf(iranianDate.getDay()));
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
