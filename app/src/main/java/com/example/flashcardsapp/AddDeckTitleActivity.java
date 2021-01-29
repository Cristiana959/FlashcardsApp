package com.example.flashcardsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

public class AddDeckTitleActivity extends AppCompatActivity {

    private TextInputEditText newDecktitle;
    private MaterialButton addNewDeckTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deck_title);
        newDecktitle = findViewById(R.id.new_deck_title_input);
        addNewDeckTitle = findViewById(R.id.set_title_button);

        addNewDeckTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddQuestionActivity.class);
                Deck d = new Deck();
                d.setTitle(newDecktitle.getText().toString());
                d.setDescription("new desc");

                intent.putExtra("NEW DECK",(Serializable)d);
                setResult(Activity.RESULT_OK,intent);
                finish();

               // startActivity(intent);

            }
        });
    }
}