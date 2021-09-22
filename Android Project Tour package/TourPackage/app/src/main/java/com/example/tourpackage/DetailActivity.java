package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tourDecription, tourTitle;
    ImageView tourImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Package Details");

        tourDecription = (TextView) findViewById(R.id.txtDescription);
        tourTitle = (TextView) findViewById(R.id.txtTitle);
        tourImage = (ImageView) findViewById(R.id.ivImage2);


        Bundle mbundle = getIntent().getExtras();
        if(mbundle !=null){

            tourTitle.setText(mbundle.getString("Title"));
            tourDecription.setText(mbundle.getString("Description"));
            tourImage.setImageResource(mbundle.getInt("Image"));

        }
    }

    public void buttonTourLocation(View view) {
        startActivity(new Intent(this,MapsActivity.class));
    }

    public void buttonGoToPayment(View view) {
        startActivity(new Intent(this,Booking_Confermation.class));
    }
}
