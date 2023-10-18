package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class show_patient extends AppCompatActivity {

    DatabaseReference databaseReference ;

    private List<Patient> patientList ;
    private patientListViewAdapter patientAdapter ;
    ListView listViewId ;
    Button showPatientBtn ;
    TextView nameTxt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);
        showPatientBtn = findViewById(R.id.showPatientBtn) ;
        listViewId = findViewById(R.id.listViewId) ;

//        FirebaseApp.initializeApp(getApplicationContext()) ;
        FirebaseDatabase database = FirebaseDatabase.getInstance() ;
        DatabaseReference databaseReference = database.getReference().child("Patient") ;

        patientList = new ArrayList<Patient>() ;
        patientList.add(new Patient("rokon","21","rokon@gmail.com","123456") ) ;

        patientAdapter  = new patientListViewAdapter(show_patient.this,patientList) ;

        Log.d("check_d","faile to access database") ;

        System.out.println("eorjeroejeojroejoejefldjfdrle") ;
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                patientList.clear() ;
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Patient patient = snapshot.getValue(Patient.class) ;
                    patientList.add(patient) ;
                }
                listViewId.setAdapter(patientAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listViewId.setAdapter(patientAdapter);
            }
        }) ;
    }
}