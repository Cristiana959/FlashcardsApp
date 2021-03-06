package com.example.flashcardsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private ArrayList<Deck> dataSet;

    private LayoutInflater inflater;




    Context context;

    public CardAdapter(ArrayList<Deck> dataSet, Context context){
        this.dataSet = dataSet;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.deck_layout, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.CardViewHolder holder, int position) {

        holder.update(dataSet.get(position).getTitle(),dataSet.get(position).getDescription(),dataSet.get(position).getCards());



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updateAdapter(Deck d){
        //dataSet.clear();
        dataSet.add(d);
        notifyDataSetChanged();
    }



    public class CardViewHolder extends RecyclerView.ViewHolder{

        private TextView deckTtile;
        private TextView  deckDescription;
        private ArrayList<Card> cards = new ArrayList<>();
        private MaterialButton seeCardsButton;
        private TextView newDecktile;
        private TextView newQuestion;
        private TextView newAnswer;
        private MaterialButton addNewDeckTitleButton;
        private MaterialButton addNewQuestionButton;
        private Button addDeckButton;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            deckTtile = itemView.findViewById(R.id.deckTitle);
            deckDescription = itemView.findViewById(R.id.deckDescription);
            seeCardsButton = itemView.findViewById(R.id.seeCardsButton);
            newDecktile = itemView.findViewById(R.id.new_deck_title_input);
            newQuestion = itemView.findViewById(R.id.new_question_input);
            newAnswer = itemView.findViewById(R.id.new_answer_input);

            addNewQuestionButton = itemView.findViewById(R.id.add_question_button);
            addDeckButton = itemView.findViewById(R.id.add_deck_button);

        }



        public void update(String newTitle, String newDescription,ArrayList<Card> newCards){


            deckTtile.setText(newTitle);

            deckDescription.setText(newDescription);
            cards = newCards;
            seeCardsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context,ShowCardsActivity.class);
                    intent.putExtra(MainActivity.DECK_TITLE_EXTRA, newTitle);

                    intent.putExtra(MainActivity.DECK_EXTRA,dataSet);
                    //intent.putExtra(MainActivity.DECK_BUNDLE,dataSet);
                    context.startActivity(intent);
                }


            

            });


        }

    }

}
