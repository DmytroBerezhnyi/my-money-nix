package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.mvp.contract.TransactionContract;

import androidx.annotation.NonNull;

public class TransactionPresenter
        extends BasePresenter<TransactionContract.View, TransactionContract.Router>
        implements TransactionContract.Presenter {

    public TransactionPresenter(@NonNull TransactionContract.Router router) {
        super(router);
    }

    @Override
    public void showCreateTransactionScreen() {
        getRouter().showCreateTransactionScreen();
    }
}