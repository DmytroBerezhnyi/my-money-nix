package com.xinosluitsnoi.mymoney.domain.repository;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.entity.Theme;

import java.util.List;

import androidx.annotation.NonNull;

public interface SettingsRepository {

    @NonNull
    List<Currency> getCurrencyList();

    int getSelectedCurrency();

    void setSelectedCurrency(int selectedCurrency);

    void addCurrency(@NonNull Currency currency);

    @NonNull
    List<Theme> getThemeList();

    @NonNull
    Theme getSelectedTheme();

    void setSelectedTheme(@NonNull Theme theme);

    @NonNull
    String getThemeTitleById(@NonNull Theme theme);
}