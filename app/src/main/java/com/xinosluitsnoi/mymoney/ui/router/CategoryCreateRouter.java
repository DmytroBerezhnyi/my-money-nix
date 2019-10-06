package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.CategoryCreateContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class CategoryCreateRouter implements CategoryCreateContract.Router {

    @NonNull
    private final BaseActivity activity;

    public CategoryCreateRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void back() {
        activity.onBackPressed();
    }
}