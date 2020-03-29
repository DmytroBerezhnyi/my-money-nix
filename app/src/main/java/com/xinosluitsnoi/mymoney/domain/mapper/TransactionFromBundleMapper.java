package com.xinosluitsnoi.mymoney.domain.mapper;

import android.os.Bundle;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import java.util.Objects;

import androidx.annotation.NonNull;

public class TransactionFromBundleMapper implements BaseMapper<Transaction, Bundle> {

    @NonNull
    @Override
    public Transaction map(@NonNull Bundle bundle) {
        CategoryFromBundleMapper categoryFromBundleMapper = new CategoryFromBundleMapper();
        Category category = categoryFromBundleMapper.map(Objects.requireNonNull(bundle.getBundle(
                TransactionEntry.CATEGORY)));

        return new Transaction(bundle.getLong(TransactionEntry._ID),
                               bundle.getDouble(TransactionEntry.TOTAL),
                               category,
                               Objects.requireNonNull(bundle.getString(TransactionEntry.TITLE)),
                               bundle.getLong(TransactionEntry.DATE));
    }
}