package com.example.bottom_navigation_view_tutorial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link findDoctorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class findDoctorFragment extends Fragment {

    RecyclerView recyclerView ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public findDoctorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment findDoctorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static findDoctorFragment newInstance(String param1, String param2) {
        findDoctorFragment fragment = new findDoctorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_doctor, container, false);

        ArrayList<Doctor> doctorList  = new ArrayList<>() ;

        doctorList.add(new Doctor("Rokon","CSE")) ;
        doctorList.add(new Doctor("Faouaze","MBBS")) ;
        doctorList.add(new Doctor("Rakib","HEART")) ;
        doctorList.add(new Doctor("Siam","Medicine")) ;
        doctorList.add(new Doctor("Liamon","Medicine")) ;
        doctorList.add(new Doctor("Tareek","Neurology")) ;
        doctorList.add(new Doctor("Rokon","CSE")) ;
        doctorList.add(new Doctor("Rokon","CSE")) ;
        doctorList.add(new Doctor("Rokon","CSE")) ;
        doctorList.add(new Doctor("Rokon","CSE")) ;
        doctorList.add(new Doctor("Rokon","CSE")) ;


        // this below code is responsible for adding item dynamically on recycler view .
        try {
            recyclerView = view.findViewById(R.id.doctorRecyclerView) ;
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()
                    .getApplicationContext()));

            doctorRecyclerViewAdapter doctorAdapter = new doctorRecyclerViewAdapter
                    (getActivity().getApplicationContext(), doctorList);

            recyclerView.setAdapter(doctorAdapter) ;
        }
        catch (Exception e)
        {
            System.out.println("ERROR in recyclerView of Doctor list :" + e) ;
        }

        return view ;

    }
}