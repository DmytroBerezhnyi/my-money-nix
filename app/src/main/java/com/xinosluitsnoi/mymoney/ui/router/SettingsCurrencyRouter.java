package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.SettingsCurrencyContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.fragment.CurrencyDialog;

import androidx.annotation.NonNull;

public class SettingsCurrencyRouter implements SettingsCurrencyContract.Router {

    @NonNull
    private final BaseActivity activity;

    public SettingsCurrencyRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showNewCurrencyScreen() {
        CurrencyDialog.newInstance()
                      .show(activity.getSupportFragmentManager(), CurrencyDialog.dialog_tag);
    }

    // FIXME: 02.10.19 When resizing its crashing!!!
    //  And whats happening when previous activity is destroyed
    //  Should see in backStack?
    @Override
    public void back() {
        activity.finish();
    }
}