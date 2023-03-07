package com.example.meethall.ui.EmployeeDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.meethall.R;
import com.example.meethall.databinding.ActivityEmpDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class emp_dashboard extends AppCompatActivity {

    ActivityEmpDashboardBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivityEmpDashboardBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);

        BottomNavigationView bottomNavigationView = findViewById(R.id.teacher_bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        bottomNavigationView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.staff_fragment_container, new EmpHomeFragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id. emp_home:
                    selectedFragment = new EmpHomeFragment();
                    break;

                case R.id.emp_meeting:
                    selectedFragment = new EmpMeetingFragment();
                    break;

                case R.id.emp_history:
                    selectedFragment = new EmpHistoryFragment();
                    break;

                case R.id.emp_account:
                    selectedFragment = new EmpAccountFragment();
                    break;


            }

            // DASHBOARD fragment ko replace kaarne ke liye hai
            getSupportFragmentManager().beginTransaction().replace(R.id.staff_fragment_container, selectedFragment).commit();

            return true;
        }
    };
}