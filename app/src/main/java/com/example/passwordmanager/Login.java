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

public class Login extends AppCompatActivity {
    EditText user_email;
    EditText user_pass;
    Button register_bt;
    Button login_bt;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login2);
        user_email=findViewById(R.id.user_login);
        user_pass=findViewById(R.id.pass_login);
        register_bt=findViewById(R.id.reg_login);
        login_bt=findViewById(R.id.login_btn);

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= user_email.getText().toString();
                String pass= user_pass.getText().toString();

                if(email.isEmpty())
                {
                    Toast.makeText(Login.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty())
                {
                    Toast.makeText(Login.this, "Enter Your Master Password ", Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("@"))
                {
                    Toast.makeText(Login.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length()<6)
                {
                    Toast.makeText(Login.this, "Enter Minimum word password", Toast.LENGTH_SHORT).show();

                }
                else {


                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        PasswordModel.setPas(pass);
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(Login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
        });
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            Intent intent = new Intent( getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}