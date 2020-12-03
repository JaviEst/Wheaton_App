package com.example.wheaton.First_Year;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import com.example.wheaton.R;
import java.util.ArrayList;

public class clubs extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<clubs_class>> {

    // Declare clubs' array list
    private final ArrayList<clubs_class> clubs_list = new ArrayList<>();

    // Declare autocomplete text view
    private AutoCompleteTextView club_search_bar;

    // Declare clubs' name array list
    private final ArrayList<clubs_class> club_search_results = new ArrayList<>();

    // Declare clubs' adapter
    private club_adapter adapter;

    // Declare current list view
    private View current_list_view = null;
    private int current_pos = 0;

    // Declare previous list view
    private View previous_list_view = null;
    private int previous_pos = 0;

    public int focus = -1;

    // Declare url to json file
    String theURL = "https://engage.wheatoncollege.edu/api/discovery/search/organizations?orderBy[0]=UpperName%20asc&top=1000&filter=&query=&skip=0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        Intent call_intent = getIntent();

        // Initialize autocomplete
        club_search_bar = findViewById(R.id.clubs_searchBar);

        getLoaderManager().initLoader(0, null, this);
        club_search_results.addAll(clubs_list);


        club_search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Set visibility of previous item in the list clicked to gone
                if (previous_pos < club_search_results.size())
                    club_search_results.get(previous_pos).setLayout_vis(View.GONE);

                //updates search results array
                updateListFromSearchBar();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nothing
            }
        });

        // *
        //on click, hides dropdown, clears focus and hides keyboard
        club_search_bar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                club_search_bar.dismissDropDown();
                findViewById(R.id.clubsListView).requestFocus();
                hideKeyboardFrom(view.getContext(), club_search_bar);

                //if there is only one search result
                //auto select that result
                if (club_search_results.size() == 1)
                    // Set element layout to visible
                    club_search_results.get(0).setLayout_vis(View.VISIBLE);
            }
        });


        // Initialize adapter
        adapter = new club_adapter(this, club_search_results);

        // Declare and initialize view
        ListView club_list_view = findViewById(R.id.clubsListView);

        // Set the adapter so the list can be populated in the user interface
        club_list_view.setAdapter(adapter);

        club_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(previous_list_view == null){
                    // Update current list
                    current_pos = i;
                    current_list_view = view;

                    // Set element layout to visible
                    club_search_results.get(current_pos).setLayout_vis(View.VISIBLE);
                }
                else{
                    // Set visibility of previous item in the list clicked to gone
                    club_search_results.get(previous_pos).setLayout_vis(View.GONE);

                    // Update current list
                    current_pos = i;
                    current_list_view = view;

                    // Set element layout to visible
                    club_search_results.get(current_pos).setLayout_vis(View.VISIBLE);
                }

                // Update old view
                previous_pos = i;
                previous_list_view = view;

                // Notify array adapter that the data has changed
                adapter.notifyDataSetChanged();
            }

        });


    }

    public static String[] allClubNames(ArrayList<clubs_class> clubList) {
        String[] output = new String[clubList.size()];
        for (int i = 0; i < clubList.size(); i++) {
            output[i] = clubList.get(i).getClub_name();
        }

        return output;
    }

    public void updateListFromSearchBar() {

        ArrayList<clubs_class> newResults = new ArrayList<>();
        String searchQuery = club_search_bar.getText().toString();
        if (searchQuery.equals(""))
            newResults = clubs_list;
        else {
            for (int i = 0; i < clubs_list.size(); i++) {
                if (clubs_list.get(i).getClub_name().toLowerCase().contains(searchQuery.toLowerCase())) {
                    newResults.add(clubs_list.get(i));
                }
            }
        }
        if (focus != -1 && focus < club_search_results.size()) {
            club_search_results.get(focus).setLayout_vis(View.GONE);
        }
        club_search_results.clear();
        club_search_results.addAll(newResults);
        adapter.notifyDataSetChanged();
    }


    // Update the UI with the given club information.
    private void updateUi(ArrayList<clubs_class> club) {
        // Transfer data to global arraylist
        clubs_list.addAll(club);
        club_search_results.addAll(clubs_list);

        // Notify the adapter
        adapter.notifyDataSetChanged();

        //initialize club names array, names of every club object
        String[] club_names = allClubNames(club_search_results);
        ArrayAdapter<String> clubs_name_adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, club_names);
        club_search_bar.setAdapter(clubs_name_adapter);


    }

    @Override
    public Loader<ArrayList<clubs_class>> onCreateLoader(int i, Bundle bundle) {
        return new club_loader(this, theURL);
    }

    @Override
    public void onLoadFinished(android.content.Loader<ArrayList<clubs_class>> loader, ArrayList<clubs_class> clubs) {
        if (clubs != null) {
            updateUi(clubs);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<ArrayList<clubs_class>> loader) {
        // Nothing
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
