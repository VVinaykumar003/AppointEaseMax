package com.example.appointeasemax;

import static com.example.appointeasemax.R.id.etName;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AppointmentBookingActivity extends AppCompatActivity {

    EditText etName, etAge, etDate, etTime, etAddress;
    Button btnBookAppointment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_booking);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etAddress = findViewById(R.id.etAddress);
        btnBookAppointment = findViewById(R.id.btnBookAppointment);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        btnBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String date = etDate.getText().toString();
                String time = etTime.getText().toString();
                String address = etAddress.getText().toString();

                // Perform booking logic (you can replace this with your actual booking logic)
                // For demonstration purposes, just displaying a toast message with the input values
                String message = "Appointment booked for:\nName: " + name + "\nAge: " + age +
                        "\nDate: " + date + "\nTime: " + time + "\nAddress: " + address;
                Toast.makeText(AppointmentBookingActivity.this, ("Appointment Booked"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText(String.format("%02d:%02d", hourOfDay, minute));
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }
}




