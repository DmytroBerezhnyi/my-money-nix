package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Category;

import java.util.List;

import androidx.annotation.NonNull;

public interface CategoryListContract {

    interface View extends BaseContract.View {

        void showEmptyList();

        void showList(@NonNull List<Category> categories);
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void loadCategoryList(@Category.Type.Mode int type);

        void showEditCategoryScreen(@NonNull Category category);
    }

    interface Router extends BaseContract.Router {

        void showEditCategoryScreen(@NonNull Category category);
    }
}