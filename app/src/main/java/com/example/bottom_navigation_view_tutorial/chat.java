package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity {
    boolean flag ;
    DatabaseReference databaseReference ;
    DatabaseReference databaseReferenceForRetrive ;
    RecyclerView messegeRecyclerViewId ;

    EditText messageEdtTxt ;
    Button sendBtn ;

    List<Messege> messegeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent previousIntent = getIntent() ;
        Bundle bundle = previousIntent.getExtras();
        String myEmail= bundle.getString("myEmail");
        String friendEmail = bundle.getString("friendEmail") ;

        Toast.makeText(getApplicationContext(),myEmail +" " + friendEmail,Toast.LENGTH_SHORT).show() ;

        messageEdtTxt = findViewById(R.id.messageEdtTxt) ;
        sendBtn = findViewById(R.id.sendBtn) ;
        messegeRecyclerViewId = findViewById(R.id.messegeRecyclerViewId) ;



        messegeRecyclerViewId.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MessageRecyclerViewAdapter messageRecyclerViewAdapter = new MessageRecyclerViewAdapter(getApplicationContext(),messegeList,myEmail) ;

        databaseReferenceForRetrive = FirebaseDatabase.getInstance().getReference("Messeges") ;
        databaseReferenceForRetrive.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messegeList.clear() ;
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    String text = dataSnapshot.child("message").getValue(String.class);
                    String receiver = dataSnapshot.child("recevier").getValue(String.class) ;
                    String sender = dataSnapshot.child("sender").getValue(String.class) ;
                    long timeStamp = dataSnapshot.child("timestamp").getValue(Long.class) ;

                    if((sender.equals(myEmail) && receiver.equals(friendEmail)) || (sender.equals(friendEmail) && receiver.equals(myEmail)))
                    {
                        messegeList.add(new Messege(text,sender,receiver,timeStamp)) ;
                    }

                }
                messageRecyclerViewAdapter.notifyDataSetChanged();
                messegeRecyclerViewId.setAdapter(messageRecyclerViewAdapter);
                messegeRecyclerViewId.scrollToPosition(messageRecyclerViewAdapter.getItemCount()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }) ;





        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = messageEdtTxt.getText().toString().trim() ;
                messegeList.clear() ;
                if (!text.isEmpty()) {
                    Messege messege = new Messege(text,myEmail,friendEmail,System.currentTimeMillis()) ;
                    FirebaseDatabaseHelper.savedMessege(messege);
                    messegeList.add(messege) ;
                    messageRecyclerViewAdapter.notifyDataSetChanged();
                    messegeRecyclerViewId.setAdapter(messageRecyclerViewAdapter);
                    messegeRecyclerViewId.scrollToPosition(messageRecyclerViewAdapter.getItemCount()-1);
                    Toast.makeText(getApplicationContext(),"send message ",Toast.LENGTH_SHORT).show() ;
                    messageEdtTxt.setText("");
                    messegeList.clear() ;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"send not message ",Toast.LENGTH_SHORT).show() ;

                }

            }
        });








    }
}