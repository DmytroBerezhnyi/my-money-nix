package com.xinosluitsnoi.mymoney.domain.entity;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Theme {

    // TODO: 09.08.19 will be created later

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