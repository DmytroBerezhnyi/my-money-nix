package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Category;

import androidx.annotation.NonNull;

public interface CategoryCreateContract {

    interface View extends BaseContract.View {

        void showInvalidTitle();

        void showInvalidType();

        void showInvalidColor();
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void saveCategory(@NonNull Category category);
    }

    interface Router extends BaseContract.Router {

    }
}