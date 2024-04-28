package com.example.appointeasemax;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    TextView signup,forgot;
    private FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        signup =findViewById(R.id.signUp);
        forgot=findViewById(R.id.forgot);
        mAuth = FirebaseAuth.getInstance();



        //set click listner on signup
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });

        //set click listner on signup
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Regestration.class);
                startActivity(intent);
                finish();
            }
        });


        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(Login.this, "Please enter  password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Login success, update UI
                                    Toast.makeText(Login.this, "Login Sucssefull.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, DashboardActivity.class); // Replace HomeActivity with the name of your home screen activity
                                    startActivity(intent);
                                    finish(); // Optional: Finish the login activity so the user can't navigate back to it using the back button
                                } else {
                                    // Login failed, display an error message to the user
                                    Toast.makeText(Login.this, "Login failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });








            }
        });
    }
}
