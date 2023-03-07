package com.example.meethall.ui.OrganizerDashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meethall.R;
import com.example.meethall.databinding.FragmentOrgHomeBinding;
import com.example.meethall.databinding.FragmentOrgMembersBinding;
import com.example.meethall.ui.AddEmployee;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class OrgMembersFragment extends Fragment {




    FragmentOrgMembersBinding bind;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind = FragmentOrgMembersBinding.inflate(inflater,container,false);
        return bind.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind.addEmpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getActivity(), AddEmployee.class));
            }
        });
    }
}