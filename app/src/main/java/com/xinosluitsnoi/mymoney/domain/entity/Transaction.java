package com.xinosluitsnoi.mymoney.domain.entity;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Transaction {

    private int id;

    private double total;

    @Type.Mode
    private int type;

    private Category category;

    private String description;

    public Transaction(int id) {
        this.id = id;
    }

    public Transaction(double total,
                       @Type.Mode int type,
                       @NonNull Category category,
                       @NonNull String description) {
        this.total = total;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    public Transaction(int id,
                       double total,
                       @Type.Mode int type,
                       @NonNull Category category,
                       @NonNull String description) {
        this.id = id;
        this.total = total;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Type.Mode
    public int getType() {
        return type;
    }

    public void setType(@Type.Mode int type) {
        this.type = type;
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    public void setCategory(@NonNull Category category) {
        this.category = category;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public static class Type {

        @Retention(SOURCE)
        @IntDef({
                        Mode.INCOME,
                        Mode.CONSUME,
                })
        public @interface Mode {

            int INCOME = 0;

            int CONSUME = 1;
        }
    }
}