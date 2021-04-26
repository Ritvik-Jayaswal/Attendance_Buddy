package com.example.attendancebuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentView, new studentAdminFragment())
                .commit();
    }



    /*
    private Button studentButton;
    private Button adminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentButton = (Button) findViewById(R.id.studentButton);

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentLogin(); 
            }
        });
        adminButton = (Button) findViewById(R.id.adminButton);
        
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminLogin(); 
            }
        });

    }

    public void openAdminLogin() {

        Intent intent = new Intent(this, adminLoginActivity.class);
        startActivity(intent);
    }

    public void openStudentLogin() {
        Intent intent = new Intent(this, studentLoginActivity.class);
        startActivity(intent);

    }

     */
}