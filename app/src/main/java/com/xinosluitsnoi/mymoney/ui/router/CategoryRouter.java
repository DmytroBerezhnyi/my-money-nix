package com.xinosluitsnoi.mymoney.ui.router;

import android.content.Intent;

import com.xinosluitsnoi.mymoney.mvp.contract.CategoryContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.activity.CategoryCreateActivity;

import androidx.annotation.NonNull;

public class CategoryRouter implements CategoryContract.Router {

    @NonNull
    private final BaseActivity activity;

    public CategoryRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showCreateCategoryScreen() {
        Intent intent = new Intent(activity, CategoryCreateActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void back() {
        activity.onBackPressed();
    }
}
