package com.xinosluitsnoi.mymoney.domain.mapper;

import com.xinosluitsnoi.mymoney.domain.database.entity.TransactionCursorWrapper;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import androidx.annotation.NonNull;

public class TransactionFromDBMapper implements BaseMapper<Transaction, TransactionCursorWrapper> {

    @NonNull
    @Override
    public Transaction map(@NonNull TransactionCursorWrapper cursorWrapper) {
        return new Transaction(cursorWrapper.getId(),
                               cursorWrapper.getTotal(),
                               cursorWrapper.getType(),
                               new Category(cursorWrapper.getCategoryId()),
                               cursorWrapper.getDate());
    }
}