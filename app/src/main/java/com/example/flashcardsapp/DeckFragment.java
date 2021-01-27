package com.example.flashcardsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DeckFragment extends Fragment {

    CardAdapter mAdapter;
    GridView grid;
    ArrayList<Deck> dataSet;

    public DeckFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_layout, container, false);

        grid = (GridView) v.findViewById(R.id.gridView);

        grid.setDrawSelectorOnTop(true);

        mAdapter = new CardAdapter(dataSet,getActivity().getApplicationContext());
        grid.setAdapter((ListAdapter) mAdapter);

        return v;


    }
}
