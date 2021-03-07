package com.example.b_am_piougaetan_listepatisseries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rec_adapter extends RecyclerView.Adapter<rec_adapter.ViewHolder> {
    private ArrayList<com.example.b_am_piougaetan_listepatisseries.Patisserie> listePatisseries;

    //Le viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Y declarer les objets de la vue qui seront chargés (par le tableau de données)
        public TextView mTextView;
        public TextView description;
        public ImageView image;
        //Constructeur du holder : le viewHolder a une reference vers tous les objets de la liste
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textview_List_Title);
            description = (TextView) v.findViewById(R.id.textview_List_Description);
            image = (ImageView) v.findViewById(R.id.img_List);
        }
    }

    public void filterList(ArrayList<com.example.b_am_piougaetan_listepatisseries.Patisserie> filteredList) {
        listePatisseries = filteredList;
        notifyDataSetChanged();
    }

    //Constructeur de l'adaptateur : initialisations de l’adapter et des données
    public rec_adapter(ArrayList<com.example.b_am_piougaetan_listepatisseries.Patisserie> patisserieList) {
        this.listePatisseries = patisserieList;
    }

    //Chargement du layout et initialisation du viewHolder
    @Override
    public rec_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.canvas_patisseries, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Lien entre viewHolder et donnees
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final com.example.b_am_piougaetan_listepatisseries.Patisserie planetes = listePatisseries.get(position);
        holder.mTextView.setText(planetes.getPatisserieName());
        holder.description.setText(planetes.getPatisserieDescription());
        holder.image.setImageResource(planetes.getPatisserieId());
    }

    //Nombre d’elements de la liste de patisseries
    @Override
    public int getItemCount() {
        return listePatisseries.size();
    }
}