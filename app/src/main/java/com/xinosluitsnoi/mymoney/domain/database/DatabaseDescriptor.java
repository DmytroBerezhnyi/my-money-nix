package com.xinosluitsnoi.mymoney.domain.database;

import android.provider.BaseColumns;

public final class DatabaseDescriptor {

    private DatabaseDescriptor() {

    }

    public static final class TransactionEntry implements BaseColumns {

        public static final String TABLE_NAME = "transaction";

        public static final String TOTAL = "total";

        public static final String TITLE = "title";

        public static final String CATEGORY = "category_id";

        public static final String DATE = "date";

        public static final String TYPE = "type";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        TITLE + " TEXT NOT NULL," +
                        TOTAL + " REAL NOT NULL," +
                        "FOREIGN KEY(" + CATEGORY + ") REFERENCES " +
                        CategoryEntry.TABLE_NAME + "(" + _ID + ")," +
                        DATE + " INTEGER(8) NOT NULL," +
                        TYPE + " INTEGER(1) NOT NULL);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class CategoryEntry implements BaseColumns {

        public static final String TABLE_NAME = "category";

        public static final String TITLE = "title";

        public static final String COLOR = "color";

        public static final String TYPE = "type";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        TITLE + " TEXT NOT NULL," +
                        COLOR + " REAL NOT NULL," +
                        TYPE + " INTEGER(1) NOT NULL);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}