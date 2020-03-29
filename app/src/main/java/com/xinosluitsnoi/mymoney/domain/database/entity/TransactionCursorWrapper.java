package com.xinosluitsnoi.mymoney.domain.database.entity;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import androidx.annotation.NonNull;

public class TransactionCursorWrapper extends CursorWrapper {

    private final int id;

    private final int total;

    private final int category;

    private final int title;

    private final int date;

    public TransactionCursorWrapper(Cursor cursor) {
        super(cursor);

        id = getColumnIndex(TransactionEntry._ID);
        total = getColumnIndex(TransactionEntry.TOTAL);
        category = getColumnIndex(TransactionEntry.CATEGORY);
        title = getColumnIndex(TransactionEntry.TITLE);
        date = getColumnIndex(TransactionEntry.DATE);
    }

    public long getId() {
        return getLong(id);
    }

    public double getTotal() {
        return getDouble(total);
    }

    public int getCategoryId() {
        return getInt(category);
    }

    @NonNull
    public String getTitle() {
        return getString(title);
    }

    public long getDate() {
        return getLong(date);
    }
}