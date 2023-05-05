package com.example.musicplayerapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.musicplayerapp.Class.Genre;
import com.example.musicplayerapp.Class.GenreAdapter;
import com.example.musicplayerapp.R;

import java.util.ArrayList;
import java.util.List;


public class GenreHomeFragment extends Fragment {
    private RecyclerView rvGenre;
    private GenreAdapter genreAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_genre_home, container, false);
        rvGenre = rootView.findViewById(R.id.rvGenre);
        genreAdapter = new GenreAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rvGenre.setLayoutManager(linearLayoutManager);
        genreAdapter.setData(getListGenre());
        rvGenre.setAdapter(genreAdapter);
        return rootView;
    }
    private List<Genre> getListGenre(){
        List<Genre> list = new ArrayList<>();
        list.add((new Genre(R.drawable.image1,"POP")));
        list.add((new Genre(R.drawable.image3,"INDIE")));
        list.add((new Genre(R.drawable.image2,"JAZZ")));
        list.add((new Genre(R.drawable.image4,"RAP")));
        return list;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}