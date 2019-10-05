package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.CategoryContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class CategoryRouter implements CategoryContract.Router {

    @NonNull
    private final BaseActivity activity;

    public CategoryRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showCreateCategoryScreen() {
        // TODO: 17.09.19
    }

    @Override
    public void back() {
        // TODO: 17.09.19
    }
}
