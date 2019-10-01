package com.xinosluitsnoi.mymoney.ui.router;

import android.content.Intent;

import com.xinosluitsnoi.mymoney.mvp.contract.SettingsContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.activity.SettingsCurrencyActivity;

import androidx.annotation.NonNull;

public class SettingsRouter implements SettingsContract.Router {

    @NonNull
    private final BaseActivity activity;

    public SettingsRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showCurrencyScreen() {
        Intent intent = new Intent(activity, SettingsCurrencyActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void showThemeScreen() {
        // TODO: 17.09.19
    }

    @Override
    public void back() {
        // TODO: 17.09.19
    }
}