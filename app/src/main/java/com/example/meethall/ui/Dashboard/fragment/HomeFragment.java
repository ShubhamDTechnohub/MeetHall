package com.example.meethall.ui.Dashboard.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.meethall.R;
import com.example.meethall.databinding.FragmentHomeBinding;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {



    FragmentHomeBinding bind;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentHomeBinding.inflate(inflater);


        MaterialToolbar toolbar = (MaterialToolbar) getActivity().findViewById(R.id.topAppBar);

        toolbar.setTitle("Dashboard");

        String type = String.valueOf(requireActivity().getIntent().hasExtra("type"));

        if (type.equals("employee")){
            toolbar.setTitle("Employee Home");
        } else if (type.equals("admin")) {
            toolbar.setTitle("Admin Home");
        }else if (type.equals("organiser")) {
            toolbar.setTitle("Organizer Home");
        }
        ImageSlider imageSlider = bind.imageSlider;
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://img.freepik.com/free-photo/group-diverse-people-having-business-meeting_53876-25060.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://lh5.googleusercontent.com/p/AF1QipO0SKciR6pZlUgKDdQWiuLohTbmdw76jP5-dOQ_=w630-h240-k-no", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.incimages.com/uploaded_files/image/1920x1080/getty_473909426_129584.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://lexpeeps.in/wp-content/uploads/2020/05/1024px-Secretary_Kerry_Hosts_the_Quarterly_Millennium_Challenge_Corp_MCC_Board_of_Directors_Meeting-1024x425.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return bind.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}