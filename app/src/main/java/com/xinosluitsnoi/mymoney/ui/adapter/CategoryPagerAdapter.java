package com.xinosluitsnoi.mymoney.ui.adapter;

import android.content.Context;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.ui.fragment.BasePagerFragment;
import com.xinosluitsnoi.mymoney.ui.fragment.CategoryListFragment;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

public class CategoryPagerAdapter extends BasePagerAdapter {

    public CategoryPagerAdapter(@NonNull Context context,
                                @NonNull FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    @NonNull
    @Override
    protected List<BasePagerFragment> getFragmentList() {
        return Arrays.asList(CategoryListFragment.newInstance(Category.Type.Mode.ALL),
                             CategoryListFragment.newInstance(Category.Type.Mode.INCOME),
                             CategoryListFragment.newInstance(Category.Type.Mode.CONSUME));
    }
}