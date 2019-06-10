package com.example.employeeretrofit;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.employeeretrofit.Mofdels.EmployeeList;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // alertDialog=new  SpotsDialog(this);


        final RecyclerView recyclerview = findViewById(R.id.rvxml);
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutmanager);


            Utils Utilss = new Utils();
            Call<List<EmployeeList>> employeeListCall = Utilss.getApi().empcall();
            employeeListCall.enqueue(new Callback<List<EmployeeList>>() {
                @Override
                public void onResponse(Call<List<EmployeeList>> call, Response<List<EmployeeList>> response) {
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    LinearLayoutManager verticalLayoutmanager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                    recyclerview.setLayoutManager(verticalLayoutmanager);

                    DataAdapter adpt=new DataAdapter((ArrayList<EmployeeList>) response.body(),MainActivity.this);
                    recyclerview.setAdapter(adpt);
                }

                @Override
                public void onFailure(Call<List<EmployeeList>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
