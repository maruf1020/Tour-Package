package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Booking_Confermation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking__confermation);
        getSupportActionBar().setTitle("user Confermation");
    }


    public void btn_g0_to_booking_details(View view) {
        startActivity(new Intent(this,Bokking_Details.class));
    }
}
