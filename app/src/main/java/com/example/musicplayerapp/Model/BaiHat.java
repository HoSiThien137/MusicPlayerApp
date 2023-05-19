package com.example.musicplayerapp.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHat {

    @SerializedName("IdBaiHat")
    @Expose
    private String idBaiHat;
    @SerializedName("TheLoai")
    @Expose
    private String theLoai;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("CaSi")
    @Expose
    private String caSi;
    @SerializedName("Hinh")
    @Expose
    private String hinh;
    @SerializedName("Link")
    @Expose
    private String link;
    @SerializedName("Username")
    @Expose
    private String username;

    public String getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(String idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}