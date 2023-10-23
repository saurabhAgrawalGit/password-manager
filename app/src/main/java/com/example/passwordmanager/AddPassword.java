package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPassword extends AppCompatActivity {
    EditText name,pass;
    Button button;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseDatabase database ;
    DatabaseReference myRef ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);
        name= findViewById(R.id.Name);
        pass= findViewById(R.id.Password);
        button= findViewById(R.id.addpwd);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference("passwordTable");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NameApp=name.getText().toString();
                String passApp=pass.getText().toString();
                PasswordModel passwordModel= new PasswordModel(NameApp,passApp);
                myRef.child(user.getUid()).push().setValue(passwordModel).
                addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddPassword.this, "Successful add ", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });



    }
}