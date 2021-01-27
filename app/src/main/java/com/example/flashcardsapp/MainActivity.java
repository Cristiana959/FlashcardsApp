package com.example.flashcardsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Deck> dataSet;

    public CardAdapter mAdapter;
    public MaterialButton seeDeckButton;
    public TextView mDeckTitle;

    public static final String DECK_TITLE_EXTRA = "com.example.flashcardsapp.key.DECK_TITLE_EXTRA";
    public static final String DECK_EXTRA = "com.example.flashcardsapp.key.DECK_EXTRA";
    public static final String DECK_BUNDLE = "com.example.flashcardsapp.key.DECK_BUNDLE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new ArrayList<Deck>();

        Deck front1 = new Deck("Title 1", "Description1");
        Deck front2 = new Deck("Title 2", "Description2");
        Deck front3 = new Deck("Title 3", "Description3");

        Card c1 = new Card("First Question","First Answer");
        Card c2 = new Card("Second Deck FQ","Second Answer");
        Card c3 = new Card("Third Deck FQ","Third Answer");

        front1.addCard(c1);
        front1.addCard(c2);
        front1.addCard(c3);

        dataSet.add(front1);
        dataSet.add(front2);
        dataSet.add(front3);



        RecyclerView recyclerView = findViewById(R.id.cards_recyclerview);
        //View cardView = View.inflate(this,R.layout.cardview_layout,)

        int nrColumn = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, nrColumn));

        mAdapter = new CardAdapter(dataSet, this);

        recyclerView.setAdapter(mAdapter);

        mDeckTitle = findViewById(R.id.deckTitle);
        seeDeckButton = recyclerView.findViewById(R.id.seeCardsButton);
        System.out.println(seeDeckButton);






    }
}