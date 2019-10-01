package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.CurrencyDialogContract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CurrencyPresenter
        extends BasePresenter<CurrencyDialogContract.View, CurrencyDialogContract.Router>
        implements CurrencyDialogContract.Presenter {

    private final SettingsRepository settingsRepository;

    public CurrencyPresenter(@NonNull CurrencyDialogContract.Router router,
                             @NonNull SettingsRepository settingsRepository) {
        super(router);
        this.settingsRepository = settingsRepository;
    }

    @Override
    public void saveCurrency(@NonNull Currency currency) {
        settingsRepository.addCurrency(currency);
    }

    @Override
    public void checkCurrencyTitle(@Nullable String title) {
        if (title != null && (title = title.trim()).length() > 0) {
            saveCurrency(new Currency(title));
            getRouter().back();
        } else {
            getView().showInvalidTitle();
        }
    }
}