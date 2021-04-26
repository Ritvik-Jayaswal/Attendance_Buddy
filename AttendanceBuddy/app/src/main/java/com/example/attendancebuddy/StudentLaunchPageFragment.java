package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StudentLaunchPageFragment extends Fragment {

    Button studentViewReport;
    Button studentRegisterDevice;


    public StudentLaunchPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_launch_page, container, false);

        studentRegisterDevice = (Button) view.findViewById(R.id.registerDeviceButton);

        studentRegisterDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentStudent = new StudentRegisterDeviceFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contentView, fragmentStudent);
                transaction.commit();
            }
        });
        studentViewReport = (Button) view.findViewById(R.id.AttendanceReportButton);

        studentViewReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentAdmin = new StudentViewReportFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contentView, fragmentAdmin);
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}