package com.example.wheaton.First_Year;

import androidx.appcompat.app.AppCompatActivity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.wheaton.R;
import java.util.ArrayList;

public class clubs extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<clubs_class>> {

    // Declare clubs' array list
    ArrayList<clubs_class> clubs_list;

    // Declare clubs' adapter
    club_adapter adapter;

    // Declare url to json file
    String theURL = "https://engage.wheatoncollege.edu/api/discovery/search/organizations?orderBy[0]=UpperName%20asc&top=1000&filter=&query=&skip=0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        Intent call_intent = getIntent();

        // Initialize list
        clubs_list = new ArrayList<>();


        // Initialize adapter
        adapter = new club_adapter(this, clubs_list);

        // Declare and initialize view
        ListView club_list_view = findViewById(R.id.clubsListView);

        // Set the adapter so the list can be populated in the user interface
        club_list_view.setAdapter(adapter);

        club_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
            }
        });

        getLoaderManager().initLoader(0, null, this);
        //getLoaderManager().initLoader(0, null, this);
    }

    // Update the UI with the given club information.
    private void updateUi(ArrayList<clubs_class> club) {
        // Transfer data to global arraylist
        clubs_list.addAll(club);

        // Notify the adapter
        adapter.notifyDataSetChanged();

    }

    @Override
    public Loader<ArrayList<clubs_class>> onCreateLoader(int i, Bundle bundle) {
        return new club_loader(this, theURL);
    }

    @Override
    public void onLoadFinished(android.content.Loader<ArrayList<clubs_class>> loader, ArrayList<clubs_class> clubs) {
        if(clubs != null) {
            updateUi(clubs);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<ArrayList<clubs_class>> loader) {
        // Nothing
    }

}