package com.example.wheaton.First_Year;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

public class club_loader extends AsyncTaskLoader<ArrayList<clubs_class>> {

    private String url;

    public club_loader(Context context, String theUrl) {
        super(context);
        url = theUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public ArrayList<clubs_class> loadInBackground() {
        return QueryUtils.fetchClubData(url);
    }
}
