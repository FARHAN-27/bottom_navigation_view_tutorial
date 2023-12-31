package com.example.bottom_navigation_view_tutorial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class doctorRecyclerViewAdapter extends  RecyclerView.Adapter<doctorRecyclerViewAdapter.ViewHolder> {

    private List<Doctor> doctorList;
    private Context context ;

    public doctorRecyclerViewAdapter(){}

    public doctorRecyclerViewAdapter(Context context , List<Doctor> doctorList) {
        this.doctorList = doctorList;
        this.context = context ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to convert layout to view or inflate a view then we use layout inflater class
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_doctor, parent, false);
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor doctor = doctorList.get(position) ;
        holder.nameTxtView.setText(doctor.getName());
        holder.degreeTxtView.setText(doctor.getDegree());
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Appointment done",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Appointment.class) ;
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView nameTxtView , degreeTxtView ;
        public Button addBtn ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTxtView = itemView.findViewById(R.id.nameTxtView) ;
            degreeTxtView = itemView.findViewById(R.id.degreeTxtView);
            addBtn = itemView.findViewById(R.id.addBtn) ;


        }
    }
}
