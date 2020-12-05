package com.example.wheaton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;


import com.example.wheaton.events.event_fragment_filter;
import com.example.wheaton.events.event_fragment_item;
import com.example.wheaton.events.events_fragment_adapter;
import com.example.wheaton.events.events_fragment_class;
import com.example.wheaton.events.events_fragment_loader;

import java.util.ArrayList;
import java.util.Collections;

public class events_fragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList> {

    // Declare View
    View root_view;

    // ********************** Variables ***************************

    // URL to be accessed by HTTP Request
    private static final String theURL = "https://wheatoncollege.edu/wp-json/tribe/events/v1/events/?page=01&per_page=40&start_date=2020-11-01%2000:00:00&end_date=2020-11-29%2023:59:59&status=publish";
    public static final String LOG_TAG = events_fragment.class.getName();

    // Two variables that hold the current filter objects
    public String filters = "";
    ArrayList<String> filters2;
    // Adds the last accessed filter objects to this String
    String lastFilters = " ";

    // The main adapter
    private events_fragment_adapter adapter;
    // The main ArrayList that holds all event data
    ArrayList<events_fragment_class> events;
    // This keeps track of the original positions of the new (Temp) ArrayList
    private ArrayList<Integer> positionsOfEvents;

    // This boolean is set to true once the event fragment is loaded so that the
    // ArrayList events is not populated again
    boolean loaded = false;

    // Checks to see which ArrayList should be accessed 0 - events 1 - temp
    int tempCheck = 0;

    // --- Unused values for right now
    AutoCompleteTextView searchbar;
    ArrayAdapter<events_fragment_class> titleAdapter;
    ArrayList<events_fragment_class> backup = new ArrayList<events_fragment_class>();
    ArrayAdapter<events_fragment_class> searchAdapter = null;
    private final ArrayList<events_fragment_class> searchResults = new ArrayList<>();

    // Initialize Fragment
    public events_fragment(){}


    // ********************** Processes ***************************

    // The listener for the Categories button (filter)
    private View.OnClickListener filterListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            buttonFilter();
        }
    };


    
    // The onResume function acts once a user returns from the Categories activity
    @Override
    public void onResume() {
        super.onResume();
        // Gets the ID from the main ListView
        ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);
        // Allows the event ArrayList to stop populating
        loaded = true;

        // If the filter matches the lastFilters then change nothing
        if (filters.matches(lastFilters)) {
        }
        // (** TESTING CODE **)
//        else if(filters.matches("") && lastFilters.matches(" ")){
//        }
        // *******************
        // If filters does not equal blank then a filter is in place
        else if (!filters.equals("")) {
            // Create the temp ArrayList which holds the new List
            ArrayList<events_fragment_class> temp = new ArrayList<events_fragment_class>();
            // Create a new ArrayList<Int> that holds the old positions
            positionsOfEvents = new ArrayList<>();
            // Loop through the entire event list
            for (int i = 0; i < events.size(); i++) {
                // Loop through each filter in place
                for(int j = 0; j < filters2.size(); j++){
                    // Check if the current Event contains a Filter that was selected by the user
                    if (events.get(i).getFilter().contains(filters2.get(j))) {
                        // Add that to the temp ArrayList
                        temp.add(events.get(i));
                        // Also add the position to the Int ArrayList
                        positionsOfEvents.add(i);
                    }
                }

            }
            // Once done with the loop, update the adapter
            adapter = new events_fragment_adapter(getContext(),temp);
            // Set the ListView to adapter
            eventListView.setAdapter(adapter);
            // Notify adapter
            adapter.notifyDataSetChanged();
            // Set the current filters to the lastFilter
            lastFilters = filters;
            // Set tempCheck to 1
            tempCheck = 1;
        }
        else {
            // If it is the first instance of the Fragment, otherwise, else
            // Set the adapter to events
            adapter = new events_fragment_adapter(getContext(),events);
            // Set the listview to adapter
            eventListView.setAdapter(adapter);
            // Notify the adapter
            adapter.notifyDataSetChanged();
            // Set the current filters to the lastFilter
            lastFilters = filters;
            // Set tempCheck to 0
            tempCheck = 0;
        }

    }


    // The main onCreate function
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the view
        root_view = inflater.inflate(R.layout.events, container, false);

        // Make a call to the loader and start the process of the Http request
        getLoaderManager().initLoader(0,null, this);

        // Create a list of earthquakes.
        events = new ArrayList<events_fragment_class>();

        // Find a reference to the {@link ListView} in the layout
        ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);

        // Create a new {@link ArrayAdapter} of earthquakes
        adapter = new events_fragment_adapter(getActivity(), events);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        eventListView.setAdapter(adapter);

        // (** TESTING CODE **)
