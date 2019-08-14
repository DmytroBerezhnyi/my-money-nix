package com.xinosluitsnoi.mymoney.domain.mapper;

import com.xinosluitsnoi.mymoney.domain.database.entity.CategoryCursorWrapper;
import com.xinosluitsnoi.mymoney.domain.entity.Category;

import androidx.annotation.NonNull;

public class CategoryFromDBMapper implements BaseMapper<Category, CategoryCursorWrapper> {

    @NonNull
    @Override
    public Category map(@NonNull CategoryCursorWrapper cursorWrapper) {
        return new Category(cursorWrapper.getId(),
                            cursorWrapper.getTitle(),
                            cursorWrapper.getColor(),
                            cursorWrapper.getType());
    }
}