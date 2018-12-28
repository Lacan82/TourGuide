package com.example.dmorgan.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class SightFragment extends Fragment {


    public SightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        final ArrayList<Places> places = new ArrayList<>();


        final PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        places.add(new Places("Seneca Creek State Park",R.drawable.seneca,"11950 Clopper Rd,\n Gaithersburg, MD 20878","301-924-2127"));
        places.add(new Places("Gaithersburg museum",R.drawable.station,"9 S Summit Ave,\n Gaithersburg, MD 20877","301-258-6160"));
        places.add(new Places("Washingtonian Rio",R.drawable.rio,"9811 Washingtonian Blvd,\n Gaithersburg, MD 20878","301-921-4684"));

        ListView listView = view.findViewById(R.id.places_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Places selectedPlace = places.get(position);
                Log.v("grabbing right Place?", selectedPlace.getPlace() + selectedPlace.getPlaceImage());
                // selectedItem.setSelectedItem(selectedAlbum.getAlbums());
                Intent myIntent = new Intent(view.getContext(), DetailFragment.class);
                myIntent.putExtra("Place", selectedPlace.getPlace());
                myIntent.putExtra("Image", selectedPlace.getPlaceImage());
                myIntent.putExtra("Address", selectedPlace.getPlaceAddress());
                myIntent.putExtra("Phone", selectedPlace.getPlacePhone());
                startActivityForResult(myIntent, 1);



            }
        });
        return view;
        }
    }
