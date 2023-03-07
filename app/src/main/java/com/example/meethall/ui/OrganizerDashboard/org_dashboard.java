package com.example.meethall.ui.OrganizerDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.meethall.R;
import com.example.meethall.databinding.ActivityEmpDashboardBinding;
import com.example.meethall.databinding.ActivityOrgDashboardBinding;
import com.example.meethall.ui.EmployeeDashboard.EmpAccountFragment;
import com.example.meethall.ui.EmployeeDashboard.EmpHistoryFragment;
import com.example.meethall.ui.EmployeeDashboard.EmpHomeFragment;
import com.example.meethall.ui.EmployeeDashboard.EmpMeetingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class org_dashboard extends AppCompatActivity {

    ActivityOrgDashboardBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityOrgDashboardBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);

        BottomNavigationView bottomNavigationView = findViewById(R.id.org_bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        bottomNavigationView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.org_fragment_container, new OrgHomeFragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id. org_home:
                    selectedFragment = new OrgHomeFragment();
                    break;

                case R.id.org_meeting:
                    selectedFragment = new OrgMeetingFragment();
                    break;

                case R.id.org_member:
                    selectedFragment = new OrgMembersFragment();
                    break;

                case R.id.org_account:
                    selectedFragment = new OrgAccountFragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.org_fragment_container, selectedFragment).commit();

            return true;
        }
    };
}