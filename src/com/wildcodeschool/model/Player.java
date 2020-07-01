package com.wildcodeschool.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Integer score = 0;
    private List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public Card draw(Deck deck) {

        Card card = deck.draw();
        cards.add(card);
        score += card.getValue();

        return card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
