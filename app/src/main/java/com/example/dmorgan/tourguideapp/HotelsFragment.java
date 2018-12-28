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


public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        final ArrayList<Places> places = new ArrayList<>();

        final PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        places.add(new Places("Holiday Inn",R.drawable.holiday,"Two Montgomery Village Ave,\n Gaithersburg, MD 20879","301-948-8900"));
        places.add(new Places("Courtyard by Marriott",R.drawable.marriot,"204 Boardwalk Pl, Gaithersburg,\n MD 20878","301-527-9000"));

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
