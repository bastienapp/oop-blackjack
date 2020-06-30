package com.wildcodeschool.model;

import java.util.Random;

public class Card {

    private String color;
    private String name;
    private Integer value;

    public Card() {

        Random random = new Random();

        int color = random.nextInt(4);
        switch (color) {

            case 0:
                this.color = "Spade";
                break;

            case 1:
                this.color = "Diamond";
                break;

            case 2:
                this.color = "Club";
                break;

            default:
                this.color = "Heart";
        }
        int value = random.nextInt(13) + 1;
        if (value < 11) {
            this.name = String.valueOf(value);
        } else {
            switch (value) {

                case 11:
                    this.name = "Jack";
                    break;

                case 12:
                    this.name = "Queen";
                    break;

                default:
                    this.name = "King";
            }
            value = 10;
        }
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String toString() {
        return name + " of " + color;
    }
}
