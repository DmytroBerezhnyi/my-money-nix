package com.xinosluitsnoi.mymoney.mvp.contract;

public interface MainActivityContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void showTransactionsScreen();

        void showCategoriesScreen();

        void showSettingsScreen();
    }

    interface Router extends BaseContract.Router {

        void showTransactionsScreen();

        void showCategoriesScreen();

        void showSettingsScreen();
    }
}