package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;

import java.util.List;

import androidx.annotation.NonNull;

public interface SettingsCurrencyContract {

    interface View extends BaseContract.View {

        void showSelectedCurrency(@NonNull Currency currency);

        void showCurrencyList(@NonNull List<Currency> currencies);
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void loadCurrencyList();

        void loadSelectedCurrency();

        void setSelectedCurrency(@NonNull Currency currency);

        void showDialogScreen();
    }

    interface Router extends BaseContract.Router {

        void showDialogScreen();
    }
}