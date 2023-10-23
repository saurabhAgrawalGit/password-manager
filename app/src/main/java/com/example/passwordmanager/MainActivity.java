package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
     FloatingActionButton floatingActionButton;
     RecyclerView recyclerView;
     FirebaseAuth auth;
     FirebaseUser user;
     TextView mtextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        mtextView=findViewById(R.id.textView);

        mtextView.setText(user.getEmail());
        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();


    }
}