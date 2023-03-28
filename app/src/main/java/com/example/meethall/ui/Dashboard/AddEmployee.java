package com.example.meethall.ui.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.meethall.R;
import com.example.meethall.databinding.ActivityAddEmployeeBinding;

public class AddEmployee extends AppCompatActivity {

    ArrayAdapter<String> positionAdapter;
    String []positionItem = {"Organizer", "HR", "Manager", "Designer", "Tester", "Sales Manager", "Software Engineer", "Android Developer", "Web Developer", "Accountant", "Digital Marketer"};

    ArrayAdapter<String> genderAdapter;
    String []genderItem = {"Male", "Female"};

    ActivityAddEmployeeBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityAddEmployeeBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);


        genderAdapter= new ArrayAdapter<>(this, R.layout.list_item, genderItem);
        positionAdapter= new ArrayAdapter<>(this, R.layout.list_item, positionItem);

        bind.empGender.setAdapter(genderAdapter);
        bind.empPosition.setAdapter(positionAdapter);

        bind.empGender.setOnItemClickListener((parent, view1, position, id) -> {
            if(position==0){
            }
        });

        bind.empPosition.setOnItemClickListener((parent, view12, position, id) -> {
            if(position==0){
            }
        });

        bind.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}