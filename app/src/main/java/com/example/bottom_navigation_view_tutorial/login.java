package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class login extends AppCompatActivity {

    EditText emailEdtTxt , passwordEdtTxt ;
    AppCompatButton logInBtn , goToSignUpBtn ;
    private FirebaseAuth firebaseAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logInBtn = findViewById(R.id.logInBtn) ;
        goToSignUpBtn = findViewById(R.id.goToSignUpBtn) ;
        emailEdtTxt = findViewById(R.id.emailEdtTxt) ;
        passwordEdtTxt = findViewById(R.id.passwordEdtTxt) ;

        firebaseAuth  = FirebaseAuth.getInstance() ;

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginWithGoogleVerification() ;
            }
        });
        goToSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), signUp.class) ;
                startActivity(intent);
            }
        });
    }

    private void userLoginWithGoogleVerification()
    {
        String email = emailEdtTxt.getText().toString().trim() ;
        String password = passwordEdtTxt.getText().toString().trim() ;


        if(!email.isEmpty() && !password.isEmpty())
        {
            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class) ;
                                intent.putExtra("myEmail",email) ;

                                startActivity(intent);
                            }
                            else if(task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(getApplicationContext(),"Log in failed",Toast.LENGTH_SHORT).show() ;
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error : " + task.getException() , Toast.LENGTH_SHORT).show() ;
                            }
                        }
                    }) ;

        }
        else
        {

            Toast.makeText(getApplicationContext(),"Please enter all information",Toast.LENGTH_SHORT).show() ;
        }
        emailEdtTxt.setText("");
        passwordEdtTxt.setText("");



    }
}