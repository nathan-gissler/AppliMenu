package com.example.applimenu.entities;

import com.example.applimenu.entities.Ingredient;

public class QuantifiedIngredient {

    private Ingredient ingredient;

    private int quantity;

    public QuantifiedIngredient(String ingredient, int quantity) {
        this.ingredient = new Ingredient(ingredient);
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + ingredient;
    }
}
