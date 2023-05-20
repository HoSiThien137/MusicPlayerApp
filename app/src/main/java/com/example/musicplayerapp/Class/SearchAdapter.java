package com.example.musicplayerapp.Class;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerapp.Activity.LoginActivity;
import com.example.musicplayerapp.Activity.PlayerActivity;
import com.example.musicplayerapp.Model.APIService;
import com.example.musicplayerapp.Model.BaiHat;
import com.example.musicplayerapp.Model.BaiHatSearch;
import com.example.musicplayerapp.Model.DataService;
import com.example.musicplayerapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{
    Context context;
    ArrayList<BaiHatSearch> mangBaiHat;
    public SearchAdapter (Context context,ArrayList<BaiHatSearch> mbaiHat){
        this.context = context;
        this.mangBaiHat = mbaiHat;
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_songsearch,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        BaiHatSearch baihat = mangBaiHat.get(position);
        holder.tvTenBaiHat.setText(baihat.getTenBaiHat());
        holder.tvTenCaSi.setText(baihat.getCaSi());
        if (baihat.getUsername().equals(LoginActivity.user)){
            holder.imgFavorite.setImageResource(R.drawable.baseline_favorite_red);
        }
        Picasso.get().load(baihat.getHinh()).into(holder.imgBaiHat);
    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView tvTenBaiHat, tvTenCaSi;
        ImageView imgBaiHat, imgFavorite;
        public SearchViewHolder (View view){
            super(view);
            tvTenBaiHat= view.findViewById(R.id.tvTenBaiHat);
            tvTenCaSi = view.findViewById(R.id.tvTenCaSi);
            imgBaiHat = view.findViewById(R.id.imgSongSearch);
            imgFavorite = view.findViewById(R.id.imgFavorite);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayerActivity.class);
                    //intent.putExtra("cakhuc",mangBaiHat.get(getAdapterPosition()));
                    //context.startActivities(intent);
                }
            });
            imgFavorite.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int i= getAdapterPosition();
                    BaiHatSearch baihat= mangBaiHat.get(i);
                    if (baihat.getUsername().equals(LoginActivity.user)){
                        DataService dataService = APIService.getService();
                        Call<Void> callback = dataService.DeleteYeuThich(Integer.parseInt(baihat.getIdBaiHat()) ,LoginActivity.user);
                        callback.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                imgFavorite.setImageResource(R.drawable.baseline_favorite_black);
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });
                    } else{
                        DataService dataService = APIService.getService();
                        Call<Void> callback = dataService.AddYeuThich(Integer.parseInt(baihat.getIdBaiHat()) ,LoginActivity.user);
                        callback.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                imgFavorite.setImageResource(R.drawable.baseline_favorite_red);
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });
                    }


                }
            });
        }
    }
}
