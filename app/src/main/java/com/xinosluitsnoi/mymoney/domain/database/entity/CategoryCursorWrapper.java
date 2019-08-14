package com.xinosluitsnoi.mymoney.domain.database.entity;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.CategoryEntry;
import com.xinosluitsnoi.mymoney.domain.entity.Category;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class CategoryCursorWrapper extends CursorWrapper {

    private final int id;

    private final int title;

    private final int color;

    private final int type;

    public CategoryCursorWrapper(@NonNull Cursor cursor) {
        super(cursor);

        id = getColumnIndex(CategoryEntry._ID);
        title = getColumnIndex(CategoryEntry.TITLE);
        color = getColumnIndex(CategoryEntry.COLOR);
        type = getColumnIndex(CategoryEntry.TYPE);
    }

    public long getId() {
        return getLong(id);
    }

    @NonNull
    public String getTitle() {
        return getString(title);
    }

    @ColorInt
    public int getColor() {
        return getInt(color);
    }

    @Category.Type.Mode
    public int getType() {
        return getInt(type);
    }
}