package com.example.applimenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Recette> recettes = new ArrayList<>();

    public void setRecettes(ArrayList<Recette> recettes) {
        this.recettes = recettes;
        notifyDataSetChanged();
    }

    private Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private ImageView image;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textRecette);
            image = view.findViewById(R.id.image);
        }

        public TextView getTextView() {
            return textView;
        }
    }

//    /**
//     * Initialize the dataset of the Adapter
//     *
//     * @param dataSet String[] containing the data to populate views to be used
//     * by RecyclerView
//     */
//    public CustomAdapter(String[] dataSet) {
//        localDataSet = dataSet;
//    }

    public CustomAdapter(Context context) {
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recette_list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(recettes.get(position).toString());

        Glide.with(context)
                .asBitmap()
                .load(recettes.get(position).getImgUrl())
                .into(viewHolder.image);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return recettes.size();
    }
}