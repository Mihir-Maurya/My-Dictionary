package com.example.mydictionary.ViewHolders.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Meanings;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.MeaningsViewHolder;

import java.util.List;

public class MeaninAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {
   private Context context;
   List<Meanings> meaningsList;

    public MeaninAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
       holder.textview_partsofspeech.setText("Parts of Speech: "+ meaningsList.get(position).getPartOfSpeech());
       holder.recycler_definition.setHasFixedSize(true);
       holder.recycler_definition.setLayoutManager(new GridLayoutManager(context,1));
       DefinitionAdapter definitionAdapter = new DefinitionAdapter(context,meaningsList.get(position).getDefinitions());
       holder.recycler_definition.setAdapter(definitionAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
