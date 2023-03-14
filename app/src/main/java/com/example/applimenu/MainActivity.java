package com.example.applimenu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerRecettesFavorites;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_carnet);

        recyclerRecettesFavorites = findViewById(R.id.recyclerRecettesFavorites);

        ArrayList<Recette> recettes = new ArrayList<>();
        recettes.add(new Recette("Taboulé", "https://assets.afcdn.com/recipe/20200518/111358_w1024h768c1cx540cy960.webp"));
        recettes.add(new Recette("Glace au chocolat", "https://www.recetin.com/wp-content/uploads/2012/08/helado_chocolate.jpg"));
        recettes.add(new Recette("Vabogoss", "https://m.media-amazon.com/images/M/MV5BMTQ4OTY2ODkwNl5BMl5BanBnXkFtZTgwMTE4ODMyOTE@._V1_.jpg"));

        CustomAdapter adapter = new CustomAdapter(this);
        adapter.setRecettes(recettes);

        recyclerRecettesFavorites.setAdapter(adapter);
        recyclerRecettesFavorites.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));
    }
}
