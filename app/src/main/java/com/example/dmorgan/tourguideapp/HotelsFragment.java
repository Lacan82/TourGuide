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

        places.add(new Places(getString(R.string.Holiday),R.drawable.holiday,getString(R.string.HolidayAddress),getString(R.string.HolidayPhone)));
        places.add(new Places(getString(R.string.Courtyard),R.drawable.marriot,getString(R.string.CourtyardAddress),getString(R.string.CourtyardPhone)));

        ListView listView = view.findViewById(R.id.places_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Places selectedPlace = places.get(position);
                // Log.v("grabbing right Place?", selectedPlace.getPlace() + selectedPlace.getPlaceImage());
                Intent myIntent = new Intent(view.getContext(), DetailFragment.class);
                myIntent.putExtra(getString(R.string.Extra1), selectedPlace.getPlace());
                myIntent.putExtra(getString(R.string.Extra2), selectedPlace.getPlaceImage());
                myIntent.putExtra(getString(R.string.Extra3), selectedPlace.getPlaceAddress());
                myIntent.putExtra(getString(R.string.Extra4), selectedPlace.getPlacePhone());
                startActivityForResult(myIntent, 1);



            }
        });
        return view;
        }
    }
