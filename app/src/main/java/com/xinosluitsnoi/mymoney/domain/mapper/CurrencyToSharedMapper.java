package com.xinosluitsnoi.mymoney.domain.mapper;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;

import java.util.List;

import androidx.annotation.NonNull;

public class CurrencyToSharedMapper implements BaseMapper<String, List<Currency>> {

    @NonNull
    @Override
    public String map(@NonNull List<Currency> currencies) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < currencies.size(); i++) {
            stringBuilder.append(currencies.get(i).getTitle());

            if (i < currencies.size() - 1) {
                stringBuilder.append(',');
            }
        }

        return stringBuilder.toString();
    }
}