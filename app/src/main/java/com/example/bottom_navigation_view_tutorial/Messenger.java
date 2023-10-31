package com.example.bottom_navigation_view_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Messenger extends AppCompatActivity {
    RecyclerView messengerMemberRecyclerViewId ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        messengerMemberRecyclerViewId = findViewById(R.id.messengerMemberRecyclerViewId) ;

        List<String> peopleList = new ArrayList<>() ;
        peopleList.add("rokon") ;
        peopleList.add("khokon") ;
        peopleList.add("rifat") ;

        try
        {
            messengerMemberRecyclerViewId.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            MessengerMemberRecyclerViewAdapter messengerMemberRecyclerViewAdapter = new MessengerMemberRecyclerViewAdapter(this,peopleList) ;
            messengerMemberRecyclerViewId.setAdapter(messengerMemberRecyclerViewAdapter);
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error to set up peopel ", Toast.LENGTH_SHORT).show() ;
        }
    }


}