package com.example.applimenu.database;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseSingleton {
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }
}
