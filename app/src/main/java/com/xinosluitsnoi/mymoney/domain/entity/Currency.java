package com.xinosluitsnoi.mymoney.domain.entity;

import androidx.annotation.NonNull;

public class Currency {

    private int id;

    @NonNull
    private String title;

    public Currency(int id, @NonNull String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }
}