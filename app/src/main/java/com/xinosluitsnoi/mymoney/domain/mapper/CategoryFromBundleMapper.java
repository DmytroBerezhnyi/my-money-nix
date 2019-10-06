package com.xinosluitsnoi.mymoney.domain.mapper;

import android.os.Bundle;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.CategoryEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Category;

import java.util.Objects;

import androidx.annotation.NonNull;

public class CategoryFromBundleMapper implements BaseMapper<Category, Bundle> {

    @NonNull
    @Override
    public Category map(@NonNull Bundle bundle) {
        return new Category(bundle.getLong(CategoryEntry._ID),
                            Objects.requireNonNull(bundle.getString(CategoryEntry.TITLE)),
                            bundle.getInt(CategoryEntry.COLOR),
                            bundle.getInt(CategoryEntry.TYPE));
    }
}