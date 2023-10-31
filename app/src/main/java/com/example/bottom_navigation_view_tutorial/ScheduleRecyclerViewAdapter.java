package com.example.bottom_navigation_view_tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ViewHolder> {

    List<Schedule> scheduleList = new ArrayList<>() ;
    Context context ;

    public ScheduleRecyclerViewAdapter(Context context , List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ScheduleRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // here converted a layout to a view
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_schedule,parent,false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleRecyclerViewAdapter.ViewHolder holder, int position) {
        Schedule schedule = scheduleList.get(position) ;
        holder.agendaTxtView.setText(schedule.getAgenda());
        holder.dateTxtview.setText(schedule.getDate());
        holder.timeTxtView.setText(schedule.getTime()) ;

        // kono button thakle or action ekhane set korte hobe .
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }


    // view + (TextView , button , EditTxt,) = viewHolder ;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView agendaTxtView , dateTxtview , timeTxtView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            agendaTxtView  = itemView.findViewById(R.id.agendaTxtView) ;
            dateTxtview = itemView.findViewById(R.id.dateTxtView) ;
            timeTxtView = itemView.findViewById(R.id.timeTxtView) ;
        }
    }
}
