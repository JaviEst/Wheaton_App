package com.example.wheaton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.List;
import java.util.Locale;

public class events_fragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList> {

    // Declare View
    View root_view;

    private int position = -1;
    private int lastPosition;
    private ConstraintLayout lastOptions;
    public String filters = "";



    private events_fragment_adapter adapter;






    public events_fragment(){}


    private View.OnClickListener filterListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            buttonFilter();
        }
    };


    public static final String LOG_TAG = events_fragment.class.getName();

    ArrayList<events_fragment_class> events;
    ArrayList<events_fragment_class> temp;
    events_fragment_adapter tempAdapter;
    String lastFilters = " ";
    boolean loaded = false;
    ArrayList<String> filters2;
    int tempCheck = 0;




    private static final String theURL = "https://wheatoncollege.edu/wp-json/tribe/events/v1/events/?page=01&per_page=40&start_date=2020-11-01%2000:00:00&end_date=2020-11-29%2023:59:59&status=publish";


    @Override
    public void onResume() {
        super.onResume();

        loaded = true;

        ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);
        ListView eventListView2 = (ListView) root_view.findViewById(R.id.eventListView);

        if (filters.matches(lastFilters)) {

        }
        else if (!filters.equals("")) {
            ArrayList<events_fragment_class> temp = new ArrayList<events_fragment_class>();
            for (int i = 0; i < events.size(); i++) {
                for(int j = 0; j < filters2.size(); j++){
                    if (events.get(i).getFilter().contains(filters2.get(j))) {
                        temp.add(events.get(i));
                    }
                }

            }
            tempAdapter = new events_fragment_adapter(getActivity(), temp);
            eventListView2.setAdapter(tempAdapter);
            tempAdapter.notifyDataSetChanged();
            lastFilters = filters;
            tempCheck = 1;
        }
        else {
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

        // Find a reference to the {@link ListView} in the layout
        ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);
        ListView eventListView2 = (ListView) root_view.findViewById(R.id.eventListView);


        // Create a new {@link ArrayAdapter} of earthquakes
        adapter = new events_fragment_adapter(getActivity(), events);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        eventListView.setAdapter(adapter);



        Button filter = root_view.findViewById(R.id.filterButton);
        filter.setOnClickListener(filterListener);

        if(tempCheck == 0) {
            eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    adapter.notifyDataSetChanged();


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
            });
        }
        if(tempCheck == 1) {
            eventListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    tempAdapter.notifyDataSetChanged();


                    Intent goToItem = new Intent(view.getContext(), event_fragment_item.class);
                    goToItem.putExtra("title", temp.get(i).getTitle());
                    goToItem.putExtra("date", temp.get(i).getDate());
                    goToItem.putExtra("largeImage", temp.get(i).getLargeimage());
                    goToItem.putExtra("location", temp.get(i).getLocation());
                    goToItem.putExtra("cost", temp.get(i).getCost());
                    goToItem.putExtra("filter", temp.get(i).getFilter());
                    goToItem.putExtra("organizerName", temp.get(i).getOrganName());
                    goToItem.putExtra("organizerPhone", temp.get(i).getOrganPhone());
                    goToItem.putExtra("organizerEmail", temp.get(i).getOrganEmail());
                    goToItem.putExtra("link", temp.get(i).getLink());
                    startActivity(goToItem);


                }
            });
        }

        AutoCompleteTextView editTxt = root_view.findViewById(R.id.mainSearch);



        return root_view;
    }



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
                ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);
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
}
