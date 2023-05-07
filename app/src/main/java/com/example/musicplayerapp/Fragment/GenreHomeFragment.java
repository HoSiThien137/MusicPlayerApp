package com.example.musicplayerapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.musicplayerapp.Class.Category;
import com.example.musicplayerapp.Class.CategoryAdapter;
import com.example.musicplayerapp.Class.Genre;
import com.example.musicplayerapp.R;

import java.util.ArrayList;
import java.util.List;


public class GenreHomeFragment extends Fragment {
    private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_genre_home, container, false);
        rvCategory = rootView.findViewById(R.id.rvGenre_Category);
        categoryAdapter = new CategoryAdapter(this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getCategoryList());
        rvCategory.setAdapter(categoryAdapter);
        return rootView;
    }
    private List<Category> getCategoryList(){
        List<Category> ListCategory = new ArrayList<>();
        List<Genre> list1 = new ArrayList<>();
        List<Genre> list2 = new ArrayList<>();
        list1.add((new Genre(R.drawable.image1,"POP")));
        list1.add((new Genre(R.drawable.image3,"INDIE")));
        list1.add((new Genre(R.drawable.image2,"JAZZ")));
        list1.add((new Genre(R.drawable.image4,"RAP")));
        list2.add((new Genre(R.drawable.image1,"Album1")));
        list2.add((new Genre(R.drawable.image3,"Album2")));
        list2.add((new Genre(R.drawable.image2,"Album3")));
        list2.add((new Genre(R.drawable.image4,"Album4")));
        ListCategory.add(new Category("Chủ đề và thể loại", list1));
        ListCategory.add(new Category("Album", list2));
        return ListCategory;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}