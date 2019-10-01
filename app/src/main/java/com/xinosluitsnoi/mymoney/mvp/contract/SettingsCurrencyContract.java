package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;

import java.util.List;

import androidx.annotation.NonNull;

public interface SettingsCurrencyContract {

    interface View extends BaseContract.View {

        void showSelectedCurrency(int currencyIndex);

        void showCurrencyList(@NonNull List<Currency> currencies, int currencyIndex);
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void loadCurrencyList();

        void loadSelectedCurrency();

        void setSelectedCurrency(int currencyIndex);

        void showNewCurrencyScreen();
    }

    interface Router extends BaseContract.Router {

        void showNewCurrencyScreen();
    }
}