package com.xinosluitsnoi.mymoney.domain.entity;

import androidx.annotation.NonNull;

public class Transaction {

    private long id;

    private double total;

    private Category category;

    private String title;

    private long date;

    public Transaction(long id) {
        this.id = id;
    }

    public Transaction(double total,
                       @NonNull Category category,
                       @NonNull String title,
                       long date) {
        this.total = total;
        this.category = category;
        this.title = title;
        this.date = date;
    }

    public Transaction(long id,
                       double total,
                       @NonNull Category category,
                       @NonNull String title,
                       long date) {
        this.id = id;
        this.total = total;
        this.category = category;
        this.title = title;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Category.Type.Mode
    public int getType() {
        return category.getType();
    }

    public void setType(@Category.Type.Mode int type) {
        category.setType(type);
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    public void setCategory(@NonNull Category category) {
        this.category = category;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}