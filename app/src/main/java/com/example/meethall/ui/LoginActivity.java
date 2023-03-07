package com.example.meethall.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.meethall.R;
import com.example.meethall.databinding.ActivityEmpDashboardBinding;
import com.example.meethall.databinding.ActivityLoginBinding;
import com.example.meethall.ui.EmployeeDashboard.emp_dashboard;
import com.example.meethall.ui.OrganizerDashboard.org_dashboard;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);

        bind.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, emp_dashboard.class));
            }
        });
        bind.loginOrgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, org_dashboard.class));
            }
        });
    }
}