package com.example.employeeretrofit;

import com.example.employeeretrofit.Mofdels.EmployeeList;
import com.example.employeeretrofit.Mofdels.Employeedis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
@GET("api/v1/employees")

    Call<List<EmployeeList>>empcall();
@GET("api/v1/employee/{id}")

    Call<Employeedis>empdiscall(@Path("id") String id);
}
