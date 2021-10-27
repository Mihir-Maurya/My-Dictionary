package com.example.mydictionary.ViewHolders.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Definitions;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definition_listi_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textview_definition.setText("Definition: " + definitionsList.get(position).getDefinition());
        holder.textview_examples.setText("Example: " + definitionsList.get(position).getExample());
        StringBuilder synonyme = new StringBuilder();
        StringBuilder antonyme = new StringBuilder();
        synonyme.append(definitionsList.get(position).getSynonyms());
        antonyme.append(definitionsList.get(position).getAntonyms());

        holder.textview_synonyms.setText(synonyme);
        holder.textview_antonyms.setText(antonyme);
        holder.textview_synonyms.setSelected(true);
        holder.textview_antonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
