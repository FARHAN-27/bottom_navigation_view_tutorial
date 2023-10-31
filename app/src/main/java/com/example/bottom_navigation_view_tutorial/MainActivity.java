package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    DrawerLayout drawerLayout ;
    NavigationView navigationView ;
    Toolbar toolbar ;
    TextView title_fragment ;



    private  void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager() ;
        FragmentTransaction ft = fm.beginTransaction() ;
        ft.replace(R.id.container,fragment) ;
        ft.commit() ;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this) ;

        drawerLayout = findViewById(R.id.drawer_layout) ;
        navigationView = findViewById(R.id.navigation_view) ;
        toolbar = findViewById(R.id.toolbar) ;
        title_fragment = findViewById(R.id.fragment_title);


        loadFragment(new Home_fragment());

        // Step 1 : set tool bar :
        setSupportActionBar(toolbar) ;

        // step 2 : Action bar toogle

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);



        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {




            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId() ;



                if(id==R.id.Home_id)
                {
                    // go to home fragment .
                    title_fragment.setText("Home");
                    loadFragment(new Home_fragment());

                }
                else if(id == R.id.Setting_id)
                {
                    // go to settings fragment .
                    title_fragment.setText("Settings");

//                    loadFragment(new findDoctorFragment());
                }
                else if(id == R.id.Appointment_id)
                {
                    title_fragment.setText("Doctors");

                    loadFragment(new findDoctorFragment());

                }
                else if(id==R.id.schedul_id)
                {
                    title_fragment.setText("Schedule");
                    loadFragment(new scheduleFragment());
                }
                else if(id==R.id.messenger_id)
                {
                    title_fragment.setText("Members in Messenger");
                    loadFragment(new messageFragment());

                }
                else if(id==R.id.googleMapId)
                {
                    Intent intent = new Intent(getApplicationContext(), googleMapActivity.class) ;
                    startActivity(intent);

                }
                else if(id == R.id.logout_id)
                {
                    // go to login activity :

                    FirebaseAuth.getInstance().signOut();
                    finish() ;
                    Intent intent = new Intent(getApplicationContext(), login.class) ;
                    startActivity(intent);


                }

                return true;
            }


        });

    }
}