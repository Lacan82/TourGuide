package com.example.dmorgan.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Places> {
    public PlacesAdapter(Context context, ArrayList<Places> albums) {
        super(context, 0, albums);
    }
    @Override
    public View getView(int  position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Places currentAlbums = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.default_imageView);

        imageView.setImageResource(currentAlbums.getPlaceImage());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentAlbums.getPlace());

        return listItemView;
    }

}
