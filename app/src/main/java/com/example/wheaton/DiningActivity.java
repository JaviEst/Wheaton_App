package com.example.wheaton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.wheaton.Dining.BalfourFragment;
import com.example.wheaton.Dining.ChaseFragment;
import com.example.wheaton.Dining.DavisFragment;
import com.example.wheaton.Dining.DiningFragment;
import com.example.wheaton.Dining.EmersonFragment;
import com.example.wheaton.Dining.LyonBucksFragment;
import com.google.android.material.navigation.NavigationView;

public class DiningActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dining);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.dining_drawer_menu);
        NavigationView navigationView = findViewById(R.id.dining_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new dining_fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dining);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_dining:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new dining_fragment()).commit();
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