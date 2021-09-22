package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bokking_Details extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bokking__details);
        getSupportActionBar().setTitle("Booking Details");






    }



    public void btn_payment_mathod(View view) {
        startActivity(new Intent(this,Payment_Method.class));
    }
}
