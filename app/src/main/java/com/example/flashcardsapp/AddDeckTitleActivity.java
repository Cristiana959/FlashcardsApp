package com.example.flashcardsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;

public class AddDeckTitleActivity extends AppCompatActivity {

    private TextInputEditText newDeckTitle;
    private TextInputEditText newDeckDescription;
    private TextInputEditText newQuestion;
    private TextInputEditText newAnswer;
    private MaterialButton addQuestion;
    private MaterialButton createDeck;
    Deck d ;
    private String title;
    int deck_cards = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        newDeckTitle = findViewById(R.id.new_deck_title_input);
        newDeckDescription = findViewById(R.id.new_description_input);
        newQuestion = findViewById(R.id.new_question_input);
        newAnswer = findViewById(R.id.new_answer_input);
        addQuestion = findViewById(R.id.add_question_button);
        createDeck = findViewById(R.id.create_deck_button);

       d = new Deck();
        ArrayList<Card> cards = new ArrayList<>();

        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setTitle(newDeckTitle.getText().toString());
                d.setDescription(newDeckDescription.getText().toString());

                Card c = new Card();
                c.setQuestion(newQuestion.getText().toString());
                c.setAnswer(newAnswer.getText().toString());

                cards.add(c);

                Toast toast = Toast.makeText(getApplicationContext(), "Question added", Toast.LENGTH_SHORT);
                toast.show();

                newQuestion.setText(" ");
                newAnswer.setText(" ");

            }
    } );

        createDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setCards(cards);
                Intent intent1 = new Intent();
                intent1.putExtra("NEW DECK",(Serializable)d);
                setResult(1,intent1);
                finish();

            }
        });
    }
}

