package com.xinosluitsnoi.mymoney.domain.mapper;

import android.os.Bundle;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import androidx.annotation.NonNull;

public class TransactionToBundleMapper implements BaseMapper<Bundle, Transaction> {

    @NonNull
    @Override
    public Bundle map(@NonNull Transaction transaction) {
        CategoryToBundleMapper categoryToBundleMapper = new CategoryToBundleMapper();
        Bundle bundle = new Bundle();

        bundle.putLong(TransactionEntry._ID, transaction.getId());
        bundle.putDouble(TransactionEntry.TOTAL, transaction.getTotal());

        Bundle category = categoryToBundleMapper.map(transaction.getCategory());
        bundle.putBundle(TransactionEntry.CATEGORY, category);

        bundle.putString(TransactionEntry.TITLE, transaction.getTitle());
        bundle.putLong(TransactionEntry.DATE, transaction.getDate());

        return bundle;
    }
}