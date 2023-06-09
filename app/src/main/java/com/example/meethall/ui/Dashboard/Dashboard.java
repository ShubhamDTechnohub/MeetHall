package com.example.meethall.ui.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.meethall.R;

import com.example.meethall.databinding.ActivityDashboardBinding;
import com.example.meethall.ui.Dashboard.fragment.HomeFragment;
import com.example.meethall.ui.Dashboard.fragment.MeetingFragment;
import com.example.meethall.ui.Dashboard.fragment.ProfileFragment;
import com.example.meethall.ui.Dashboard.fragment.SupportFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

    private ActivityDashboardBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);
        String type = getIntent().getStringExtra("type");


        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        bottomNavigationView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            drawerLayout.closeDrawer(GravityCompat.START);
            switch (id) {

                case R.id.hallManagement:
                    startActivity(new Intent(Dashboard.this, room_list.class));
                    break;

                case R.id.employeeList:
                    startActivity(new Intent(Dashboard.this, emp_list.class));
                    break;

                case R.id.organizerList:
                    startActivity(new Intent(Dashboard.this, org_list.class));
                    break;


                default:
                    return true;

            }
            return true;
        });


    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.meeting:
                    selectedFragment = new MeetingFragment();
                    break;

                case R.id.account:
                    selectedFragment = new ProfileFragment();
                    break;

                case R.id.support:
                    selectedFragment = new SupportFragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };


}