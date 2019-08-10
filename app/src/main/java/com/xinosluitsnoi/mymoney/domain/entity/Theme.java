package com.xinosluitsnoi.mymoney.domain.entity;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Theme {

    private int id;

    @Type.Mode
    private int theme;

    public Theme(int id, int theme) {
        this.id = id;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Type.Mode
    public int getTheme() {
        return theme;
    }

    public void setTheme(@Type.Mode int theme) {
        this.theme = theme;
    }

    public static class Type {

        @Retention(SOURCE)
        @IntDef({
                        Mode.SYSTEM,
                        Mode.DAY,
                        Mode.NIGHT,
                })
        public @interface Mode {

            int SYSTEM = 0;

            int DAY = 1;

            int NIGHT = 2;
        }
    }
}