//        String[] titles = events_fragment_class.allTitles(events);
//        searchResults.addAll(events);
//
//        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,titles);
//
//        searchbar = root_view.findViewById(R.id.mainSearch);
//        searchbar.setAdapter(titleAdapter);
        // ********************

        // Set the onClickListener to the filter button
        Button filter = root_view.findViewById(R.id.filterButton);
        filter.setOnClickListener(filterListener);

        // Using the eventListView, create the onItemClickListener
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Set loaded to true
                loaded = true;
                // If the tempCheck is 0 (events), create the Intent based off of the true indexes
                if(tempCheck == 0) {
                    Intent goToItem = new Intent(view.getContext(), event_fragment_item.class);
                    goToItem.putExtra("title", events.get(i).getTitle());
                    goToItem.putExtra("date", events.get(i).getDate());
                    goToItem.putExtra("largeImage", events.get(i).getLargeimage());
                    goToItem.putExtra("location", events.get(i).getLocation());
                    goToItem.putExtra("cost", events.get(i).getCost());
                    goToItem.putExtra("filter", events.get(i).getFilter());
                    goToItem.putExtra("organizerName", events.get(i).getOrganName());
                    goToItem.putExtra("organizerPhone", events.get(i).getOrganPhone());
                    goToItem.putExtra("organizerEmail", events.get(i).getOrganEmail());
                    goToItem.putExtra("link", events.get(i).getLink());
                    startActivity(goToItem);
                }
                // If the tempCheck is 1 (temp), create the Intent based off of the filter indexes
                if(tempCheck == 1){
                    // Set the originalPosition to the index of the user clicked
                    int originalP = 0;
                    originalP = positionsOfEvents.get(i);

                    Intent goToItem = new Intent(view.getContext(), event_fragment_item.class);
                    goToItem.putExtra("title", events.get(originalP).getTitle());
                    goToItem.putExtra("date", events.get(originalP).getDate());
                    goToItem.putExtra("largeImage", events.get(originalP).getLargeimage());
                    goToItem.putExtra("location", events.get(originalP).getLocation());
                    goToItem.putExtra("cost", events.get(originalP).getCost());
                    goToItem.putExtra("filter", events.get(originalP).getFilter());
                    goToItem.putExtra("organizerName", events.get(originalP).getOrganName());
                    goToItem.putExtra("organizerPhone", events.get(originalP).getOrganPhone());
                    goToItem.putExtra("organizerEmail", events.get(originalP).getOrganEmail());
                    goToItem.putExtra("link", events.get(originalP).getLink());
                    startActivity(goToItem);
                }
                adapter.notifyDataSetChanged();
            }
        });
        // (** TESTING CODE **)
//        searchbar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                updateListFromSearchBar();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//            }
//        });
//
//        searchbar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                searchbar.dismissDropDown();
//                root_view.findViewById(R.id.eventListView).requestFocus();
//                hideKeyboardFrom(view.getContext(), searchbar);
//            }
//        });
        // ***********************

        // Return root_view
        return root_view;
    }

    // (** TESTING CODE **)
//    public void updateListFromSearchBar(){
//
//        ArrayList<events_fragment_class> newResults = new ArrayList<>();
//        String searchQuery = searchbar.getText().toString();
//        if (searchQuery.equals(""))
//            newResults = events;
//        else {
//            for (int i = 0; i < events.size(); i++) {
//                if (events.get(i).getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
//                    newResults.add(events.get(i));
//                }
//            }
//        }
//
//        searchResults.clear();
//        searchResults.addAll(newResults);
//        adapter.notifyDataSetChanged();
//
//
//    }
    // *************************

    // If the filter button is clicked, send the 2 filter variables to the filter intent activity.
    private void buttonFilter(){
        Intent goToFilter = new Intent(getContext(), event_fragment_filter.class);
        goToFilter.putExtra("filters", filters);
        goToFilter.putExtra("filters2", filters2);
        startActivityForResult(goToFilter,1);

    }

    // When the activity is returned, reset the filter variables with updated values
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == -1) {
                filters = data.getStringExtra("filters");
                filters2 = data.getStringArrayListExtra("filters2");

            }
        }
    }

    // The loaded calls to this function once the Loader has finished
    private void updateUi(ArrayList arrayList) {
        // If it has not been loaded populate the list
        if (loaded == false) {

            events.addAll(arrayList);

            adapter.notifyDataSetChanged();
        }
    }

    // On creation of the loader
    @NonNull
    @Override
    public Loader<ArrayList> onCreateLoader(int id, @Nullable Bundle args) {
        //  Return the current context as well as the URL given
        return new events_fragment_loader(getContext(), theURL);
    }

    // Finished loader
    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList> loader, ArrayList data) {
        // If the data is not null update the UI
        if(data != null){
            updateUi(data);
        }
    }

    // On loader reset
    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList> loader) {
    }


    // (** TESTING CODE **)
//    public static void hideKeyboardFrom(Context context, View view) {
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }
//
//    public void clearText(View view) {
//        searchbar.setText("");
//    }
    // **************
}
