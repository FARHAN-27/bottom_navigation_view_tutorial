package com.example.bottom_navigation_view_tutorial;

import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MessengerMemberRecyclerViewAdapter extends RecyclerView.Adapter<MessengerMemberRecyclerViewAdapter.ViewHolder> {
    public List<String> peopleList = new ArrayList<>() ;
    public Context context ;



    public MessengerMemberRecyclerViewAdapter(Context context,List<String> peopleList) {
        this.peopleList = peopleList;
        this.context = context ;

    }

    @NonNull
    @Override
    public MessengerMemberRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.item_people,parent,false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;

        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MessengerMemberRecyclerViewAdapter.ViewHolder holder, int position) {
        String name = peopleList.get(position) ;
        holder.nameBtn.setText(name);

        holder.nameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, chat.class) ;
                context.startActivity(intent) ;
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.peopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatButton nameBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameBtn = itemView.findViewById(R.id.nameBtn) ;
        }
    }
}
