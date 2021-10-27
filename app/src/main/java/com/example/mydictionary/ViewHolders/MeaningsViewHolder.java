package com.example.mydictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
   public TextView textview_partsofspeech;
   public RecyclerView recycler_definition;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_partsofspeech = itemView.findViewById(R.id.textview_partsofspeech);
        recycler_definition = itemView.findViewById(R.id.recycler_definition);
    }
}
