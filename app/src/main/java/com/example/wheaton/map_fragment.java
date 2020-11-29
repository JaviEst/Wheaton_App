package com.example.wheaton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wheaton.map.Building;
import com.example.wheaton.map.buildingAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class map_fragment extends Fragment {

    // Declare view
    View root_view;
    private ArrayList<Building> buildingList;
    private buildingAdapter myAdapter;
    private View listView;
    private int currentPos;
    private View previousListView = null;
    private int previousPos = 0;
    private String mapUrla = "https://www.google.com/maps/dir/?api=1&origin=41.964726429529684, -71.18334581669703&destination=41.96726249863192, -71.18417549267292&mode=walking";


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

        populateList();

        myAdapter = new buildingAdapter(getActivity(), buildingList);
        final ListView todoList = root_view.findViewById(R.id.buildingList);
        todoList.setAdapter(myAdapter);

        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                double currentLat = buildingList.get(i).getLat();
                double currentLong = buildingList.get(i).getLong();

                String mapUrl = "https://www.google.com/maps/dir/?api=1&origin=41.964726429529684, -71.18334581669703&destination= " + currentLat +","+ currentLong +"&mode=walking";


                Uri gmmIntentUri =
                        Uri.parse(mapUrl);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

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

    public void populateList(){
        buildingList = new ArrayList<>();
        buildingList.add(new Building(getString(R.string.Old_Science_Center), 41.964726429529684, -71.18334581669703));
        buildingList.add(new Building(getString(R.string.Mars_Science_Center), 41.96590309947268, -71.18325462159397));
        buildingList.add(new Building(getString(R.string.Filene_Center),41.96535664867712, -71.1843543272545));
        buildingList.add(new Building(getString(R.string.Wallace_Library), 41.96609175342244, -71.18422131074423));
        buildingList.add(new Building(getString(R.string.Registrar_Office), 41.96635020659385, -71.18394318030168));
        buildingList.add(new Building(getString(R.string.Balfour_Hood), 41.966655423396624, -71.1836138831621));
        buildingList.add(new Building(getString(R.string.Admissions_Office), 41.966809708257024, -71.1840379096158));
        buildingList.add(new Building(getString(R.string.SFS), 41.966873434510575, -71.18422736824972));
        buildingList.add(new Building(getString(R.string.Chapel), 41.96726249863192, -71.18417549267292));
        buildingList.add(new Building(getString(R.string.Knapton_Hall), 41.96749560058147, -71.18462432920872));
        buildingList.add(new Building(getString(R.string.Mary_Lyon), 41.96797960039996, -71.1851766603789));
        buildingList.add(new Building(getString(R.string.Park_Hall), 41.96766231280621, -71.18557115488437));
        buildingList.add(new Building(getString(R.string.Emerson_Dining), 41.9668444086196, -71.18532080260748));
        buildingList.add(new Building(getString(R.string.Global_Education), 41.967227978788586, -71.18639238622363));
        buildingList.add(new Building(getString(R.string.Mars_Arts_Humanities), 41.96776102467822, -71.18405007513933));
        buildingList.add(new Building(getString(R.string.Marshal_Center), 41.967653608718436, -71.18678698873218));
        buildingList.add(new Building(getString(R.string.Watson_Fine_Arts), 41.968165498653626, -71.1844826098334));
        buildingList.add(new Building(getString(R.string.Hebe_Hall), 41.967836930655366, -71.18617817750997));
        buildingList.add(new Building(getString(R.string.Clark_Athletic_Field), 41.969947842968665, -71.18782513538311));
        buildingList.add(new Building(getString(R.string.Clark_Rec_Center), 41.96933362308137, -71.187642745177));
        buildingList.add(new Building(getString(R.string.Softball_Field), 41.970185153611716, -71.18699365062));
        buildingList.add(new Building(getString(R.string.Tennis_Courts), 41.96945527099692, -71.1867120186841));
        buildingList.add(new Building(getString(R.string.Haas_Athletic_Center), 41.96457296455014, -71.18216914869618));
        buildingList.add(new Building(getString(R.string.Mirrione_Stadium), 41.96553865886257, -71.18023008394749));
        buildingList.add(new Building(getString(R.string.Nordin_Field), 41.96476157788381, -71.18076773727441));
        buildingList.add(new Building(getString(R.string.Sidell_Stadium), 41.96952293340235, -71.18908628978164));
        buildingList.add(new Building(getString(R.string.Chase), 41.96797067829692, -71.18278077658094));
        buildingList.add(new Building(getString(R.string.Davis_Spencer_Cafe), 41.96579523154216, -71.18337727089148));
        buildingList.add(new Building(getString(R.string.Hood_Cafe), 41.96658212492797, -71.18376797217549));
        buildingList.add(new Building(getString(R.string.Lyons_Den), 41.96659622687124, -71.18360107066171));
        buildingList.add(new Building(getString(R.string.Lot_1), 41.96845908446052, -71.18708907010749));
        buildingList.add(new Building(getString(R.string.Lot_2), 41.96970791790003, -71.18372443102372));
        buildingList.add(new Building(getString(R.string.Lot_3), 41.966360944296625, -71.17818465847444));
        buildingList.add(new Building(getString(R.string.Lot_4), 41.9666862851686, -71.18187910180814));
        buildingList.add(new Building(getString(R.string.Lot_10), 41.96698820203655, -71.1868577928586));
        buildingList.add(new Building(getString(R.string.Lot_1A), 41.96886977122358, -71.18839601652336));
        buildingList.add(new Building(getString(R.string.Lot_7), 41.965010231244214, -71.18203450401562));
        buildingList.add(new Building(getString(R.string.Lot_8), 41.96386982384945, -71.18392909029812));
        buildingList.add(new Building(getString(R.string.Lot_9), 41.964815692603274, -71.18388849202064));
        buildingList.add(new Building(getString(R.string.Beard_Hall), 41.96493979490835, -71.18508388574651));
        buildingList.add(new Building(getString(R.string.Chapin_Hall), 41.967327878691485, -71.18584623121153));
        buildingList.add(new Building(getString(R.string.Clark_Hall), 41.96867952128164, -71.18305397186901));
        buildingList.add(new Building(getString(R.string.Craigin_Hall), 41.966502792468965, -71.18508839669907));
        buildingList.add(new Building(getString(R.string.Everett_Hall), 41.96609942093756, -71.18544421887691));
        buildingList.add(new Building(getString(R.string.Gebbie_Hall), 41.96558713752532, -71.18510611046426));
        buildingList.add(new Building(getString(R.string.Keefe_Hall), 41.96533336597481, -71.18524326764698));
        buildingList.add(new Building(getString(R.string.Kilham_Hall), 41.96764810456335, -71.186267162009));
        buildingList.add(new Building(getString(R.string.Mcintire_Hall), 41.96832815355834, -71.18244715280508));
        buildingList.add(new Building(getString(R.string.Meadows), 41.967732881687006, -71.18177731534601));
        buildingList.add(new Building(getString(R.string.Metcalf_Hall), 41.967797761263526, -71.18590070873101));
        buildingList.add(new Building(getString(R.string.Pine_Hall), 41.96874876967515, -71.18145107443638));
        buildingList.add(new Building(getString(R.string.Stanton_Hall), 41.96604801481859, -71.18494971846334));
        buildingList.add(new Building(getString(R.string.Young_Hall), 41.96865485273384, -71.18223782642319));
        buildingList.add(new Building(getString(R.string.New_Science_Center), 41.96590309947268, -71.18325462159397));
        buildingList.add(new Building(getString(R.string.Meneely), 41.96776102467822, -71.18405007513933));
        buildingList.add(new Building(getString(R.string.Science_Center), 41.964726429529684, -71.18334581669703));




    }


    private static final String[] BUILDINGS = new String[] {
            "Old Science Center", "Mars Center for Science and Technology", "Filene Center", "Wallace Library", "Office of the Registrar", "Balfour Hood", "Admissions Office", "Student Financial Services",
            "Cole Memorial Chapel", "Knapton Hall", "Mary Lyon Hall", "Park Hall", "Larcom Hall", "Emerson Dining Hall", "Center for Global Education", "Mars Arts and Humanities", "Marshal Center for Intercultural Learning",
            "Watson Fine Arts Center", "Hebe Hall",  "Public Safety", "Clark Athletic Field", "Clark Recreation Center", "Softball Field", "Tennis Courts", "Haas Athletic Center", "Keefe Field", "Mirrione Stadium", "Nordin Field", "Sidell Stadium",
            "Chase Dining Hall", "Davis Spencer Cafe", "Hood Cafe", "The Lyons Den", "Parking Lot 1", "Parking Lot 2", "Parking Lot 3", "Parking Lot 4", "Parking Lot 10", "Parking Lot 1A", "Parking Lot 7", "Parking Lot 8", "Parking Lot 9",
            "Beard Hall", "Chapin Hall", "Clark Hall", "Craigin Hall", "Everett Hall", "Gebbie Hall", "Keefe Hall", "Kilham Hall", "Mcintire Hall", "Meadows", "Metcalf Hall", "Pine Hall", "Stanton Hall", "Young Hall", "New Science Center",
            "Science Center", "Meneely"
    };


}
