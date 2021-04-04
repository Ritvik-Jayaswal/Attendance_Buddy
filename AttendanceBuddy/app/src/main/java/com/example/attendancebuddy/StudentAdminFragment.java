package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StudentAdminFragment extends Fragment {



    public StudentAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_student_admin, container, false);

        view.findViewById(R.id.studentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        }
        );

        view.findViewById(R.id.adminButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
        );

        return view;


    }
}