package com.example.employeeretrofit;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.employeeretrofit.Mofdels.EmployeeList;
import com.example.employeeretrofit.Mofdels.Employeedis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Empdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empdetails);
        final TextView tvname=findViewById(R.id.txtname);
        final TextView tvsala=findViewById(R.id.txtsala);
        final TextView tvage=findViewById(R.id.txtage);
       // Utils Utilss = new Utils();
        SharedPreferences shared=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        final String id_str=shared.getString("key1",null);
        Utils Utilss = new Utils();
        Call<Employeedis> employeeListCall = Utilss.getApi().empdiscall(id_str);
    employeeListCall.enqueue(new Callback<Employeedis>() {
        @Override
        public void onResponse(Call<Employeedis> call, Response<Employeedis> response) {
            String name=response.body().getEmployee_name();
            String salary=response.body().getEmployee_salary();
            String age=response.body().getEmployee_age();
            tvname.setText(name);
            tvsala.setText(salary);
            tvage.setText(age);
        }

        @Override
        public void onFailure(Call<Employeedis> call, Throwable t) {

        }
    });
    }
}
