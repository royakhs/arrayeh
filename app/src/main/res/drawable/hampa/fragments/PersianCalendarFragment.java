package com.arayeh.hampa.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.arayeh.hampa.Interfaces.SelectDateClick;
import com.arayeh.hampa.R;
import com.arayeh.hampa.models.IranianDate;
import com.arayeh.hampa.utils.CalendarTool;
import com.arayeh.hampa.utils.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressLint({"ValidFragment", "ParcelCreator"})
public class PersianCalendarFragment extends Fragment implements SelectDateClick {
    private IranianDate selectedDate;
    private SelectDateClick caller;
    @BindView(R.id.container)
    ViewPager mViewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_persian_calendar, container, false);
        ButterKnife.bind(this, view);
        Bundle arge = this.getArguments();
        this.selectedDate = (IranianDate) arge.get("DATE");
        this.caller = (SelectDateClick) arge.get("CALLER");
//
        ViewPagerAdapter mCalendarPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mCalendarPagerAdapter.setFragmentList(initDataForAdapters());
        mViewPager.setAdapter(mCalendarPagerAdapter);
        return view;
    }

    private List<Fragment> initDataForAdapters() {
        CalendarTool calendarTool = new CalendarTool();
        List<Fragment> fragments = new ArrayList<>();
        for (int i = calendarTool.getIranianMonth(); 0 < i; i--) {
            Bundle args = new Bundle();
            args.putInt("YEAR", calendarTool.getIranianYear());
            args.putInt("MONTH", i);
            args.putParcelable("DATE", selectedDate);
            args.putParcelable("CALLER", this);
            CalendarFragment calendarFragment = new CalendarFragment();
            calendarFragment.setArguments(args);
            fragments.add(calendarFragment);
        }

        for (int i = calendarTool.getIranianYear() - 1; (calendarTool.getIranianYear() - 5) < i; i--) {
            for (int j = 12; 0 < j; j--) {
                Bundle args = new Bundle();
                args.putInt("YEAR", i);
                args.putInt("MONTH", j);
                args.putParcelable("DATE", selectedDate);
                args.putParcelable("CALLER", this);
                CalendarFragment calendarFragment = new CalendarFragment();
                calendarFragment.setArguments(args);
                fragments.add(calendarFragment);
                fragments.add(calendarFragment);
            }
        }
        return fragments;
    }

    //
    @Override
    public void onDateClick(IranianDate selectedDate) {
        this.selectedDate = selectedDate;
        caller.onDateClick(selectedDate);
        //  dismiss();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

//    public class CalendarPagerAdapter extends FragmentPagerAdapter {
//        private List<Fragment> fragments;
//
//        private CalendarPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
//            super(fm);
//            this.fragments = fragments;
//        }
//
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "SECTION 1";
//                case 1:
//
//                    return "SECTION 2";
//                case 2:
//
//                    return "SECTION 3";
//                case 3:
//
//                    return "SECTION 4";
//                case 4:
//                    return "SECTION 5";
//            }
//            return null;
//        }
//
//        @NonNull
//        @Override
//        public Fragment getItem(int i) {
//            return fragments.get(i);
//        }
//    }
}
