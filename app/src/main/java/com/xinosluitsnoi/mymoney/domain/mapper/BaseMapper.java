package com.xinosluitsnoi.mymoney.domain.mapper;

import androidx.annotation.NonNull;

public interface BaseMapper<T, E> {

    @NonNull
    T map(@NonNull E e);
}