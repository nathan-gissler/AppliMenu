package com.example.applimenu.converters;

import androidx.room.TypeConverter;

import com.example.applimenu.entities.QuantifiedIngredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuantifiedIngredientConverter {
    public static QuantifiedIngredient toQuantifiedIngredient(String value) {
        List<String> strs = Arrays.asList(value.split(","));
        return new QuantifiedIngredient(strs.get(0), Integer.parseInt(strs.get(1)));
    }

    @TypeConverter
    public static ArrayList<QuantifiedIngredient> toQuantifiedIngredientArrayList(String value) {
        List<String> strs = Arrays.asList(value.split(";"));
        ArrayList<QuantifiedIngredient> quantifiedIngredientArrayList = new ArrayList<>();
        for (String str : strs) {
            quantifiedIngredientArrayList.add(toQuantifiedIngredient(str));
        }
        return quantifiedIngredientArrayList;
    }

    public static String toString(QuantifiedIngredient quantifiedIngredient) {
        return quantifiedIngredient.getIngredient().toString() +
                "," +
                String.valueOf(quantifiedIngredient.getQuantity());
    }

    @TypeConverter
    public static String toString(ArrayList<QuantifiedIngredient> quantifiedIngredientArrayList) {
        StringBuilder sb = new StringBuilder();
        for (QuantifiedIngredient quantifiedIngredient : quantifiedIngredientArrayList) {
            sb.append(toString(quantifiedIngredient));
            sb.append(";");
        }
        return sb.toString();
    }
}
