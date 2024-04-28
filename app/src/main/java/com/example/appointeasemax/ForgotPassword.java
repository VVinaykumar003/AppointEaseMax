package com.example.appointeasemax;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    EditText etEmailAddress;
    Button btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmailAddress = findViewById(R.id.etEmailAddress);
        btnResetPassword = findViewById(R.id.btnResetPassword);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get email address entered by the user
                String emailAddress = etEmailAddress.getText().toString().trim();

                // Check if email address is empty
                if (TextUtils.isEmpty(emailAddress)) {
                    Toast.makeText(ForgotPassword.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                // TODO: Implement logic to send reset password link to the user's email address
                // For demonstration purposes, just displaying a toast message
                String message = "Reset password link sent to: " + emailAddress;
                Toast.makeText(ForgotPassword.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
