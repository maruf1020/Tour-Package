package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Payment_Method extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__method);
        getSupportActionBar().setTitle("Payment Method");
    }

    public void gotoBikashPayment(View view) {
        startActivity(new Intent(getApplicationContext(),BikashPayment.class));
    }

    public void gotoRocketPayment(View view) {
        startActivity(new Intent(getApplicationContext(),RocketPayment.class));
    }

    public void gotoUcashPayment(View view) {
        startActivity(new Intent(getApplicationContext(),UcashPayment.class));
    }

    public void gotoPaypalpayment(View view) {
        startActivity(new Intent(getApplicationContext(),PaypalPayment.class));
    }
}
