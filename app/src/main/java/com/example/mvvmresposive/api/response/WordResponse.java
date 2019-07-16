package com.example.mvvmresposive.api.response;

import java.util.List;

import com.example.mvvmresposive.model.Word;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WordResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("words")
    @Expose
    private List<Word> words = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

}