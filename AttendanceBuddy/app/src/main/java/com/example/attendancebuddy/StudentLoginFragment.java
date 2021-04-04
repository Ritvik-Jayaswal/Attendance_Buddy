package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class StudentLoginFragment extends Fragment {

    private FirebaseAuth mAuth;
    final private String TAG = "app";

    public StudentLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    EditText emailAddressEditText, passwordEditText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        emailAddressEditText = view.findViewById(R.id.emailEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);

        view.findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String email = emailAddressEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getActivity(), "Enter Email", Toast.LENGTH_LONG).show();
                } else if(password.isEmpty()){
                    Toast.makeText(getActivity(), "Enter Password", Toast.LENGTH_LONG).show();
                } else {

                    mAuth = FirebaseAuth.getInstance();
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Log.d(TAG, "onComplete: Logged In Successfully");
                                

                            } else {
                                Log.d(TAG, "onComplete: Error");

                            }

                        }
                    });


                }



            }
        });

        view.findViewById(R.id.studentSignupButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });







        return view;


    }

}