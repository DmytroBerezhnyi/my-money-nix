package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.mvp.contract.CategoryContract;

import androidx.annotation.NonNull;

public class CategoryPresenter
        extends BasePresenter<CategoryContract.View, CategoryContract.Router>
        implements CategoryContract.Presenter {

    public CategoryPresenter(@NonNull CategoryContract.Router router) {
        super(router);
    }

    @Override
    public void showCreateCategoryScreen() {
        getRouter().showCreateCategoryScreen();
    }
}