package com.xinosluitsnoi.mymoney.domain.entity;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Category {

    // TODO: 09.08.19 will be created later

    public static class Type {

        @Retention(SOURCE)
        @IntDef({
                        Mode.ALL,
                        Mode.INCOME,
                        Mode.CONSUME,
                })
        public @interface Mode {

            int ALL = 0;

            int INCOME = 1;

            int CONSUME = 2;
        }
    }
}