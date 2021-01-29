package com.example.flashcardsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class AddDeckActivity extends AppCompatActivity {

    private MaterialButton addDeckTitleButton;
    private MaterialButton addQuestionButton;
    private TextView newDeckTtile;
    private TextView newQuestionText;
    private TextView newAnswerText;
    private Card newCard;
    private static final String ADD_NEW_DECK_TITLE_EXTRA = "com.example.flashcardsapp.key.NEW_DECK_TITLE_EXTRA";
    private static final String ADD_NEW_QUESTION_EXTRA = "com.example.flashcardsapp.key.NEW_QUESTION_EXTRA";
    private static final String ADD_NEW_ANSWER_EXTRA = "com.example.flashcardsapp.key.NEW_ANSWER_EXTRA";

    public Card getNewCard() {
        return newCard;
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deck_title);

        newDeckTtile = findViewById(R.id.new_deck_title_input);
        addDeckTitleButton = findViewById(R.id.set_title_button);

        addDeckTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.add_question_and_answer_layout);
                newQuestionText = findViewById(R.id.new_question_input);
                newAnswerText = findViewById(R.id.new_answer_input);
                addQuestionButton = findViewById(R.id.add_question_button);

                 newCard = new Card((String)newQuestionText.getText(),(String)newAnswerText.getText());

                addQuestionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), CardAdapter.class);
                        intent.putExtra(ADD_NEW_QUESTION_EXTRA,newQuestionText.getText());
                        intent.putExtra(ADD_NEW_ANSWER_EXTRA,newAnswerText.getText());
                    }
                });


            }
        });

    }


}
