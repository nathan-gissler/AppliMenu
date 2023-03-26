package com.example.applimenu;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    private TextView textRecipe;

    private RecyclerView ingredientList;

    private RecyclerView stepList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        Intent intent = getIntent();
        String recipeName = intent.getExtras().get("recipe_name").toString();

        textRecipe = findViewById(R.id.recipeName);
        textRecipe.setText(recipeName);

        ingredientList = findViewById(R.id.ingredientList);

        ArrayList<QuantifiedIngredient> quantifiedIngredients = new ArrayList<>();
        quantifiedIngredients.add(new QuantifiedIngredient("Tomate(s)", 2));
        quantifiedIngredients.add(new QuantifiedIngredient("Poivron(s)", 1));
        quantifiedIngredients.add(new QuantifiedIngredient("Pomme(s) de terre", 4));

        IngredientListAdapter ingredientListAdapter = new IngredientListAdapter(this);
        ingredientListAdapter.setQuantifiedIngredients(quantifiedIngredients);

        ingredientList.setAdapter(ingredientListAdapter);
        ingredientList.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)));

        stepList = findViewById(R.id.stepList);

        ArrayList<Step> steps = new ArrayList<>();
        steps.add(new Step("Préparer"));
        steps.add(new Step("Couper"));
        steps.add(new Step("Cuire"));

        StepListAdapter stepListAdapter = new StepListAdapter(this);
        stepListAdapter.setSteps(steps);

        stepList.setAdapter(stepListAdapter);
        stepList.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)));
    }
}
