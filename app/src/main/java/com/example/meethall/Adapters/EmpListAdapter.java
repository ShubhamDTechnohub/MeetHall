package com.example.meethall.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meethall.Models.EmpListModel;
import com.example.meethall.R;

import java.util.ArrayList;

public class EmpListAdapter extends RecyclerView.Adapter<EmpListAdapter.EmpHolder> {

    Context context;
    ArrayList<EmpListModel> empList = new ArrayList<>();

    public EmpListAdapter(Context context, ArrayList<EmpListModel> empList) {
        this.context = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public EmpListAdapter.EmpHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_list_layout, parent, false);
        return new EmpHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpListAdapter.EmpHolder holder, int position) {

        holder.empId.setText(empList.get(position).getEmp_id());
        holder.empName.setText(empList.get(position).getEmp_name());
        holder.empPost.setText(empList.get(position).getEmp_post());
//        holder.setMeeting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(v.getContext(), R.style.MaterialAlertDialog_Rounded);
//                LayoutInflater inflater1 = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View team = inflater1.inflate(R.layout.logout_layout, null);
//                builder.setView(team);
//                builder.setCancelable(false);
//
//                Button logout = team.findViewById(R.id.logout_btn);
//                Button no = team.findViewById(R.id.no_btn);
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//
//                logout.setOnClickListener(v1 -> checkUserDetailPreference.LogOutUser(v.getContext(), "out", dialog));
//
//                no.setOnClickListener(v12 -> dialog.cancel());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public class EmpHolder extends RecyclerView.ViewHolder {

        TextView empId,empName,empPost;


        public EmpHolder(@NonNull View emp) {
            super(emp);

            empId = emp.findViewById(R.id.emp_id);
            empName = emp.findViewById(R.id.emp_name);
            empPost = emp.findViewById(R.id.emp_post);



        }
    }
}