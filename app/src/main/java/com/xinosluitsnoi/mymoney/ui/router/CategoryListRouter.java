package com.xinosluitsnoi.mymoney.ui.router;

import android.content.Intent;
import android.os.Bundle;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.mapper.CategoryToBundleMapper;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryListContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.activity.CategoryCreateActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class CategoryListRouter implements CategoryListContract.Router {

    @NonNull
    private final BaseActivity activity;

    @NonNull
    private final CategoryToBundleMapper categoryToBundleMapper;

    public CategoryListRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
        categoryToBundleMapper = new CategoryToBundleMapper();
    }

    @Override
    public void showEditCategoryScreen(@NonNull Category category) {
        Intent intent = new Intent(activity, CategoryCreateActivity.class);
        Bundle bundle = categoryToBundleMapper.map(category);
        intent.putExtras(bundle);

        activity.startActivity(intent);
    }

    @Override
    public void back() {
        activity.onBackPressed();
    }
}