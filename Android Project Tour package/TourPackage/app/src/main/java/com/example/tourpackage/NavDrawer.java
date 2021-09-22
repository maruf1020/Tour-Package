package com.example.tourpackage;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        NavigationView navigationView1 = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


       //updateNavHeader();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.nav_home){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        else if(id == R.id.nav_gallery){
            startActivity(new Intent(getApplicationContext(),Login_form.class));
        }
        else if(id == R.id.nav_slideshow){
            startActivity(new Intent(getApplicationContext(),Profile_Dashboard.class));
        }
        else if(id == R.id.nav_tools){
            startActivity(new Intent(getApplicationContext(),Chatbot.class));
        }
        else if(id == R.id.nav_share){
            startActivity(new Intent(getApplicationContext(),FAQ.class));
        }
        else if(id == R.id.nav_send){
            startActivity(new Intent(getApplicationContext(),About_Us.class));
        }
        return false;
    }



    public void gotoHomepage(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

        public void updateNavHeader() {

        NavigationView navigationView1 = findViewById(R.id.nav_view);
        View headerView = navigationView1.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.nav_username);
        TextView navUserMail = headerView.findViewById(R.id.nav_user_mail);
        ImageView navUserPhot = headerView.findViewById(R.id.nav_user_photo);

        navUserMail.setText("maruf.billah@northsouth.edu");
        navUsername.setText("Maruf billah");

        // now we will use Glide to load user image
        // first we need to import the library

        String url = "https://scontent.fdac19-1.fna.fbcdn.net/v/t1.0-9/p960x960/79314051_2628279527248315_8212056248242143232_o.jpg?_nc_cat=104&_nc_ohc=8JBLDWZRoeMAQnpbBxxoxar2b3t72nhB6_EneS9kNgmnagOWl7J7ZNdAw&_nc_ht=scontent.fdac19-1.fna&oh=e4d8139e04c98ba3cf94da538250e862&oe=5EAE6D05";

        Glide.with(this).load(url).into(navUserPhot);




    }


}