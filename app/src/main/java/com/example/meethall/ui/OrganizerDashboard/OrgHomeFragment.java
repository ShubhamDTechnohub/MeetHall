package com.example.meethall.ui.OrganizerDashboard;

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
import com.example.meethall.databinding.FragmentOrgHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class OrgHomeFragment extends Fragment {

    FragmentOrgHomeBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        bind = FragmentOrgHomeBinding.inflate(inflater,container,false);
        return bind.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageSlider imageSlider = bind.imageSlider;
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://www.nordantech.com/media/pages/blog/community/8-tipps-fuer-ein-erfolgreiches-meeting/00022d9063-1643812301/meeting-tipps-erfolgreich-1200x630.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.insperity.com/wp-content/uploads/The-Secrets-to-a-Successful-Off-site-Meeting-640x302-2.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://as1.ftcdn.net/jpg/03/64/90/68/220_F_364906832_3CWsp5oXzh8oauRKz7SYtPfCZ57JfESZ.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


    }
}