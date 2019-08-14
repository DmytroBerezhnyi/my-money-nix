package com.xinosluitsnoi.mymoney.domain.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.CategoryEntry;

import com.xinosluitsnoi.mymoney.domain.database.entity.CategoryCursorWrapper;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.mapper.CategoryFromDBMapper;
import com.xinosluitsnoi.mymoney.domain.mapper.CategoryToDBMapper;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBCategoryRepository implements CategoryRepository {

    @NonNull
    private final SQLiteDatabase database;

    @NonNull
    private final CategoryToDBMapper categoryToDBMapper;

    @NonNull
    private final CategoryFromDBMapper categoryFromDBMapper;

    public DBCategoryRepository(@NonNull DBHelper dbHelper) {
        database = dbHelper.getReadableDatabase();
        categoryToDBMapper = new CategoryToDBMapper();
        categoryFromDBMapper = new CategoryFromDBMapper();
    }

    @Nullable
    @Override
    public Category getCategory(long id) {
        Category category = null;
        String query = "SELECT * FROM " + CategoryEntry.TABLE_NAME +
                " WHERE " + CategoryEntry._ID + " = " + id;

        try (Cursor cursor = database.rawQuery(query, null);
             CategoryCursorWrapper cursorWrapper = new CategoryCursorWrapper(cursor)) {
            if (cursorWrapper.moveToFirst()) {
                category = categoryFromDBMapper.map(cursorWrapper);
            }
        }
        return category;
    }

    @NonNull
    @Override
    public List<Category> getAll(@Category.Type.Mode int type) {
        List<Category> categories = new ArrayList<>();
        Category category;
        String query = "SELECT * FROM " + CategoryEntry.TABLE_NAME +
                " WHERE " + CategoryEntry.TYPE + " = " + type;

        try (Cursor cursor = database.rawQuery(query, null);
             CategoryCursorWrapper cursorWrapper = new CategoryCursorWrapper(cursor)) {
            if (cursorWrapper.moveToFirst()) {
                do {
                    category = categoryFromDBMapper.map(cursorWrapper);
                    categories.add(category);
                } while (cursorWrapper.moveToNext());
            }
        }
        return categories;
    }

    @Override
    public void add(@NonNull Category category) {
        ContentValues values = categoryToDBMapper.map(category);

        long id = database.insert(CategoryEntry.TABLE_NAME, null, values);
        category.setId(id);
    }

    @Override
    public void update(@NonNull Category category) {
        ContentValues values = categoryToDBMapper.map(category);
        database.update(CategoryEntry.TABLE_NAME,
                        values,
                        CategoryEntry._ID + " = " + category.getId(),
                        null);
    }

    @Override
    public void delete(@NonNull Category category) {
        String query = "DELETE FROM " + CategoryEntry.TABLE_NAME + " WHERE " +
                CategoryEntry._ID + " = " + category.getId() + ";";

        database.execSQL(query);
    }
}
