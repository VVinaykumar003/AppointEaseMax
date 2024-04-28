package com.example.appointeasemax;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class DashboardActivity extends AppCompatActivity {
    ImageView view;
Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Set OnClickListener for the ImageView
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to handle click on the "Book Appointment" ImageView
                onBookAppointmentClick(v);
            }
        });
    }

    // Method to handle click on the "Book Appointment" ImageView
    public void onBookAppointmentClick(View view) {
        Intent intent = new Intent(this, AppointmentBookingActivity.class);
        startActivity(intent);
    }
}