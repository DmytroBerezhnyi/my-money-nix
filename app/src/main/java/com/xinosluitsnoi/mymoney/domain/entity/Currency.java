package com.xinosluitsnoi.mymoney.domain.entity;

import androidx.annotation.NonNull;

public class Currency {

    @NonNull
    private String title;

    public Currency(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }
}