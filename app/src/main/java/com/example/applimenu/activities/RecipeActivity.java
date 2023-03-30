package com.example.applimenu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applimenu.R;
import com.example.applimenu.adapters.IngredientListAdapter;
import com.example.applimenu.adapters.StepListAdapter;
import com.example.applimenu.dao.RecipeDao;
import com.example.applimenu.database.AppDatabaseSingleton;
import com.example.applimenu.entities.Recipe;

public class RecipeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        RecipeDao recipeDao = AppDatabaseSingleton.getInstance(this).recipeDao();

        Intent intent = getIntent();
        String recipeName = intent.getExtras().get("recipe_name").toString();

        Recipe recipe = recipeDao.findByName(recipeName).get(0);

        TextView textRecipe = findViewById(R.id.recipeName);
        textRecipe.setText(recipeName);

        RecyclerView ingredientList = findViewById(R.id.ingredientList);

        IngredientListAdapter ingredientListAdapter = new IngredientListAdapter(this);
        ingredientListAdapter.setQuantifiedIngredients(recipe.getQuantifiedIngredients());

        ingredientList.setAdapter(ingredientListAdapter);
        ingredientList.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)));

        RecyclerView stepList = findViewById(R.id.stepList);

        StepListAdapter stepListAdapter = new StepListAdapter(this);
        stepListAdapter.setSteps(recipe.getSteps());

        stepList.setAdapter(stepListAdapter);
        stepList.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)));

        ImageButton buttonBackRecipe = findViewById(R.id.buttonBackRecipe);

        buttonBackRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeActivity.this, RecipeBookActivity.class);

                startActivity(intent);
            }
        });
    }
}
