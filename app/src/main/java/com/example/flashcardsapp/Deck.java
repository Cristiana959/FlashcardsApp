package com.example.flashcardsapp;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable {
   private String title;
   private String description;
   private ArrayList<Card> cards;

    public Deck(String title, String description) {
        this.title = title;
        this.description = description;
        cards = new ArrayList<>();
    }

    public Deck(){

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card c){
        cards.add(c);
    }
    public void removeCard(Card c){
        cards.remove(c);
    }
}
