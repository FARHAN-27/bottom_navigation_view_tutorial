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

        patientList = new ArrayList<Patient>() ;
        patientList.add(new Patient("Kufu Mia","31","kufu@gmail.com","123456") ) ;
        patientAdapter  = new patientListViewAdapter(show_patient.this,patientList) ;



//        FirebaseApp.initializeApp(getApplicationContext()) ;

         databaseReference = FirebaseDatabase.getInstance().getReference("Patient");
//        String patient_id = databaseReference.push().getKey() ;



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
//                    Patient patient = dataSnapshot.child("Patient").getValue(Patient.class) ;
//                    if(patient!=null)
//                    {
//                        patientList.add(patient) ;
//                        Log.d("new_inside_DB","Patient" + patient.toString()) ;
//                    }
                    String name = dataSnapshot.child("name").getValue(String.class) ;
                    String age = dataSnapshot.child("age").getValue(String.class) ;
                    String email = dataSnapshot.child("email").getValue(String.class) ;
                    String password = dataSnapshot.child("password").getValue(String.class) ;
                    Patient patient = new Patient(name,age,email,password) ;
                    patientList.add(patient) ;
                }
//                Log.d("new_inside_DB","Patient list " + patientList.toString()) ;
//                patientAdapter.notifyDataSetChanged();
                listViewId.setAdapter(patientAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("DBError"," cann't access " + error.toString()) ;
            }
        }) ;




//        listViewId.setAdapter(patientAdapter);
    }


}