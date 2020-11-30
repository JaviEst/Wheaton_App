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

    private static final String theURL = "https://wheatoncollege.edu/wp-json/tribe/events/v1/events/?page=01&per_page=40&start_date=2020-11-01%2000:00:00&end_date=2020-11-29%2023:59:59&status=publish";
    public static final String LOG_TAG = events_fragment.class.getName();

    private int position = -1;
    private int lastPosition;
    private ConstraintLayout lastOptions;
    public String filters = "";
    private ArrayList<events_fragment_class> temp = new ArrayList<>();
    private events_fragment_adapter adapter;
    ArrayList<events_fragment_class> events;
    String lastFilters = " ";
    boolean loaded = false;
    ArrayList<String> filters2;
    int tempCheck = 0;
    AutoCompleteTextView searchbar;
    private ArrayList<Integer> positionsOfEvents;
    ArrayAdapter<events_fragment_class> titleAdapter;
    ArrayList<events_fragment_class> backup = new ArrayList<events_fragment_class>();
    ArrayAdapter<events_fragment_class> searchAdapter = null;
    private ListView eventListView;
    boolean textChanged = false;
    private final ArrayList<events_fragment_class> searchResults = new ArrayList<>();


    public events_fragment(){}


    private View.OnClickListener filterListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            buttonFilter();
        }
    };


    

    @Override
    public void onResume() {
        super.onResume();
        ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);
        loaded = true;

        if (filters.matches(lastFilters)) {

        }
        else if (!filters.equals("")) {
            ArrayList<events_fragment_class> temp = new ArrayList<events_fragment_class>();
            positionsOfEvents = new ArrayList<>();
            for (int i = 0; i < events.size(); i++) {
                for(int j = 0; j < filters2.size(); j++){
                    if (events.get(i).getFilter().contains(filters2.get(j))) {
                        temp.add(events.get(i));
                        positionsOfEvents.add(i);
                    }
                }

            }
            adapter = new events_fragment_adapter(getContext(),temp);
            eventListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            lastFilters = filters;
            tempCheck = 1;
        }
        else {
            adapter = new events_fragment_adapter(getContext(),events);
            eventListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            tempCheck = 0;
        }

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.events, container, false);


        getLoaderManager().initLoader(0,null, this);


        // Create a list of earthquakes.
        events = new ArrayList<events_fragment_class>();
        temp = new ArrayList<events_fragment_class>();

        // Find a reference to the {@link ListView} in the layout
        ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);


        // Create a new {@link ArrayAdapter} of earthquakes
        adapter = new events_fragment_adapter(getActivity(), events);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        eventListView.setAdapter(adapter);


//        String[] titles = events_fragment_class.allTitles(events);
//        searchResults.addAll(events);
//
//        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,titles);
//
//        searchbar = root_view.findViewById(R.id.mainSearch);
//        searchbar.setAdapter(titleAdapter);


        Button filter = root_view.findViewById(R.id.filterButton);
        filter.setOnClickListener(filterListener);


        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                loaded = true;
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
                if(tempCheck == 1){
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


        return root_view;
    }


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




    private void updateUi(ArrayList arrayList) {
        if (loaded == false) {

            events.addAll(arrayList);

            adapter.notifyDataSetChanged();
        }
    }



    private void buttonFilter(){
        Intent goToFilter = new Intent(getContext(), event_fragment_filter.class);
//        goToFilter.putExtra("events", events);
        goToFilter.putExtra("filters", filters);
        goToFilter.putExtra("filters2", filters2);
        startActivityForResult(goToFilter,1);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == -1) {
                filters = data.getStringExtra("filters");
                filters2 = data.getStringArrayListExtra("filters2");

            }
        }
    }


    @NonNull
    @Override
    public Loader<ArrayList> onCreateLoader(int id, @Nullable Bundle args) {
        return new events_fragment_loader(getContext(), theURL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList> loader, ArrayList data) {
        if(data != null){
            updateUi(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList> loader) {

    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void clearText(View view) {
        searchbar.setText("");
    }

}
