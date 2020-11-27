package com.example.wheaton;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


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

public class events_fragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList> {

    // Declare View
    View root_view;

    private int position = -1;
    private int lastPosition;
    private ConstraintLayout lastOptions;
    public String filters = "";


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
    events_fragment_adapter adapter;
    events_fragment_adapter tempAdapter;
    boolean loaded = false;

    private static final String theURL = "https://wheatoncollege.edu/wp-json/tribe/events/v1/events/?page=01&per_page=40&start_date=2020-11-01%2000:00:00&end_date=2020-11-29%2023:59:59&status=publish";


//    @Override
//    public void onResume() {
//        super.onResume();
//        if(!loaded){
//            loaded = true;
//        }
//        else {
//            ListView eventListView = (ListView) root_view.findViewById(R.id.eventListView);
//            if (!filters.equals("")) {
//                temp.clear();
//                for (int i = 0; i < events.size(); i++) {
//                    temp.add(events.get(i));
//                    if (!events.get(i).getFilter().contains(filters)) {
//                        temp.remove(i);
//                    }
//                }
//                tempAdapter = new events_fragment_adapter(getActivity(), temp);
//                eventListView.setAdapter(tempAdapter);
//            }
//            tempAdapter.notifyDataSetChanged();
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.events, container, false);


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


        Button filter = root_view.findViewById(R.id.filterButton);
        filter.setOnClickListener(filterListener);




        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // If another list is clicked, set the last one to GONE (Could of done if size is not 0)
                if(position != -1){
                    events.get(lastPosition).setButtonVisibility(View.GONE);
                    adapter.notifyDataSetChanged();
                }

                // Get position of current clicked
                position = i;

                // Get current options layout ID
                final ConstraintLayout options = view.findViewById(R.id.buttonLayout);
                // Set the current to the old for next iteration
                lastOptions = options;
                lastPosition = position;
                // Set visibility for current options
                events.get(i).setButtonVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();

                Button moreInfo = view.findViewById(R.id.moreInfoButton);
                moreInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent goToItem = new Intent(view.getContext(), event_fragment_item.class);
                        goToItem.putExtra("title",events.get(position).getTitle());
                        goToItem.putExtra("date",events.get(position).getDate());
                        goToItem.putExtra("largeImage",events.get(position).getLargeimage());
                        goToItem.putExtra("location",events.get(position).getLocation());
                        goToItem.putExtra("cost",events.get(position).getCost());
                        goToItem.putExtra("filter",events.get(position).getFilter());
                        goToItem.putExtra("organizerName",events.get(position).getOrganName());
                        goToItem.putExtra("organizerPhone",events.get(position).getOrganPhone());
                        goToItem.putExtra("organizerEmail",events.get(position).getOrganEmail());
                        goToItem.putExtra("link",events.get(position).getLink());
                        startActivity(goToItem);

                        if(options.getVisibility() == View.VISIBLE){
                            events.get(position).setButtonVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });






            }
        });


//        EditText search = root_view.findViewById(R.id.mainSearch);
//
//        search.addTextChangedListener(new TextWatcher() {
//
//
//            public void afterTextChanged(Editable s) {}
//
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                for(int i = 0; i < events.size(); i++){
//                    if(!events.get(i).getTitle().contains(s)){
//
//                    }
//
//                }
//            }
//        });





        return root_view;
    }



    private void updateUi(ArrayList arrayList) {

        events.addAll(arrayList);

        adapter.notifyDataSetChanged();

    }



    private void buttonFilter(){
        Intent goToFilter = new Intent(getContext(), event_fragment_filter.class);
//        goToFilter.putExtra("events", events);
        goToFilter.putExtra("filters", filters);
        startActivityForResult(goToFilter,1);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == -1) {
                filters = data.getStringExtra("filters");
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
