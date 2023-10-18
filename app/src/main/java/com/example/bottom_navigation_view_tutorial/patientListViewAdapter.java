package com.example.bottom_navigation_view_tutorial;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class patientListViewAdapter extends ArrayAdapter<Patient> {
    private Activity context ;
    private List<Patient> patientList ;

    public patientListViewAdapter(Activity context, List<Patient> patientList) {
        super(context, R.layout.patient_sample_layout,patientList);
        this.context = context;
        this.patientList = patientList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater() ;
        View view = layoutInflater.inflate(R.layout.patient_sample_layout, null, true);

        Patient patient = patientList.get(position) ;

        TextView nameTxtView = view.findViewById(R.id.nameTxtView) ;
        TextView ageTxtView = view.findViewById(R.id.ageTxtView) ;
        TextView emailTxtView = view.findViewById(R.id.emailTxtView) ;

        nameTxtView.setText(patient.getName());
        ageTxtView.setText(patient.getAge());
        emailTxtView.setText(patient.getEmail()) ;

        return view ;
    }
}
