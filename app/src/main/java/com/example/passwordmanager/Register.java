package com.example.passwordmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText user_email;
    EditText user_pass;
    Button register_bt;
    Button login_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user_email=findViewById(R.id.user_reg);
        user_pass=findViewById(R.id.pass_reg);
        register_bt=findViewById(R.id.register_btn);
        login_bt=findViewById(R.id.login_reg);




        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                String email= user_email.getText().toString();
                String pass= user_pass.getText().toString();
                if(email.isEmpty())
                {
                    Toast.makeText(Register.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty())
                {
                    Toast.makeText(Register.this, "Enter Your Master Password ", Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("@"))
                {
                    Toast.makeText(Register.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length()<6)
                {
                    Toast.makeText(Register.this, "Enter Minimum word password", Toast.LENGTH_SHORT).show();

                }
                else {


                    mAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        PasswordModel.setPas(pass);
                                        Log.d("sa", "createUserWithEmail:success");
                                        Toast.makeText(Register.this, "successful create", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                }
            }
        });

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });



    }
}