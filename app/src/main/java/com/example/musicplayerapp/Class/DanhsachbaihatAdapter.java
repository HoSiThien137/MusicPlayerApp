package com.example.musicplayerapp.Class;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerapp.Activity.LoginActivity;
import com.example.musicplayerapp.Activity.PlayerActivity;
import com.example.musicplayerapp.Model.APIService;
import com.example.musicplayerapp.Model.BaiHat;
import com.example.musicplayerapp.Model.DataService;
import com.example.musicplayerapp.R;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat> mangbaihat;
    public DanhsachbaihatAdapter(Context context, ArrayList<BaiHat> mangbaihat){
        this.context = context;
        this.mangbaihat = mangbaihat;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = mangbaihat.get(position);
        holder.txtcasi.setText(baiHat.getCaSi());
        holder.txttenbaihat.setText(baiHat.getTenBaiHat());
        holder.txtindex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView txtindex, txttenbaihat, txtcasi;
        ImageView imgluotthich;
        public ViewHolder(View itemView){
            super(itemView);
            txtcasi = itemView.findViewById(R.id.textviewcasi);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat  = itemView.findViewById(R.id.textviewtenbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.baseline_favorite_red);
                    DataService dataService = APIService.getService();
                    //Call<String> callback = dataService.UpdateLuotThich();
                    Call<String> callback;
//                    callback.enqueue(new Callback<String>() {
//                        @Override
//                        public void onResponse(Call<String> call, Response<String> response) {
//                            String ketqua = response.body();
//                            if(ketqua.equals("Success")){
//                                Toast.makeText(context, "Đã thích", Toast.LENGTH_SHORT).show();
//                            }else Toast.makeText(context, "Lỗi", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call<String> call, Throwable t) {
//
//                        }
//                    });
                    imgluotthich.setEnabled(false);
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, PlayerActivity.class);
                            intent.putExtra("cakhuc", (Serializable) mangbaihat.get(getPosition()));
                            context.startActivity(intent);
                        }
                    });
                }
            });
        }
    }
//    private void evenClisk(){
//        FloatingActionButton floatingActionButton.setEnable(true);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    Intent intent = new Intent(DanhsachbaihatActivity.this, PlayerActivity.class);
//                    intent.putExtra("cacbaihat", mangbaihat);
//                    startActivity(intent);
//            }
//        });
//
//    }
}
