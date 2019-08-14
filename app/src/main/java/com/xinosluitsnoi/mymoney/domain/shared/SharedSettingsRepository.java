package com.xinosluitsnoi.mymoney.domain.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.entity.Theme;
import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;

import java.util.List;

import androidx.annotation.NonNull;

public class SharedSettingsRepository implements SettingsRepository {

    private final SharedPreferences preferences;

    private final SharedCurrencyWrapper sharedCurrencyWrapper;

    private final SharedThemeWrapper sharedThemeWrapper;

    public SharedSettingsRepository(@NonNull Context context,
                                    @NonNull SharedPreferences preferences) {
        Resources resources = context.getResources();
        this.preferences = preferences;
        sharedCurrencyWrapper = new SharedCurrencyWrapper(preferences, resources);
        sharedThemeWrapper = new SharedThemeWrapper(preferences, resources);
    }

    @NonNull
    @Override
    public List<Currency> getCurrencyList() {
        return sharedCurrencyWrapper.getCurrencyList();
    }

    @NonNull
    @Override
    public Currency getSelectedCurrency() {
        return sharedCurrencyWrapper.getSelectedCurrency();
    }

    @Override
    public void setSelectedCurrency(@NonNull Currency currency) {
        sharedCurrencyWrapper.setSelectedCurrency(currency);
    }

    @Override
    public void addCurrency(@NonNull Currency currency) {
        sharedCurrencyWrapper.addCurrency(currency);
    }

    @NonNull
    @Override
    public List<Theme> getThemeList() {
        return sharedThemeWrapper.getThemeList();
    }

    @NonNull
    @Override
    public Theme getSelectedTheme() {
        return sharedThemeWrapper.getSelectedTheme();
    }

    @Override
    public void setSelectedTheme(@NonNull Theme theme) {
        sharedThemeWrapper.setSelectedTheme(theme);
    }

    @NonNull
    @Override
    public String getThemeTitleById(@Theme.Type.Mode int theme) {
        return sharedThemeWrapper.getThemeTitleById(theme);
    }
}