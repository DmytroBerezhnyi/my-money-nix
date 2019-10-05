package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.SettingsContract;

import androidx.annotation.NonNull;

public class SettingsPresenter
        extends BasePresenter<SettingsContract.View, SettingsContract.Router>
        implements SettingsContract.Presenter {

    @NonNull
    private final SettingsRepository settingsRepository;

    public SettingsPresenter(@NonNull SettingsContract.Router router,
                             @NonNull SettingsRepository settingsRepository) {
        super(router);
        this.settingsRepository = settingsRepository;
    }

    @Override
    public void loadCurrentSettings() {
        getView().showSelectedCurrency(settingsRepository.getCurrencyList()
                                                         .get(settingsRepository.getSelectedCurrency()));
        getView().showSelectedTheme(settingsRepository.getSelectedTheme());
    }

    @Override
    public void showCurrencyScreen() {
        getRouter().showCurrencyScreen();
    }

    @Override
    public void showThemeScreen() {
        getRouter().showThemeScreen();
    }
}