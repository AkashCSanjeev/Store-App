package com.example.storeapp.Model;

public class Recommendation {

    int image;
    String drink,description,rate;

    public Recommendation(int image, String drink) {
        this.image = image;
        this.drink = drink;
    }

    public Recommendation(int image, String drink, String description, String rate) {
        this.image = image;
        this.drink = drink;
        this.description = description;
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    public String getDrink() {
        return drink;
    }

    public String getDescription() {
        return description;
    }

    public String getRate() {
        return rate;
    }
}
