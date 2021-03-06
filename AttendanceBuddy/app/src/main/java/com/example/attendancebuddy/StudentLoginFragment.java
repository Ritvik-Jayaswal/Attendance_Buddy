package com.example.attendancebuddy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Student Login Page
 */
public class StudentLoginFragment extends Fragment {



    private FirebaseAuth mAuth;
    final private String TAG = "Login";
    EditText StudenteditTextEmail;
    EditText StudenteditTextPassword;
    Button Studentregister;


    public StudentLoginFragment() {
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
        View view = inflater.inflate(R.layout.fragment_student_login, container, false);
        StudenteditTextEmail = view.findViewById(R.id.StudenteditTextTextEmailAddress);
        StudenteditTextPassword = view.findViewById(R.id.StudenteditTextTextPassword);
        getActivity().setTitle("Login");

        view.findViewById(R.id.StudentLoginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =  StudenteditTextEmail.getText().toString();
                String password =  StudenteditTextPassword.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter Email", Toast.LENGTH_LONG).show();
                } else if(password.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter Password", Toast.LENGTH_LONG).show();

                } else {
                    mAuth = FirebaseAuth.getInstance();

                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.d(TAG, "You are now logged in");
                                Log.d(TAG, "onComplete: " +mAuth.getCurrentUser().getUid());
                            }else {


                                Log.d(TAG, "Error, onComplete failed");
                                Log.d(TAG, "onComplete " + task.getException().getMessage());

                                /*
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setTitle("Alert");
                                builder.setMessage("onComplete " +task.getException().getMessage());
                                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                builder.show();

                                 */



                            }
                        }
                    });



                }

                Fragment fragment = new StudentLaunchPageFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contentView, fragment);
                transaction.commit();




            }
        });

        Studentregister = (Button) view.findViewById(R.id.StudentSignUpButton);
        Studentregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new StudentSignupFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contentView, fragment);
                transaction.commit();
            }
        });

        return view;
    }


}