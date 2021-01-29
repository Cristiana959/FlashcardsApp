package com.example.flashcardsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

public class AddQuestionActivity extends AppCompatActivity {

    private TextInputEditText newQuestion;
    private EditText newAnswer;
    public static Deck d;
    private Card c = new Card(" i"," j");

    private MaterialButton addNewQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_question_and_answer_layout);
        newQuestion = findViewById(R.id.new_question_input);
        newAnswer = findViewById(R.id.new_answer_input);
        addNewQuestion = findViewById(R.id.add_question_button);


        Intent intent = getIntent();
        Deck d = (Deck) intent.getSerializableExtra("NEW DECK");

        addNewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setQuestion("Yes?");
                c.setAnswer("No");
                d.addCard(c);


            }
        });


    }
}