package com.example.mvvmsimple.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("vn")
    @Expose
    private String vn;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("isMemorized")
    @Expose
    private Boolean isMemorized;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Boolean getIsMemorized() {
        return isMemorized;
    }

    public void setIsMemorized(Boolean isMemorized) {
        this.isMemorized = isMemorized;
    }

    public static boolean validate(String en, String vn) {
        return  !en.isEmpty() && !vn.isEmpty();
    }

}