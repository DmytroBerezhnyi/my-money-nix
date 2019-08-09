package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Theme;

import java.util.List;

import androidx.annotation.NonNull;

public interface SettingsThemeContract {

    interface View extends BaseContract.View {

        void showSelectedTheme(@NonNull Theme theme);

        void showThemeList(@NonNull List<Theme> themes);
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void loadThemeList();

        void loadSelectedTheme();

        void setSelectedTheme(@NonNull Theme theme);
    }

    interface Router extends BaseContract.Router {

    }
}