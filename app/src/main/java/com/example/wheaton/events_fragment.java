package com.example.wheaton;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import android.content.Context;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;

public class events_fragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList> {

    // Declare View
    View root_view;

    private int position = -1;
    private int lastPosition;
    private ConstraintLayout lastOptions;


    public events_fragment(){}


    private View.OnClickListener filterListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            buttonFilter();
        }
    };


    public static final String LOG_TAG = events_fragment.class.getName();

    ArrayList<events_fragment_class> events;
    events_fragment_adapter adapter;
    private static final String theURL = "https://wheatoncollege.edu/wp-json/tribe/events/v1/events/?page=01&per_page=40&start_date=2020-11-01%2000:00:00&end_date=2020-11-29%2023:59:59&status=publish";


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
//                moreInfo.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent goToItem = new Intent(view.getContext(), )
//
//
//                        if(options.getVisibility() == View.VISIBLE){
//                            events.get(position).setButtonVisibility(View.GONE);
//                            adapter.notifyDataSetChanged();
//                        }
//                    }
//                });






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
        Button filter = root_view.findViewById(R.id.filterButton);
        Toast.makeText(getActivity(), "test", Toast.LENGTH_SHORT).show();
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
