package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UcashPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucash_payment);
        getSupportActionBar().setTitle("Ukash Payment");
    }

    public void gotoHomepage(View view) {
        startActivity(new Intent(getApplicationContext(),WaitingForConfermation.class));
    }
}
