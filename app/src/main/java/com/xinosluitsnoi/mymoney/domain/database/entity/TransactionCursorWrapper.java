package com.xinosluitsnoi.mymoney.domain.database.entity;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

public class TransactionCursorWrapper extends CursorWrapper {

    private final int id;

    private final int total;

    private final int type;

    private final int category;

    private final int date;

    public TransactionCursorWrapper(Cursor cursor) {
        super(cursor);

        id = getColumnIndex(TransactionEntry._ID);
        total = getColumnIndex(TransactionEntry.TOTAL);
        type = getColumnIndex(TransactionEntry.TYPE);
        category = getColumnIndex(TransactionEntry.CATEGORY);
        date = getColumnIndex(TransactionEntry.DATE);
    }

    public long getId() {
        return getLong(id);
    }

    public double getTotal() {
        return getDouble(total);
    }

    @Transaction.Type.Mode
    public int getType() {
        return getInt(type);
    }

    public int getCategoryId() {
        return getInt(category);
    }

    public long getDate() {
        return getLong(date);
    }
}