package com.example.meethall.ui.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.meethall.databinding.ActivityOrgListBinding;

public class org_list extends AppCompatActivity {
    ActivityOrgListBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityOrgListBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);

        bind.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}