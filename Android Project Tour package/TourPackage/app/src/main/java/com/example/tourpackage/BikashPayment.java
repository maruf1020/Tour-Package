package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BikashPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bikash_payment);
        getSupportActionBar().setTitle("Bikash Payment");
    }

    public void gotoHomepage(View view) {
        startActivity(new Intent(getApplicationContext(),WaitingForConfermation.class));
    }
}
