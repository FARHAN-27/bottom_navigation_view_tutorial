package com.example.bottom_navigation_view_tutorial;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    public static void savePatientInfromation()
    {

    }
    public static  void saveDoctorInformation()
    {

    }

    public static void saveSchedule(String email, Schedule schedule)
    {

    }

    public static void savedMessege(Messege messege) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Messeges") ;
        String messege_id = databaseReference.push().getKey() ;
        databaseReference.child(messege_id).setValue(messege) ;

    }

    public static List<Patient> retrivePatientInfromation()
    {
        List<Patient> patientList = new ArrayList<>() ;

        // retrive data and them into list and then return list ;

        return patientList ;

    }

    public static List<Doctor> retriveDoctorInfromation()
    {
        List<Doctor> doctorList = new ArrayList<>() ;

        // retrive data and them into list and then return list ;

        return doctorList ;

    }
    public static List<Schedule> retriveScheduleInfromation()
    {
        List<Schedule> scheduleList = new ArrayList<>() ;

        // retrive data and them into list and then return list ;

        return scheduleList ;

    }

    public static void userLoginWithEmailAndPassword(String email , String password)
    {

    }

    public static void userCreationAsDoctor()
    {

    }
    public static void userCreationAsPatient()
    {

    }
    public static boolean findUser(String email)
    {
        List<String> user_emails = new ArrayList<>() ;
        boolean flag  = false ;

       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Patient");
//        String patient_id = databaseReference.push().getKey()
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    String name = dataSnapshot.child("name").getValue(String.class) ;

                    String user_email = dataSnapshot.child("email").getValue(String.class) ;
                    user_emails.add(user_email) ;

                }
//


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("DBError"," cann't access " + error.toString()) ;
            }
        }) ;

        for(int i = 0 ; i>user_emails.size() ;i++)
        {
            if(email.equals(user_emails.get(i)))
            {
                flag = true ;
            }
        }

        if(flag==true)
        {
            return true ;
        }
        else return false ;

    }

}
