package com.example.attendancebuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class adminSignupFragment extends Fragment {

    EditText editTextEmailRegister;
    EditText editTextPasswordRegister;
    EditText editTextName;
    Button cancel;
    Button submit;
    private FirebaseAuth mAuth;

    final private String TAG = "Register";

    public adminSignupFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_admin_signup, container, false);
        getActivity().setTitle("Register");
        editTextEmailRegister = view.findViewById(R.id.adminEmail);
        editTextPasswordRegister = view.findViewById(R.id.adminPassword);
        editTextName = view.findViewById(R.id.adminName);
        submit = (Button) view.findViewById(R.id.adminSubmit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmailRegister.getText().toString();
                String password = editTextPasswordRegister.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter Email", Toast.LENGTH_LONG).show();
                } else if(password.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Password", Toast.LENGTH_LONG).show();
                } else if(name.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter Name", Toast.LENGTH_LONG).show();

                } else {

                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Log.d(TAG, "You are now registered");
                                        Log.d(TAG, "onComplete:" +mAuth.getCurrentUser().getUid());
                                    }else {


                                        Log.d(TAG, "Error, onComplete failed");
                                        Log.d(TAG, "onComplete" + task.getException().getMessage());

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

                                    }
                                }
                            });
                }

                Fragment fragment = new adminLoginFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contentView, fragment);
                transaction.commit();



            }


        });



        cancel = (Button) view.findViewById(R.id.adminCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new adminLoginFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contentView, fragment);
                transaction.commit();
            }
        });

        return view;
    }
}