package com.xinosluitsnoi.mymoney.domain.repository;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import java.util.List;

import androidx.annotation.NonNull;

public interface TransactionRepository {

    @NonNull
    List<Transaction> getAll(@Transaction.Type.Mode int type);

    @NonNull
    List<Transaction> getTransactionsByCategory(@NonNull Category category);

    void add(@NonNull Transaction transaction);

    void update(@NonNull Transaction transaction);

    void delete(@NonNull Transaction transaction);
}
