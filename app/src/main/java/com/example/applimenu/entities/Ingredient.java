package com.example.applimenu.entities;

public class Ingredient {
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
