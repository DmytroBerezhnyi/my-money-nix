package com.xinosluitsnoi.mymoney.domain.shared;

import android.content.SharedPreferences;
import android.content.res.Resources;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.mapper.CurrencyFromSharedMapper;
import com.xinosluitsnoi.mymoney.domain.mapper.CurrencyToSharedMapper;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;

public class SharedCurrencyWrapper {

    @NonNull
    private static final String CURRENCIES = "currencies";

    private static final String SELECTED_CURRENCY = "selected_currency";

    @NonNull
    private final SharedPreferences preferences;

    @NonNull
    private final Resources resources;

    @NonNull
    private final CurrencyToSharedMapper currencyToSharedMapper;

    @NonNull
    private final CurrencyFromSharedMapper currencyFromSharedMapper;

    public SharedCurrencyWrapper(@NonNull SharedPreferences preferences,
                                 @NonNull Resources resources) {
        this.preferences = preferences;
        this.resources = resources;

        currencyToSharedMapper = new CurrencyToSharedMapper();
        currencyFromSharedMapper = new CurrencyFromSharedMapper();
    }

    @NonNull
    public List<Currency> getCurrencyList() {
        String currencies =
                preferences.getString(CURRENCIES, getDefaultCurrencies());
        return currencyFromSharedMapper.map(Objects.requireNonNull(currencies));
    }

    @NonNull
    public Currency getSelectedCurrency() {

        String title = preferences.getString(SELECTED_CURRENCY,
                                             currencyFromSharedMapper.map(getDefaultCurrencies())
                                                                     .get(0)
                                                                     .getTitle());
        return new Currency(Objects.requireNonNull(title));
    }

    public void setSelectedCurrency(@NonNull Currency currency) {
        preferences.edit()
                   .putString(SELECTED_CURRENCY, currency.getTitle())
                   .apply();
    }

    public void addCurrency(@NonNull Currency currency) {
        List<Currency> currencies = getCurrencyList();
        currencies.add(currency);
        preferences.edit()
                   .putString(CURRENCIES, currencyToSharedMapper.map(currencies))
                   .apply();
    }

    private String getDefaultCurrencies() {
        return resources.getString(R.string.default_currencies);
    }
}