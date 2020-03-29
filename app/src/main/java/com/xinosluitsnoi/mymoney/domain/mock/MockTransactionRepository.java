package com.xinosluitsnoi.mymoney.domain.mock;

import android.graphics.Color;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class MockTransactionRepository implements TransactionRepository {

    private final List<Transaction> transactions;

    public MockTransactionRepository() {
        transactions = new ArrayList<>();

        Category category1 = new Category(1, "Shop", Color.RED, Category.Type.Mode.CONSUME);
        Category category2 = new Category(2, "Work", Color.GREEN, Category.Type.Mode.INCOME);

        Transaction transaction1 = new Transaction(1,
                                                   12.4,
                                                   category1,
                                                   "Котлеты",
                                                   System.currentTimeMillis());

        Transaction transaction2 = new Transaction(2,
                                                   179,
                                                   category2,
                                                   "From my dear company",
                                                   System.currentTimeMillis() - (60 * 60 * 24 * 1000 * 5));

        Transaction transaction3 = new Transaction(3,
                                                   500,
                                                   category1,
                                                   "To)",
                                                   System.currentTimeMillis() - (60 * 60 * 24 * 1000));

        add(transaction1);
        add(transaction2);
        add(transaction3);
    }

    @NonNull
    @Override
    public List<Transaction> getAll(@Category.Type.Mode int type) {

        List<Transaction> result = new ArrayList<>();

        if (type == Category.Type.Mode.ALL) {
            return transactions;
        } else {
            for (Transaction transaction : transactions) {
                if (transaction.getType() == type) {
                    result.add(transaction);
                }
            }
            return result;
        }
    }

    @NonNull
    @Override
    public List<Transaction> getTransactionsByCategory(@NonNull Category category) {
        List<Transaction> result = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getCategory() == category) {
                result.add(transaction);
            }
        }

        return result;
    }

    @Override
    public void add(@NonNull Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void update(@NonNull Transaction transaction) {
        int index = transactions.indexOf(transaction);
        transactions.set(index, transaction);
    }

    @Override
    public void delete(@NonNull Transaction transaction) {
        transactions.remove(transaction);
    }
}