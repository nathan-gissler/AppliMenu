package com.example.applimenu.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Recipe {

    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "image")
    public String imgUrl;
    @ColumnInfo(name = "quantified_ingredients")
    public ArrayList<QuantifiedIngredient> quantifiedIngredients;
    @ColumnInfo(name = "steps")
    public ArrayList<Step> steps;

    // TODO : améliorer ça
    public Recipe() {};

    /*public Recipe(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Recipe(String name, String imgUrl, ArrayList<QuantifiedIngredient> quantifiedIngredients, ArrayList<Step> steps) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.quantifiedIngredients = quantifiedIngredients;
        this.steps = steps;
    }*/

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ArrayList<QuantifiedIngredient> getQuantifiedIngredients() {
        return quantifiedIngredients;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setQuantifiedIngredients(ArrayList<QuantifiedIngredient> quantifiedIngredients) {
        this.quantifiedIngredients = quantifiedIngredients;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
