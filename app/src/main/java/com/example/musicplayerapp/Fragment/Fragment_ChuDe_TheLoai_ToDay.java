package com.example.musicplayerapp.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.musicplayerapp.Model.APIService;
import com.example.musicplayerapp.Model.ChuDe;
import com.example.musicplayerapp.Model.DataService;
import com.example.musicplayerapp.Model.TheLoai;
import com.example.musicplayerapp.Model.Theloaitrongngay;
import com.example.musicplayerapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_ToDay extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthemchudetheloai;
    final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
    final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
    final ArrayList<ChuDe> all = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chu_de_the_loai_to_day, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollview);
        txtxemthemchudetheloai = view.findViewById(R.id.textviewxemthem);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<Theloaitrongngay> callback= dataService.GetCategoryMusic();
        callback.enqueue(new Callback<Theloaitrongngay>() {
            @Override
            public void onResponse(Call<Theloaitrongngay> call, Response<Theloaitrongngay> response) {
                Theloaitrongngay theloaitrongngay = response.body();
                Log.d("BBC", theloaitrongngay.getTheLoai().get(0).getTenTheLoai());

                chuDeArrayList.addAll(theloaitrongngay.getChuDe());
                theLoaiArrayList.addAll(theloaitrongngay.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580, 340);
                layout.setMargins(10,20,10,30);
                for(int i = 0 ; i<2; i++){

                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(20);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(chuDeArrayList.get(i).getHinhChuDe() != null){
                        all.add(chuDeArrayList.get(i));
                        Picasso.get().load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for(int j = 0 ; j<2; j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(20);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(theLoaiArrayList.get(j).getHinhTheLoai() != null){
                        all.add(chuDeArrayList.get(j));
                        Picasso.get().load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {

            }
        });

    }
}