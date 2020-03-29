package com.xinosluitsnoi.mymoney.ui.router;

import android.content.Intent;
import android.os.Bundle;

import com.xinosluitsnoi.mymoney.domain.entity.Transaction;
import com.xinosluitsnoi.mymoney.domain.mapper.TransactionToBundleMapper;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionListContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.activity.TransactionCreateActivity;

import androidx.annotation.NonNull;

public class TransactionListRouter implements TransactionListContract.Router {

    @NonNull
    private final BaseActivity activity;

    @NonNull
    private final TransactionToBundleMapper transactionToBundleMapper;

    public TransactionListRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
        transactionToBundleMapper = new TransactionToBundleMapper();
    }

    @Override
    public void showEditTransactionScreen(@NonNull Transaction transaction) {
        Intent intent = new Intent(activity, TransactionCreateActivity.class);
        Bundle bundle = transactionToBundleMapper.map(transaction);
        intent.putExtras(bundle);

        activity.startActivity(intent);
    }

    @Override
    public void back() {
        activity.onBackPressed();
    }
}