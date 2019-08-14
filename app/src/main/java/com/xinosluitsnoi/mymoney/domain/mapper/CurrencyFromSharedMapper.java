package com.xinosluitsnoi.mymoney.domain.mapper;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class CurrencyFromSharedMapper implements BaseMapper<List<Currency>, String> {

    @NonNull
    @Override
    public List<Currency> map(@NonNull String string) {
        List<Currency> currencies = new ArrayList<>();
        String[] currencyArray = string.split(",");

        for (String s : currencyArray) {
            currencies.add(new Currency(s));
        }

        return currencies;
    }
}