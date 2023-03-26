package com.example.applimenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StepListAdapter extends RecyclerView.Adapter<StepListAdapter.ViewHolder> {

    private ArrayList<Step> steps = new ArrayList<>();

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
        notifyDataSetChanged();
    }

    private final Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNumber;

        private final TextView textViewText;

        public ViewHolder(View view) {
            super(view);

            textViewNumber = view.findViewById(R.id.textStepNumber);
            textViewText = view.findViewById(R.id.textStepText);
        }
        public TextView getTextViewNumber() { return textViewNumber; }

        public TextView getTextViewText() { return textViewText; }
    }

    public StepListAdapter(Context context) { this.context = context; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.step_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getTextViewNumber().setText("Etape " + position);
        viewHolder.getTextViewText().setText(steps.get(position).toString());
    }

    @Override
    public int getItemCount() { return steps.size(); }
}