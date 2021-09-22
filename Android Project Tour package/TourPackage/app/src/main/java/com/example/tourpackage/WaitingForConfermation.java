package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WaitingForConfermation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_for_confermation);
    }

    public void gotoHomepage(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
