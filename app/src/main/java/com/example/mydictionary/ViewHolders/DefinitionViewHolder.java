package com.example.mydictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
   public TextView textview_definition,textview_examples,textview_synonyms,textview_antonyms;

    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_definition = itemView.findViewById(R.id.textview_definition);
        textview_examples = itemView.findViewById(R.id.textview_examples);
        textview_synonyms = itemView.findViewById(R.id.textview_synonyms);
        textview_antonyms = itemView.findViewById(R.id.textview_antonyms);
    }
}
