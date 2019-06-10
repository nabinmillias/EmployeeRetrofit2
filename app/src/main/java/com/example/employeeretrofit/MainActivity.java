package com.example.employeeretrofit;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.employeeretrofit.Mofdels.EmployeeList;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   // SpotsDialog.Builder alertDialog;

    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialog=new SpotsDialog(this);
       // alertDialog=new  SpotsDialog(this);

dialog.show();

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

                    dialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<EmployeeList>> call, Throwable t) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
