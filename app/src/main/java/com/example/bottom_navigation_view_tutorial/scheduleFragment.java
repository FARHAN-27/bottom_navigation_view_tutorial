package com.example.bottom_navigation_view_tutorial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link scheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class scheduleFragment extends Fragment {

    private List<Schedule> scheduleList = new ArrayList<>() ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public scheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment scheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static scheduleFragment newInstance(String param1, String param2) {
        scheduleFragment fragment = new scheduleFragment();
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
        // Inflate the layout for this fragment .it can convert a layout to view .
        View view  = inflater.inflate(R.layout.fragment_schedule, container, false);

        // here we need to work for creating a dynamic fragment .like id finding , using setText(),getText(),showing result in a recycler view .

        EditText agendaEdtTxt , dateEdtTxt , timeEdtTxt ;
        agendaEdtTxt = view.findViewById(R.id.agendaEditTxt) ;
        dateEdtTxt = view.findViewById(R.id.dateEdtTxt) ;
        timeEdtTxt = view.findViewById(R.id.timeEdtTxt) ;
        Button addNewScheduleBtn = view.findViewById(R.id.addNewScheduleBtn);
        RecyclerView scheduleShowRecyclerViewId = view.findViewById(R.id.scheduleShowRecycleViewId) ;


        // unfinished button work .
        addNewScheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String agenda = agendaEdtTxt.getText().toString().trim() ;
                String date = dateEdtTxt.getText().toString().trim() ;
                String time = timeEdtTxt.getText().toString().trim() ;
                // store information into firebase database .


                // then retrive data from data base .and show in a recycler view .

                scheduleList.add(new Schedule(agenda,date,time)) ;

                try {
                    scheduleShowRecyclerViewId.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                    ScheduleRecyclerViewAdapter scheduleAdapter = new ScheduleRecyclerViewAdapter(getActivity().getApplicationContext(),scheduleList) ;
                    scheduleShowRecyclerViewId.setAdapter(scheduleAdapter);
                }catch (Exception e)
                {
                    Log.d("schedule_recycle_view","Error : " + e) ;
                }
            }
        });

        return view ;
    }
}