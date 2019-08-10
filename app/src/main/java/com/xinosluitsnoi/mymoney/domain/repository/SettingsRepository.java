package com.xinosluitsnoi.mymoney.domain.repository;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.entity.Theme;

import java.util.List;

import androidx.annotation.NonNull;

public interface SettingsRepository {

    @NonNull
    List<Currency> getCurrencyList();

    @NonNull
    Currency getSelectedCurrency();

    void setSelectedCurrency(@NonNull Currency currency);

    void addCurrency(@NonNull Currency currency);

    @NonNull
    List<Theme> getThemeList();

    @NonNull
    Theme getSelectedTheme();

    void setSelectedTheme(@NonNull Theme theme);
}