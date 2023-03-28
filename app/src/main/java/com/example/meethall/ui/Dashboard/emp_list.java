package com.example.meethall.ui.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.meethall.Adapters.EmpListAdapter;
import com.example.meethall.Api.Constant;
import com.example.meethall.Models.EmpListModel;
import com.example.meethall.databinding.ActivityEmpListBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class emp_list extends AppCompatActivity {

    ActivityEmpListBinding bind;
    EmpListAdapter adapter;
    ArrayList<EmpListModel>list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivityEmpListBinding.inflate(getLayoutInflater());
        View view = bind.getRoot();
        setContentView(view);

        



        bind.empListRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new EmpListAdapter(this, list);

        bind.empListRecyclerView.setAdapter(adapter);

        bind.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bind.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getEmpList();
            }
        });

        bind.searchEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        getEmpList();

    }

    private void getEmpList() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constant.EMP_LIST_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                Log.d("res", "onResponse: "+response);

                    try {
                        JSONArray emp_details =response.getJSONArray("emp_details");

                        for (int i=0;i<emp_details.length();i++){
                            JSONObject jobj=emp_details.getJSONObject(i);
                            String id=jobj.getString("id");
                            String name=jobj.getString("name");
                            String position=jobj.getString("position");


                            EmpListModel model=new EmpListModel(id,name,position);
                            list.add(model);


                        }


                    } catch (JSONException e) {
                        throw new RuntimeException(e);

                    }

                    adapter = new EmpListAdapter(getApplicationContext(), list);
                    bind.empListRecyclerView.setAdapter(adapter);
                if (bind.refresh.isRefreshing()){
                    bind.refresh.setRefreshing(false);
                    Toast.makeText(emp_list.this, "Refreshed", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (bind.refresh.isRefreshing()){
                    bind.refresh.setRefreshing(false);
                }
                Log.d("TAG", "onError: " +error.getMessage());
                bind.noResult.setVisibility(View.VISIBLE);
                bind.empListRecyclerView.setVisibility(View.GONE);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String>header=new HashMap<>();
                header.put("User-Agent","Mozilla/5.0");
                return header;
            }
        };

        queue.add(jsonObjectRequest);
    }


}
