package com.example.musicplayerapp.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("BaiHat.php")
    Call<List<BaiHat>> GetDataSong();

    @GET("playlist.php")
    Call<List<PlayList>> GetPlayListCurrentDay();

    @GET("TheLoaiChuDe.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("album.php")
    Call<List<Album>> GetAlbumHot();

    @FormUrlEncoded
    @POST("BaiHat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoplaylist(@Field("IdPlayList") String IdPlayList);
    @FormUrlEncoded
    @POST("search.php")
    Call<List<BaiHatSearch>> GetSearchBaiHat (@Field("tukhoa") String tukhoa, @Field("user") String user);

    @FormUrlEncoded
    @POST("deleteYeuThich.php")
    Call<Void> DeleteYeuThich (@Field("IdBaiHat") int IdBaiHat, @Field("Username") String Username);
    @FormUrlEncoded
    @POST("addYeuThich.php")
    Call<Void> AddYeuThich (@Field("IdBaiHat") int IdBaiHat, @Field("Username") String Username);
}
