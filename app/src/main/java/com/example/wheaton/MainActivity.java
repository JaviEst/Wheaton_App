package com.example.wheaton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    public ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.pager);
        fragment_pager_adapter adapter = new fragment_pager_adapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            Drawable [] icons = new Drawable[]{ResourcesCompat.getDrawable(getResources(), R.drawable.library, null), ResourcesCompat.getDrawable(getResources(), R.drawable.dining, null), ResourcesCompat.getDrawable(getResources(), R.drawable.events, null), ResourcesCompat.getDrawable(getResources(), R.drawable.home, null), ResourcesCompat.getDrawable(getResources(), R.drawable.map, null), ResourcesCompat.getDrawable(getResources(), R.drawable.athletics, null), ResourcesCompat.getDrawable(getResources(), R.drawable.firstyear, null)};
            tab.setIcon(icons[position]);
            viewPager2.setCurrentItem(3);
        }).attach();
    }

    public void setCurrentItem (int item) {
        viewPager2.setCurrentItem(item);
    }

}