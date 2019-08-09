package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import java.util.List;

import androidx.annotation.NonNull;

public interface TransactionCreateContract {

    interface View extends BaseContract.View {

        void showCategoryList(@NonNull List<Category> categories);

        void showInvalidTotal();

        void showInvalidDescription();

        void showInvalidCategorySelection();
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void saveTransaction(@NonNull Transaction transaction);

        void loadCategoryList(@Category.Type.Mode int type);
    }

    interface Router extends BaseContract.Router {

    }
}