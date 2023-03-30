package com.example.applimenu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applimenu.R;
import com.example.applimenu.adapters.IngredientListAdapter;
import com.example.applimenu.adapters.StepListAdapter;
import com.example.applimenu.dao.RecipeDao;
import com.example.applimenu.database.AppDatabaseSingleton;
import com.example.applimenu.entities.QuantifiedIngredient;
import com.example.applimenu.entities.Recipe;
import com.example.applimenu.entities.Step;

import java.util.ArrayList;

public class AddRecipeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        RecipeDao recipeDao = AppDatabaseSingleton.getInstance(this).recipeDao();

        ImageButton buttonBackAddRecipe = findViewById(R.id.buttonBackAddRecipe);

        buttonBackAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRecipeActivity.this, RecipeBookActivity.class);

                startActivity(intent);
            }
        });

        EditText editTextAddRecipeName = findViewById(R.id.editTextAddRecipeName);

        Button buttonAddRecipeIngredient = findViewById(R.id.buttonAddRecipeIngredient);
        EditText editTextAddRecipeIngredient = findViewById(R.id.editTextAddRecipeIngredient);
        EditText editTextAddRecipeIngredientQuantity = findViewById(R.id.editTextAddRecipeIngredientQuantity);
        ArrayList<QuantifiedIngredient> quantifiedIngredients = new ArrayList<>();

        buttonAddRecipeIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantifiedIngredients.add(new QuantifiedIngredient(editTextAddRecipeIngredient.getText().toString(), Integer.parseInt(editTextAddRecipeIngredientQuantity.getText().toString())));
                editTextAddRecipeIngredient.setText("");
                editTextAddRecipeIngredientQuantity.setText("");
            }
        });

        RecyclerView recyclerAddIngredient = findViewById(R.id.recyclerAddIngredient);

        IngredientListAdapter ingredientListAdapter = new IngredientListAdapter(this);
        ingredientListAdapter.setQuantifiedIngredients(quantifiedIngredients);

        recyclerAddIngredient.setAdapter(ingredientListAdapter);
        recyclerAddIngredient.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)));

        Button buttonAddRecipeStep = findViewById(R.id.buttonAddRecipeStep);
        EditText editTextAddRecipeStep = findViewById(R.id.editTextAddRecipeStep);
        ArrayList<Step> steps = new ArrayList<>();

        buttonAddRecipeStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                steps.add(new Step(editTextAddRecipeStep.getText().toString()));
                editTextAddRecipeStep.setText("");
            }
        });

        RecyclerView recyclerAddStep = findViewById(R.id.recyclerAddStep);

        StepListAdapter stepListAdapter = new StepListAdapter(this);
        stepListAdapter.setSteps(steps);

        recyclerAddStep.setAdapter(stepListAdapter);
        recyclerAddStep.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)));

        Button buttonSaveRecipe = findViewById(R.id.buttonSaveRecipe);

        buttonSaveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = new Recipe();
                recipe.setName(editTextAddRecipeName.getText().toString());
                recipe.setImgUrl("https://assets.afcdn.com/recipe/20200518/111358_w1024h768c1cx540cy960.webp");
                recipe.setQuantifiedIngredients(quantifiedIngredients);
                recipe.setSteps(steps);
                recipeDao.insert(recipe);

                Intent intent = new Intent(AddRecipeActivity.this, RecipeBookActivity.class);

                startActivity(intent);
            }
        });
    }
}
