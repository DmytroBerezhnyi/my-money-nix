package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.TransactionContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class TransactionRouter implements TransactionContract.Router {

    @NonNull
    private final BaseActivity activity;

    public TransactionRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showCreateTransactionScreen() {
        // TODO: 17.09.19
    }

    @Override
    public void back() {
        // TODO: 17.09.19
    }
}