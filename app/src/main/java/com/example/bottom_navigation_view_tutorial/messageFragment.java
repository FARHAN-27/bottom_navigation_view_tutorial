package com.example.bottom_navigation_view_tutorial;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link messageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class messageFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public messageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment messageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static messageFragment newInstance(String param1, String param2) {
        messageFragment fragment = new messageFragment();
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
        View view = inflater.inflate(R.layout.fragment_message, container, false);


        AppCompatButton goToMessenger = view.findViewById(R.id.goToMessenger) ;
        EditText friendEmailEdtTxt = view.findViewById(R.id.friendEmailEdtTxt) ;
        AppCompatButton goForVideoCall = view.findViewById(R.id.goForVideoCall);

        goForVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity().getApplicationContext(),"button works well",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity().getApplicationContext(),startCallActivity.class) ;
                startActivity(intent);
            }
        });


        goToMessenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prviousintent = getActivity().getIntent() ;
                String myEmail = prviousintent.getStringExtra("myEmail") ;
                String friendEmail = friendEmailEdtTxt.getText().toString().trim() ;


                Toast.makeText(getActivity().getApplicationContext(),myEmail +" " + friendEmail,Toast.LENGTH_SHORT).show() ;
                Intent intent = new Intent(getActivity().getApplicationContext(),chat.class) ;
                Bundle bundle = new Bundle() ;
                bundle.putString("myEmail",myEmail);
                bundle.putString("friendEmail",friendEmail);
                intent.putExtras(bundle) ;
                startActivity(intent);




            }
        });






        return view ;
    }


}