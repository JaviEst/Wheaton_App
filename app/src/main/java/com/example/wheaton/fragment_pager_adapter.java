package com.example.wheaton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fragment_pager_adapter extends FragmentStateAdapter {

    public fragment_pager_adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new library_fragment();
            case 1:
                return new dining_fragment();
            case 2:
                return new events_fragment();
            case 3:
                return new home_fragment();
            case 4:
                return new map_fragment();
            case 5:
                return new athletics_fragment();
            case 6:
                return new first_year_fragment();
            default:
                return new home_fragment();
        }
    }

}
