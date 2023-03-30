package com.example.applimenu.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.applimenu.entities.Recipe;
import com.example.applimenu.converters.QuantifiedIngredientConverter;
import com.example.applimenu.converters.StepConverter;
import com.example.applimenu.dao.RecipeDao;

@Database(entities = {Recipe.class}, version = 2)
@TypeConverters({QuantifiedIngredientConverter.class, StepConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract RecipeDao recipeDao();
}
