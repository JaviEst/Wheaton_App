package com.example.wheaton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class map_fragment extends Fragment {

    // Declare view
    View root_view;
    MapView mapView;
    GoogleMap map;


    private AdapterView.OnItemClickListener searchBarListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            searchBarFunc();
        }
    };

    public map_fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.map, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, BUILDINGS);
        AutoCompleteTextView searchBuilding = (AutoCompleteTextView)
                root_view.findViewById(R.id.searchBar);
        searchBuilding.setAdapter(adapter);
        searchBuilding.setOnItemClickListener(searchBarListener);



        return root_view;
    }

    public void searchBarFunc(){

        AutoCompleteTextView auto = root_view.findViewById(R.id.searchBar);


    }


    private static final String[] BUILDINGS = new String[] {
      "Old_Science_Center", "Mars Center for Science and Technology", "Filene Center", "Wallace Library", "Office of the Registrar", "Balfour Hood", "Admissions Office", "Student Financial Services",
            "Cole Memorial Chapel", "Knapton Hall", "Mary Lyon Hall", "Park Hall", "Larcom Hall", "Emerson Dining Hall", "Center for Global Education", "Mars Arts and Humanities", "Marshal Center for Intercultural Learning",
            "Watson Fine Arts Center", "Hebe Hall",  "Public Safety", "Clark Athletic Field", "Clark Recreation Center", "Softball Field", "Tennis Courts", "Haas Athletic Center", "Keefe Field", "Mirrione Stadium", "Nordin Field", "Sidell Stadium",
            "Chase Dining Hall", "Davis Spencer Cafe", "Hood Cafe", "The Lyons Den", "Parking Lot 1", "Parking Lot 2", "Parking Lot 3", "Parking Lot 4", "Parking Lot 10", "Parking Lot 1A", "Parking Lot 7", "Parking Lot 8", "Parking Lot 9",
            "Beard Hall", "Chapin Hall", "Clark Hall", "Craigin Hall", "Everett Hall", "Gebbie Hall", "Keefe Hall", "Kilham Hall", "Mcintire Hall", "Meadows", "Metcalf Hall", "Pine Hall", "Stanton Hall", "Young Hall", "New Science Center",
            "Science Center", "Meneely"
    };


}
