package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.mvp.contract.MainContract;

import androidx.annotation.NonNull;

public class MainPresenter extends BasePresenter<MainContract.View, MainContract.Router>
        implements MainContract.Presenter {

    public MainPresenter(@NonNull MainContract.Router router) {
        super(router);
    }

    @Override
    public void showTransactionsScreen() {
        getRouter().showTransactionsScreen();
    }

    @Override
    public void showCategoriesScreen() {
        getRouter().showCategoriesScreen();
    }

    @Override
    public void showSettingsScreen() {
        getRouter().showSettingsScreen();
    }
}