package com.xinosluitsnoi.mymoney.domain.repository;

import com.xinosluitsnoi.mymoney.domain.entity.Category;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface CategoryRepository {

    @Nullable
    Category getCategory(long id);

    @NonNull
    List<Category> getAll(@Category.Type.Mode int type);

    void add(@NonNull Category category);

    void update(@NonNull Category category);

    void delete(@NonNull Category category);
}