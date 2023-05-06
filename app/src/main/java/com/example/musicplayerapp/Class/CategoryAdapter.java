package com.example.musicplayerapp.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerapp.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private Context context;
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public CategoryAdapter(Context context){
       this.context=context;
   }

   public void setData(List<Category> list){
       this.categoryList=list;
       notifyDataSetChanged();
   }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
       return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category=categoryList.get(position);
        if (category==null)
            return;;
        holder.txtNameCategory.setText(category.getNameCategory());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.rcvGenre.setLayoutManager(linearLayoutManager);
        GenreAdapter genreAdapter = new GenreAdapter();
        genreAdapter.setData(category.getGenres());
        holder.rcvGenre.setAdapter(genreAdapter);
    }

    @Override
    public int getItemCount() {
       if (categoryList!=null)
           return  categoryList.size();
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNameCategory;
        private RecyclerView rcvGenre;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameCategory = itemView.findViewById(R.id.txt_category_name);
            rcvGenre = itemView.findViewById(R.id.rcv_Category);
        }
    }
}
