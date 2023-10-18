package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {

    private FirebaseAuth firebaseAuth ;

    EditText nameEdtTxt , ageEdtTxt , SupEmailEdtTxt , SupPasswordEdtTxt ;
    Button signUpBtn , signInBtn ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        signInBtn = findViewById(R.id.signInBtn) ;
        signUpBtn = findViewById(R.id.signUpBtn) ;

        nameEdtTxt = findViewById(R.id.nameEdtTxt) ;
        ageEdtTxt = findViewById(R.id.ageEdtTxt);
        SupEmailEdtTxt = findViewById(R.id.SupEmailEdtTxt) ;
        SupPasswordEdtTxt = findViewById(R.id.SupPasswordEdtTxt) ;

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class) ;
                startActivity(intent);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               userRegistration() ;
            }
        });
    }

    private  void saveDataToFirebase()
    {
        String name = nameEdtTxt.getText().toString().trim() ;
        String age = ageEdtTxt.getText().toString().trim() ;
        String email = SupEmailEdtTxt.getText().toString().trim() ;
        String password = SupPasswordEdtTxt.getText().toString().trim() ;
        Patient  patient  = new Patient(name,age,email,password) ;

        FirebaseDatabase database = FirebaseDatabase.getInstance() ;
        DatabaseReference databaseReference = database.getReference().child("Patient");
        String patient_id = databaseReference.push().getKey() ;
        databaseReference.child(patient_id).setValue(patient) ;
        Toast.makeText(getApplicationContext(), "saved user data successfully", Toast.LENGTH_SHORT).show();


    }

    private void userRegistration()
    {
        String name = nameEdtTxt.getText().toString().trim() ;
        String age = ageEdtTxt.getText().toString().trim() ;
        String email = SupEmailEdtTxt.getText().toString().trim() ;
        String password = SupPasswordEdtTxt.getText().toString().trim() ;

        if(!name.isEmpty() && !age.isEmpty() && !email.isEmpty() && !password.isEmpty())
        {
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                // save data to firebase :
                                saveDataToFirebase() ;
                                Toast.makeText(getApplicationContext(),"user registration successfull",Toast.LENGTH_SHORT).show() ;
                            }
                            else
                            {
                                if(task.getException() instanceof FirebaseAuthUserCollisionException)
                                {
                                    Toast.makeText(getApplicationContext(),"user alreadry registered",Toast.LENGTH_SHORT).show() ;

                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Error : "+task.getException(),Toast.LENGTH_SHORT).show() ;
                                }
                            }
                        }
                    }) ;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please give all information ",Toast.LENGTH_SHORT).show() ;
        }
    }

}