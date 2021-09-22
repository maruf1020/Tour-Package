package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

public class FAQ extends AppCompatActivity {

    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        getSupportActionBar().setTitle("FAQ Page");

        expandableListView=findViewById(R.id.eTv);
        ExpandableTextViewAdapter adapter = new ExpandableTextViewAdapter(FAQ.this);
        expandableListView.setAdapter(adapter);
    }
}
