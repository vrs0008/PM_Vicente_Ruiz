package com.example.practica_5_listas_optimizadas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorGames extends RecyclerView.Adapter<AdaptadorGames.GamesViewHolder> {

    private final Games[] listaGames;

    public AdaptadorGames(Games[] listaGames) {
        this.listaGames = listaGames;
    }

    @NonNull
    @Override
    public GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_items, parent, false);
        return new GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        holder.bindGame(this.listaGames[position]);
    }

    @Override
    public int getItemCount() {
        return listaGames.length;
    }

    public static class GamesViewHolder extends RecyclerView.ViewHolder {
        public TextView tituloView;
        public ImageView portadaView;
        public TextView detailsView;
        private final Context context;

        public GamesViewHolder(View view) {
            super(view);
            this.context = view.getContext();
            tituloView = view.findViewById(R.id.tvGameTitle);
            portadaView = view.findViewById(R.id.ivGameImage);
            detailsView = view.findViewById(R.id.tvGameDetails);
        }

        public void bindGame(Games game) {
            tituloView.setText(game.getTitle());
            String details = game.getGenero() + " | +" + game.getEdad();
            detailsView.setText(details);

            int imageId = context.getResources().getIdentifier(game.getImage(), "drawable", context.getPackageName());
            if (imageId != 0) {
                portadaView.setImageResource(imageId);
            }
        }
    }
}
