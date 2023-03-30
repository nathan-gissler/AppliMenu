package com.example.applimenu.converters;

import androidx.room.TypeConverter;

import com.example.applimenu.entities.Step;

import java.util.ArrayList;

public class StepConverter {
    @TypeConverter
    public static ArrayList<Step> toStep(String value) {
        String[] strs = value.split(",");
        ArrayList<Step> steps = new ArrayList<>();
        for (String str : strs) {
            steps.add(new Step(str));
        }
        return steps;
    }

    @TypeConverter
    public static String toString(ArrayList<Step> steps) {
        StringBuilder sb = new StringBuilder();
        for (Step step : steps) {
            sb.append(step.toString());
            sb.append(",");
        }
        return sb.toString();
    }
}
