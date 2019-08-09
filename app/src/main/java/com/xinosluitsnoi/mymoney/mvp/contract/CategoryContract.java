package com.xinosluitsnoi.mymoney.mvp.contract;

public interface CategoryContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void showCreateCategoryScreen();
    }

    interface Router extends BaseContract.Router {

        void showCreateCategoryScreen();
    }
}