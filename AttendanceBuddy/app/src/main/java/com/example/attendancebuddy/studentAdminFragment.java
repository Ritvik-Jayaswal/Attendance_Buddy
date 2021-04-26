package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class studentAdminFragment extends Fragment {

    Button student;
    Button admin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_student_admin, container, false);

       student = (Button) view.findViewById(R.id.studentButton);

       student.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Fragment fragmentStudent = new StudentLoginFragment();
               FragmentTransaction transaction = getFragmentManager().beginTransaction();
               transaction.replace(R.id.contentView, fragmentStudent);
               transaction.commit();
           }
       });
       admin = (Button) view.findViewById(R.id.adminButton);

       admin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Fragment fragmentAdmin = new adminLoginFragment();
               FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
               fragmentTransaction.replace(R.id.contentView, fragmentAdmin);
               fragmentTransaction.commit();
           }
       });

        return  view;
    }
}