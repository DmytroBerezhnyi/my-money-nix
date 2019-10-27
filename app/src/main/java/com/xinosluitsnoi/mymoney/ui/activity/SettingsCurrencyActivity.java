package com.xinosluitsnoi.mymoney.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.domain.repository.SettingsRepository;
import com.xinosluitsnoi.mymoney.domain.shared.SharedSettingsRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.SettingsCurrencyContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.SettingsCurrencyPresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.CurrencyAdapter;
import com.xinosluitsnoi.mymoney.ui.fragment.BaseDialog;
import com.xinosluitsnoi.mymoney.ui.router.SettingsCurrencyRouter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class SettingsCurrencyActivity
        extends BaseActivity<SettingsCurrencyContract.Presenter>
        implements SettingsCurrencyContract.View, BaseDialog.MyDialogCloseListener {

    private CurrencyAdapter currencyAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getPresenter().loadCurrencyList();
    }

    @Override
    public void showCurrencyList(@NonNull List<Currency> currencies, int currencyIndex) {
        currencyAdapter.swabData(currencies, currencyIndex);
    }

    @Override
    public void showSelectedCurrency(int currencyIndex) {
        currencyAdapter.setCurrencyIndex(currencyIndex);
        getPresenter().setSelectedCurrency(currencyIndex);
    }

    @Override
    public void handleDialogClose() {
        getPresenter().loadCurrencyList();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.rv_currencies);
        currencyAdapter = new CurrencyAdapter(this);
        recyclerView.setAdapter(currencyAdapter);

        findViewById(R.id.fab_back).setOnClickListener(v -> getPresenter().back());

        findViewById(R.id.fab_add_currency).setOnClickListener(v -> getPresenter().showNewCurrencyScreen());
    }

    @Override
    public int getToolbarTitleResource() {
        return R.string.title_currency;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings_currency;
    }

    @Override
    public int getContainerId() {
        return R.id.container;
    }

    @Override
    public void showProgress() {
        //none
    }

    @Override
    public void hideProgress() {
        //none
    }

    @NonNull
    @Override
    protected SettingsCurrencyContract.Presenter createPresenter() {
        SettingsCurrencyContract.Router router = new SettingsCurrencyRouter(this);
        SharedPreferences sharedPreferences = getSettingsPreferences();

        SettingsRepository settingsRepository =
                new SharedSettingsRepository(getResources(), sharedPreferences);

        return new SettingsCurrencyPresenter(router, settingsRepository);
    }
}