package com.example.appointeasemax;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class profile extends AppCompatActivity {
    TextView profileName,profileEmail,profileUsername,profilePasword;
    TextView titleName,titleUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername=findViewById(R.id.UserName);
        profilePasword=findViewById(R.id.password);
        titleName=findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUserName);

        showUserData();



    }

    public void showUserData(){
        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");

        titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(nameUser);
        titleUsername.setText(usernameUser);
        profilePasword.setText(passwordUser);





    }
}