package com.example.employeeretrofit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeretrofit.Mofdels.EmployeeList;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder>  {
    List<EmployeeList>empllist;
    Context  context;

    public DataAdapter(List<EmployeeList> empllist, Context context) {
        this.empllist = empllist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_employeedesign,viewGroup,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.empnameh.setText(empllist.get(i).getEmployee_name());
        myViewHolder.empageh.setText(empllist.get(i).getEmployee_age());
        myViewHolder.empsalaryh.setText(empllist.get(i).getEmployee_salary());

        myViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Empdetails.class);

                String userid=empllist.get(i).getId();
                Toast.makeText(context, "USER ID "+userid, Toast.LENGTH_SHORT).show();
                SharedPreferences shared=context.getSharedPreferences("pref",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("key1",userid);
                editor.apply();
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return empllist.size();
    }

   public class MyViewHolder extends RecyclerView.ViewHolder{
TextView empnameh,empageh,empsalaryh;

View mView;
    public  MyViewHolder(@NonNull View itemView) {
        super(itemView);
        empnameh=itemView.findViewById(R.id.empnamex);
        empageh=itemView.findViewById(R.id.empagex);
        empsalaryh=itemView.findViewById(R.id.empsalaryx);
        mView=itemView;

    }
}
}
