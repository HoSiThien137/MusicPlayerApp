package com.example.musicplayerapp.Class;

import java.util.List;

public class Category {
    private String nameCategory;
    private List<Genre> genres;

    public Category(String nameCategory, List<Genre> genres) {
        this.nameCategory = nameCategory;
        this.genres = genres;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
