package com.xinosluitsnoi.mymoney.domain.mapper;

import android.content.ContentValues;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor;
import com.xinosluitsnoi.mymoney.domain.entity.Category;

import androidx.annotation.NonNull;

public class CategoryToDBMapper implements BaseMapper<ContentValues, Category> {

    @NonNull
    @Override
    public ContentValues map(@NonNull Category category) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseDescriptor.CategoryEntry.TITLE, category.getTitle());
        contentValues.put(DatabaseDescriptor.CategoryEntry.COLOR, category.getColor());
        contentValues.put(DatabaseDescriptor.CategoryEntry.TYPE, category.getType());

        return contentValues;
    }
}