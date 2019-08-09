package com.xinosluitsnoi.mymoney.mvp.contract;

public interface TransactionContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void showCreateTransactionScreen();
    }

    interface Router extends BaseContract.Router {

        void showCreateTransactionScreen();
    }
}
