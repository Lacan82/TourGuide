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


public class EntertainFragment extends Fragment {

    public EntertainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        final ArrayList<Places> places = new ArrayList<>();

        final PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        places.add(new Places("Monster Mini Golf",R.drawable.monster,"9116 Gaither Rd,\n Gaithersburg, MD 20877","301-330-6464"));
        places.add(new Places("Muse Paintbar",R.drawable.muse,"217 Boardwalk Pl #225,\n Gaithersburg, MD 20878","301-327-2500"));
        places.add(new Places("AMC Rio",R.drawable.monster,"9811 Washingtonian Ctr,\n Gaithersburg, MD 20878","301-948-6673"));


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
