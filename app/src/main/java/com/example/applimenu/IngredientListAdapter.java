package com.example.applimenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.ViewHolder> {

    private ArrayList<QuantifiedIngredient> quantifiedIngredients = new ArrayList<>();

    public void setQuantifiedIngredients(ArrayList<QuantifiedIngredient> quantifiedIngredients) {
        this.quantifiedIngredients = quantifiedIngredients;
        notifyDataSetChanged();
    }

    private final Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.textIngredient);
        }
        public TextView getTextView() { return textView; }
    }

    public IngredientListAdapter(Context context) { this.context = context; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredient_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(quantifiedIngredients.get(position).toString());
    }

    @Override
    public int getItemCount() { return quantifiedIngredients.size(); }
}
