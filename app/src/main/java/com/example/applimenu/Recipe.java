package com.example.applimenu;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private String imgUrl;

    private ArrayList<QuantifiedIngredient> quantifiedIngredients;

    private ArrayList<Step> steps;

    // TODO : améliorer ça
    public Recipe(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Recipe(String name, String imgUrl, ArrayList<QuantifiedIngredient> quantifiedIngredients, ArrayList<Step> steps) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.quantifiedIngredients = quantifiedIngredients;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ArrayList<QuantifiedIngredient> getQuantifiedIngredients() {
        return quantifiedIngredients;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }
}
