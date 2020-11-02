package com.example.wheaton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.navigation.NavigationView;

public class DiningActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DiningFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dining);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_dining:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DiningFragment()).commit();
                break;
            case R.id.nav_chase:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChaseFragment()).commit();
                break;
            case R.id.nav_emerson:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EmersonFragment()).commit();
                break;
            case R.id.nav_balfour:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BalfourFragment()).commit();
                break;
            case R.id.nav_davis:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DavisFragment()).commit();
                break;
            case R.id.nav_lyonBucks:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LyonBucksFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}