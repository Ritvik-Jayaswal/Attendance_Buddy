package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Admin Launch Page
 */
public class adminLaunchPageFragment extends Fragment {

    Button attendanceButton;
    Button reportButton;

    public adminLaunchPageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_admin_launch_page, container, false);

        attendanceButton = (Button) view.findViewById(R.id.takeAttendanceButton);

        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentStudent = new adminScanDeviceFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contentView, fragmentStudent);
                transaction.commit();
            }
        });
        reportButton = (Button) view.findViewById(R.id.viewReportButton);

        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentAdmin = new adminViewReportFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contentView, fragmentAdmin);
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}