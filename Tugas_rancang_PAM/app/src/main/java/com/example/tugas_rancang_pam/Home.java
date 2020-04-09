package com.example.tugas_rancang_pam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }


    public void btnMapsClick(View view) {
        Intent mapsIntent = new Intent(Home.this, MapsActivity.class) ;
        startActivity(mapsIntent);
    }

    public void btnGalleryClick(View view) {
        Intent intent = new Intent(Home.this, GalleryActivity.class) ;
        startActivity(intent);
    }

    public void btnRecreationClick(View view) {
        Intent intent = new Intent(Home.this, RecreationActivity.class) ;
        startActivity(intent);
    }
    public void btnContactusClick(View view) {
        Intent intent = new Intent(Home.this, ContactusActivity.class) ;
        startActivity(intent);
    }

    public void btnActractionClick(View view) {
        Intent intent = new Intent(Home.this, AttractionActivity.class) ;
        startActivity(intent);
    }
}
