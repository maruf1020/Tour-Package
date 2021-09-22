package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //for bottom nav
    SpaceNavigationView spaceNavigationView;


    RecyclerView mRecyclerView;

    List<TourData> myTourList;
    TourData mTourData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mRecyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1);

        mRecyclerView.setLayoutManager(gridLayoutManager);

        myTourList = new ArrayList<>();

        mTourData = new TourData("TRIP TO NORTH BENGAL","Come to North Bengal to experience great archeological sites of Bangladesh such as Mahasthan; North Bengal is also the place where the first settlers of Bangladesh in Dhaka.","TK. 10000",R.drawable.image1);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO THE TEA CAPITAL","Have you ever enjoyed a good cup of tea? Come and see where your delicious tea comes from by visiting the ‘Tea Capital of Bangladesh’ where you can meet the people who work.","TK. 15000",R.drawable.image2);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO ROCKET STEAMER","Travel through the rivers just like they did during the British colonial period, watching the beautiful green countryside of Bangladesh slowly pass by, also visit many.","TK. 21000",R.drawable.image3);
        myTourList.add(mTourData);

        mTourData = new TourData("BAMBOO RAFTING TOUR","Have you got an adventurous side just itching to come out, come on our new season best bamboo rafting tour where you have the chance to create the raft using.","TK. 15000",R.drawable.image4);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO NORTH BENGAL","Come to North Bengal to experience great archeological sites of Bangladesh such as Mahasthan; North Bengal is also the place where the first settlers of Bangladesh in Dhaka.","TK. 10000",R.drawable.image1);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO THE TEA CAPITAL","Have you ever enjoyed a good cup of tea? Come and see where your delicious tea comes from by visiting the ‘Tea Capital of Bangladesh’ where you can meet the people who work.","TK. 15000",R.drawable.image2);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO ROCKET STEAMER","Travel through the rivers just like they did during the British colonial period, watching the beautiful green countryside of Bangladesh slowly pass by, also visit many.","TK. 21000",R.drawable.image3);
        myTourList.add(mTourData);

        mTourData = new TourData("BAMBOO RAFTING TOUR","Have you got an adventurous side just itching to come out, come on our new season best bamboo rafting tour where you have the chance to create the raft using.","TK. 15000",R.drawable.image4);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO NORTH BENGAL","Come to North Bengal to experience great archeological sites of Bangladesh such as Mahasthan; North Bengal is also the place where the first settlers of Bangladesh in Dhaka.","TK. 10000",R.drawable.image1);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO THE TEA CAPITAL","Have you ever enjoyed a good cup of tea? Come and see where your delicious tea comes from by visiting the ‘Tea Capital of Bangladesh’ where you can meet the people who work.","TK. 15000",R.drawable.image2);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO ROCKET STEAMER","Travel through the rivers just like they did during the British colonial period, watching the beautiful green countryside of Bangladesh slowly pass by, also visit many.","TK. 21000",R.drawable.image3);
        myTourList.add(mTourData);

        mTourData = new TourData("BAMBOO RAFTING TOUR","Have you got an adventurous side just itching to come out, come on our new season best bamboo rafting tour where you have the chance to create the raft using.","TK. 15000",R.drawable.image4);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO NORTH BENGAL","Come to North Bengal to experience great archeological sites of Bangladesh such as Mahasthan; North Bengal is also the place where the first settlers of Bangladesh in Dhaka.","TK. 10000",R.drawable.image1);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO THE TEA CAPITAL","Have you ever enjoyed a good cup of tea? Come and see where your delicious tea comes from by visiting the ‘Tea Capital of Bangladesh’ where you can meet the people who work.","TK. 15000",R.drawable.image2);
        myTourList.add(mTourData);

        mTourData = new TourData("TRIP TO ROCKET STEAMER","Travel through the rivers just like they did during the British colonial period, watching the beautiful green countryside of Bangladesh slowly pass by, also visit many.","TK. 21000",R.drawable.image3);
        myTourList.add(mTourData);

        mTourData = new TourData("BAMBOO RAFTING TOUR","Have you got an adventurous side just itching to come out, come on our new season best bamboo rafting tour where you have the chance to create the raft using.","TK. 15000",R.drawable.image4);
        myTourList.add(mTourData);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this,myTourList);
        mRecyclerView.setAdapter(myAdapter);


        //for bottom nav
        spaceNavigationView = findViewById(R.id.space);

        final SpaceNavigationView spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("Pro", R.drawable.ic_profile));
        spaceNavigationView.addSpaceItem(new SpaceItem("Bot", R.drawable.ic_chat_bot));
        spaceNavigationView.addSpaceItem(new SpaceItem("FAQ", R.drawable.ic_faq));
        spaceNavigationView.addSpaceItem(new SpaceItem("Abt", R.drawable.ic_about_us));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
               // Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                spaceNavigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
               // Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                if (itemName == "Pro"){
                    startActivity(new Intent(getApplicationContext(),Profile_Dashboard.class));
                }
                else if(itemName == "Bot"){
                    startActivity(new Intent(getApplicationContext(),Chatbot.class));
                }
                else if(itemName == "FAQ"){
                    startActivity(new Intent(getApplicationContext(),FAQ.class));
                }
                else if(itemName == "Abt"){
                    startActivity(new Intent(getApplicationContext(),About_Us.class));
                }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
               // Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
