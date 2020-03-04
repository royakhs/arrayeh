package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.arayeh.hampa.R;


public class SlideFragment extends Fragment {
    private  ImageView mImgSlide;
    private int imgID;

    public SlideFragment(int imgID) {
        this.imgID = imgID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        mImgSlide = view.findViewById(R.id.imgSlide);
        mImgSlide.setImageResource(imgID);

        return view;
    }

}
