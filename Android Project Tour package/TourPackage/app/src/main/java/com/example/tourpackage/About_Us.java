package com.example.tourpackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;


import android.content.res.Configuration;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class About_Us extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);


        simulateDayNight(/* DAY */ 1);
        Element adsElement = new Element();
        adsElement.setTitle("About Us");



        View aboutPage = new AboutPage(this)
                .isRTL(false)
               .setDescription("TOUR PACKAGE is a online tour package booking system with some good features, an user could know about several tour packages by chatbot. The owner wouldn't be needed to reply the users, rather the system will automatically reply when someone ask something in chatbot. Moreover, one could book a tour package, see the details including google map location of the tour packages, could search for his/her favourite package, and would be able to pay online for the package. User would need to sign up and sign in to do these activities, third party log in system would be available also. This project would be very helpful for those who want to book tour package by sitting at home. He would be able to get the answers with in a second if he has any query. The owner of the TOUR PACKAGE business would get help from this project. He wouldn't need to hire people for replaying client's questions.")
                .setImage(R.drawable.dummy_image_final)
//               .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("maruf.billah@northsouth.edu")
                .addWebsite("http://fb.com/tomardada")
                .addFacebook("tomardada")
                .addTwitter("mdmarufbilah")
                .addYoutube("UCaWcsFUHHLrOTgDjaefIZwA")
                .addPlayStore("https://play.google.com/store")
                .addInstagram("md_maruf_billah")
                .addGitHub("maruf1020")
                .addItem(new Element().setTitle("Version 0.0.0.1"))
                .addItem(getCopyRightsElement())
                .create();


        setContentView(aboutPage);








    }

    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.tourpackagelogo);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About_Us.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 1;
        final int NIGHT = 0;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }





}


