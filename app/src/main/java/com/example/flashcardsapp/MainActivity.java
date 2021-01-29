package com.example.flashcardsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Deck> dataSet;

    public static CardAdapter mAdapter;
    public MaterialButton seeDeckButton;
    public TextView mDeckTitle;
    public Button addDeckButton;
    public MaterialButton addNewDeckTitleButton;
    public MaterialButton addNewQuestionButton;
    public TextInputEditText newDeckTitle;
    public TextInputEditText newQuestion;
    public EditText newAnswer;
    public TextView bigTitle;

    int deck_title = 1;





    public static final String DECK_TITLE_EXTRA = "com.example.flashcardsapp.key.DECK_TITLE_EXTRA";
    public static final String DECK_EXTRA = "com.example.flashcardsapp.key.DECK_EXTRA";

    public ArrayList<Deck> getDataSet(){
        return dataSet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bigTitle = findViewById(R.id.big_title);
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

        Deck test = new Deck("test","test");
        test.addCard(c1);





        RecyclerView recyclerView = findViewById(R.id.cards_recyclerview);
        //View cardView = View.inflate(this,R.layout.cardview_layout,)

        int nrColumn = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, nrColumn));


        mAdapter = new CardAdapter(dataSet, this);


        recyclerView.setAdapter(mAdapter);



        mDeckTitle = findViewById(R.id.deckTitle);
        seeDeckButton = recyclerView.findViewById(R.id.seeCardsButton);
        System.out.println(seeDeckButton);
        addDeckButton = findViewById(R.id.add_deck_button);

        addDeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddDeckTitleActivity.class);

                startActivityForResult(intent,deck_title);
            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == deck_title) {
            if (requestCode == Activity.RESULT_OK) {
                Deck result = (Deck) data.getSerializableExtra("NEW DECK");
                mAdapter.updateAdapter(result);

            }
        }

    }}