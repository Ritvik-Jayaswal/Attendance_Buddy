package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StudentAdminFragment extends Fragment {

    Button student;
    Button admin;

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

                StudentLoginFragment studentLoginFragment = new StudentLoginFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.adminStudentLayout, studentLoginFragment);
                transaction.commit();


            }
        }
        );

        view.findViewById(R.id.adminButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminLoginFragment adminLoginFragment = new AdminLoginFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.adminStudentLayout, adminLoginFragment);
                transaction.commit();

            }
        }
        );

        return view;


    }
}