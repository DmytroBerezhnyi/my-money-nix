package com.xinosluitsnoi.mymoney.domain.mapper;

import android.content.ContentValues;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import androidx.annotation.NonNull;

public class TransactionToDBMapper implements BaseMapper<ContentValues, Transaction> {

    @NonNull
    @Override
    public ContentValues map(@NonNull Transaction transaction) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TransactionEntry.TOTAL, transaction.getTotal());
        contentValues.put(TransactionEntry.TYPE, transaction.getType());
        contentValues.put(TransactionEntry.CATEGORY, transaction.getCategory().getId());
        contentValues.put(TransactionEntry.DATE, transaction.getDate());

        return contentValues;
    }
}