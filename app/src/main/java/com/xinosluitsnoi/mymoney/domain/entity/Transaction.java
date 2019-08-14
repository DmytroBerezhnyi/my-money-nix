package com.xinosluitsnoi.mymoney.domain.entity;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Transaction {

    private long id;

    private double total;

    @Type.Mode
    private int type;

    private Category category;

    private long date;

    public Transaction(long id) {
        this.id = id;
    }

    public Transaction(double total,
                       @Type.Mode int type,
                       @NonNull Category category,
                       long date) {
        this.total = total;
        this.type = type;
        this.category = category;
        this.date = date;
    }

    public Transaction(long id,
                       double total,
                       @Type.Mode int type,
                       @NonNull Category category,
                       long date) {
        this.id = id;
        this.total = total;
        this.type = type;
        this.category = category;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
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