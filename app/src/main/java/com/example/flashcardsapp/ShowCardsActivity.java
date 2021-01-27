package com.example.flashcardsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShowCardsActivity extends AppCompatActivity {

    private String mDeckTitle;
    private ArrayList<Deck> decks;
    private TextView cardQuestion;
    private MaterialButton answerButton;
    private MaterialButton nextQuestionButton;
    private TextView cardAnswer;
    private ArrayList<Card> currentDeckCards;
    private int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_layout);

        Intent intent = getIntent();
        //Bundle bundle = intent.getBundleExtra(MainActivity.DECK_BUNDLE);

        mDeckTitle = getIntent().getStringExtra(MainActivity.DECK_TITLE_EXTRA);
        decks = (ArrayList<Deck>) intent.getSerializableExtra(MainActivity.DECK_EXTRA);


        cardQuestion = findViewById(R.id.cardQuestion);
        nextQuestionButton = findViewById(R.id.next_question);

        for (int i = 0; i < decks.size(); i++) {
            questionNumber = 0;
            if (decks.get(i).getTitle().equals(mDeckTitle)) {
                currentDeckCards = decks.get(i).getCards();
                cardQuestion.setText(currentDeckCards.get(0).getQuestion());


                nextQuestionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (questionNumber < currentDeckCards.size() - 1) {
                            cardAnswer.setText(null);
                            questionNumber++;
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "This is the last question", Toast.LENGTH_LONG);
                            toast.show();
                        }

                        cardQuestion.setText(currentDeckCards.get(questionNumber).getQuestion());


                    }
                });


                answerButton = findViewById(R.id.see_answer_button);
                cardAnswer = findViewById(R.id.cardAnswer);

                answerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cardAnswer.setText(currentDeckCards.get(questionNumber).getAnswer());


                    }
                });

            }
        }
    }
}