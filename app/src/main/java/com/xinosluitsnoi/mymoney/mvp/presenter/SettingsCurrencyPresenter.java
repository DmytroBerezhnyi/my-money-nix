package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.SettingsCurrencyContract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SettingsCurrencyPresenter
        extends BasePresenter<SettingsCurrencyContract.View, SettingsCurrencyContract.Router>
        implements SettingsCurrencyContract.Presenter {

    @NonNull
    private final SettingsRepository settingsRepository;

    public SettingsCurrencyPresenter(@NonNull SettingsCurrencyContract.Router router,
                                     @NonNull SettingsRepository settingsRepository) {
        super(router);
        this.settingsRepository = settingsRepository;
    }

    @Override
    public void loadCurrencyList() {
        getView().showCurrencyList(settingsRepository.getCurrencyList(),
                                   settingsRepository.getSelectedCurrency());
    }

    @Override
    public void loadSelectedCurrency() {
        getView().showSelectedCurrency(settingsRepository.getSelectedCurrency());
    }

    @Override
    public void setSelectedCurrency(int currencyIndex) {
        settingsRepository.setSelectedCurrency(currencyIndex);
    }

    @Override
    public void showNewCurrencyScreen() {
        getRouter().showNewCurrencyScreen();
    }
}