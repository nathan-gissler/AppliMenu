package com.example.applimenu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerFavoriteRecipes;

    private RecyclerView recyclerPersonalRecipes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_recipe_book);

        recyclerFavoriteRecipes = findViewById(R.id.recyclerFavoriteRecipes);

        ArrayList<Recipe> favoriteRecipes = new ArrayList<>();
        favoriteRecipes.add(new Recipe("Taboulé", "https://assets.afcdn.com/recipe/20200518/111358_w1024h768c1cx540cy960.webp"));
        favoriteRecipes.add(new Recipe("Glace au chocolat", "https://www.recetin.com/wp-content/uploads/2012/08/helado_chocolate.jpg"));
        favoriteRecipes.add(new Recipe("Vabogoss", "https://m.media-amazon.com/images/M/MV5BMTQ4OTY2ODkwNl5BMl5BanBnXkFtZTgwMTE4ODMyOTE@._V1_.jpg"));

        RecipeListAdapter favoriteRecipesAdapter = new RecipeListAdapter(this);
        favoriteRecipesAdapter.setRecipes(favoriteRecipes);

        recyclerFavoriteRecipes.setAdapter(favoriteRecipesAdapter);
        recyclerFavoriteRecipes.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        recyclerPersonalRecipes = findViewById(R.id.recyclerPersonalRecipes);

        ArrayList<Recipe> personalRecipes = new ArrayList<>();
        personalRecipes.add(new Recipe("Glace au chocolat", "https://www.recetin.com/wp-content/uploads/2012/08/helado_chocolate.jpg"));
        personalRecipes.add(new Recipe("Vabogoss", "https://m.media-amazon.com/images/M/MV5BMTQ4OTY2ODkwNl5BMl5BanBnXkFtZTgwMTE4ODMyOTE@._V1_.jpg"));
        personalRecipes.add(new Recipe("Taboulé", "https://assets.afcdn.com/recipe/20200518/111358_w1024h768c1cx540cy960.webp"));
        personalRecipes.add(new Recipe("Glace au chocolat", "https://www.recetin.com/wp-content/uploads/2012/08/helado_chocolate.jpg"));
        personalRecipes.add(new Recipe("Vabogoss", "https://m.media-amazon.com/images/M/MV5BMTQ4OTY2ODkwNl5BMl5BanBnXkFtZTgwMTE4ODMyOTE@._V1_.jpg"));
        personalRecipes.add(new Recipe("Taboulé", "https://assets.afcdn.com/recipe/20200518/111358_w1024h768c1cx540cy960.webp"));

        RecipeListAdapter personalRecipesAdapter = new RecipeListAdapter(this);
        personalRecipesAdapter.setRecipes(personalRecipes);

        recyclerPersonalRecipes.setAdapter(personalRecipesAdapter);
        recyclerPersonalRecipes.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

        Button buttonAddRecipe = findViewById(R.id.buttonAddRecipe);

        buttonAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BUTTONS", "Add recipe clicked");
            }
        });
    }
}
