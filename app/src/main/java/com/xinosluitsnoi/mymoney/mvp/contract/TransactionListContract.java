package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import java.util.List;

import androidx.annotation.NonNull;

public interface TransactionListContract {

    interface View extends BaseContract.View {

        void showEmptyList();

        void showList(@NonNull List<Transaction> transactions);
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void loadTransactionList(@Category.Type.Mode int type);

        void showEditTransactionScreen(@NonNull Transaction transaction);

        void deleteTransaction(@NonNull Transaction transaction);
    }

    interface Router extends BaseContract.Router {

        void showEditTransactionScreen(@NonNull Transaction transaction);
    }
}