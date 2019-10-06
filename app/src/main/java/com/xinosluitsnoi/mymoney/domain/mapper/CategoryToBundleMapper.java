package com.xinosluitsnoi.mymoney.domain.mapper;

import android.os.Bundle;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.CategoryEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Category;

import androidx.annotation.NonNull;

public class CategoryToBundleMapper implements BaseMapper<Bundle, Category> {

    @NonNull
    @Override
    public Bundle map(@NonNull Category category) {
        Bundle bundle = new Bundle();

        bundle.putLong(CategoryEntry._ID, category.getId());
        bundle.putString(CategoryEntry.TITLE, category.getTitle());
        bundle.putInt(CategoryEntry.COLOR, category.getColor());
        bundle.putInt(CategoryEntry.TYPE, category.getType());

        return bundle;
    }
}