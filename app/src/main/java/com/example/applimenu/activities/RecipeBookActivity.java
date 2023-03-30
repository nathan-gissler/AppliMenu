package com.example.applimenu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applimenu.R;
import com.example.applimenu.adapters.RecipeListAdapter;
import com.example.applimenu.dao.RecipeDao;
import com.example.applimenu.database.AppDatabaseSingleton;
import com.example.applimenu.entities.QuantifiedIngredient;
import com.example.applimenu.entities.Recipe;
import com.example.applimenu.entities.Step;

import java.util.ArrayList;

public class RecipeBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_recipe_book);

        RecipeDao recipeDao = AppDatabaseSingleton.getInstance(this).recipeDao();

        RecyclerView recyclerFavoriteRecipes = findViewById(R.id.recyclerFavoriteRecipes);

        ArrayList<Recipe> favoriteRecipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        recipe1.setName("Taboulé");
        recipe1.setImgUrl("https://assets.afcdn.com/recipe/20200518/111358_w1024h768c1cx540cy960.webp");
        ArrayList<QuantifiedIngredient> quantifiedIngredients1 = new ArrayList<>();
        quantifiedIngredients1.add(new QuantifiedIngredient("semoule", 1));
        quantifiedIngredients1.add(new QuantifiedIngredient("tomate(s)", 3));
        quantifiedIngredients1.add(new QuantifiedIngredient("chose(s)", 8));
        recipe1.setQuantifiedIngredients(quantifiedIngredients1);
        ArrayList<Step> steps1 = new ArrayList<>();
        steps1.add(new Step("Couper"));
        steps1.add(new Step("Cuire"));
        steps1.add(new Step("C'est près !"));
        recipe1.setSteps(steps1);
        Recipe recipe2 = new Recipe();
        recipe2.setName("Glace au chocolat");
        recipe2.setImgUrl("https://www.recetin.com/wp-content/uploads/2012/08/helado_chocolate.jpg");
        ArrayList<QuantifiedIngredient> quantifiedIngredients2 = new ArrayList<>();
        quantifiedIngredients2.add(new QuantifiedIngredient("glace", 2));
        quantifiedIngredients2.add(new QuantifiedIngredient("eau", 7));
        quantifiedIngredients2.add(new QuantifiedIngredient("chocolat", 4));
        recipe2.setQuantifiedIngredients(quantifiedIngredients2);
        ArrayList<Step> steps2 = new ArrayList<>();
        steps2.add(new Step("Couper"));
        steps2.add(new Step("Cuire"));
        steps2.add(new Step("C'est près !"));
        recipe2.setSteps(steps2);
        Recipe recipe3 = new Recipe();
        recipe3.setName("Vabogoss");
        recipe3.setImgUrl("https://m.media-amazon.com/images/M/MV5BMTQ4OTY2ODkwNl5BMl5BanBnXkFtZTgwMTE4ODMyOTE@._V1_.jpg");
        ArrayList<QuantifiedIngredient> quantifiedIngredients3 = new ArrayList<>();
        quantifiedIngredients3.add(new QuantifiedIngredient("va", 10));
        quantifiedIngredients3.add(new QuantifiedIngredient("bo", 5));
        quantifiedIngredients3.add(new QuantifiedIngredient("goss", 10));
        recipe3.setQuantifiedIngredients(quantifiedIngredients3);
        ArrayList<Step> steps3 = new ArrayList<>();
        steps3.add(new Step("Couper"));
        steps3.add(new Step("Cuire"));
        steps3.add(new Step("C'est près !"));
        recipe3.setSteps(steps3);
        favoriteRecipes.add(recipe1);
        favoriteRecipes.add(recipe2);
        favoriteRecipes.add(recipe3);
        favoriteRecipes.add(recipe1);
        favoriteRecipes.add(recipe2);
        favoriteRecipes.add(recipe3);

        RecipeListAdapter favoriteRecipesAdapter = new RecipeListAdapter(this);
        favoriteRecipesAdapter.setRecipes(favoriteRecipes);

        recyclerFavoriteRecipes.setAdapter(favoriteRecipesAdapter);
        recyclerFavoriteRecipes.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        RecyclerView recyclerPersonalRecipes = findViewById(R.id.recyclerPersonalRecipes);

        ArrayList<Recipe> personalRecipes = new ArrayList<>(recipeDao.getAll());

        RecipeListAdapter personalRecipesAdapter = new RecipeListAdapter(this);
        personalRecipesAdapter.setRecipes(personalRecipes);

        recyclerPersonalRecipes.setAdapter(personalRecipesAdapter);
        recyclerPersonalRecipes.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        Button buttonAddRecipe = findViewById(R.id.buttonAddRecipe);

        buttonAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeBookActivity.this, AddRecipeActivity.class);

                startActivity(intent);
            }
        });
    }
}
