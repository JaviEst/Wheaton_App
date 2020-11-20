package com.example.wheaton;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class events_fragment_loader extends AsyncTaskLoader<ArrayList> {

    private String url;

    public events_fragment_loader(Context context, String theURL) {
        super(context);
        url = theURL;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList loadInBackground() {
        return events_fragment_utils.fetchEarthquakeData(url);
    }

}
