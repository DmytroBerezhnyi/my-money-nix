package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.TransactionCreateContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class TransactionCreateRouter implements TransactionCreateContract.Router {

    @NonNull
    private final BaseActivity activity;

    public TransactionCreateRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void back() {
        activity.onBackPressed();
    }
}