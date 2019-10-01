package com.xinosluitsnoi.mymoney.domain.entity;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Theme {

    @Type.Mode
    private int theme;

    private String title;

    public Theme(int theme, String title) {
        this.theme = theme;
        this.title = title;
    }

    public Theme(@Type.Mode int theme) {
        this.theme = theme;
    }

    @Type.Mode
    public int getTheme() {
        return theme;
    }

    public void setTheme(@Type.Mode int theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
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