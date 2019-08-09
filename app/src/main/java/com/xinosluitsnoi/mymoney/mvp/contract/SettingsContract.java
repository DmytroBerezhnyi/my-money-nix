package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.entity.Theme;

import androidx.annotation.NonNull;

public interface SettingsContract {

    interface View extends BaseContract.View {

        void showSelectedCurrency(@NonNull Currency currency);

        void showSelectedTheme(@NonNull Theme theme);
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void loadCurrentSettings();

        void showCurrencyScreen();

        void showThemeScreen();
    }

    interface Router extends BaseContract.Router {

        void showCurrencyScreen();

        void showThemeScreen();
    }
}