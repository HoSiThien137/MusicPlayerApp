package com.example.musicplayerapp.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerapp.Fragment.GenreHomeFragment;
import com.example.musicplayerapp.R;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder>{

    private GenreHomeFragment context;
    private List<Genre> listGenre;
    public GenreAdapter(GenreHomeFragment context){
        this.context=context;
    }
    public void setData(List<Genre> list){
        this.listGenre = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listgenre,parent,false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        Genre genre = listGenre.get(position);
        if (genre==null)
            return;
        holder.imgGenre.setImageResource(genre.getResourceID());
        holder.tvTitle.setText(genre.getTitle());
    }

    @Override
    public int getItemCount() {
        if (listGenre != null)
            return listGenre.size();
        return 0;
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgGenre;
        private TextView tvTitle;
        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGenre = itemView.findViewById(R.id.imgGenre);
            tvTitle = itemView.findViewById(R.id.tvGenre);
        }
    }
}
