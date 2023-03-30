package com.example.applimenu.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.applimenu.entities.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("SELECT * FROM recipe")
    List<Recipe> getAll();

    @Query("SELECT * FROM recipe WHERE name IS (:name)")
    List<Recipe> findByName(String name);

    @Insert
    void insert(Recipe recipe);
}
