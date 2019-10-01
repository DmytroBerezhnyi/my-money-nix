package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.MainContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.fragment.BaseFragment;
import com.xinosluitsnoi.mymoney.ui.fragment.CategoryFragment;
import com.xinosluitsnoi.mymoney.ui.fragment.SettingsFragment;
import com.xinosluitsnoi.mymoney.ui.fragment.TransactionFragment;

import androidx.annotation.NonNull;

public class MainRouter implements MainContract.Router {

    @NonNull
    private final BaseActivity baseActivity;

    public MainRouter(@NonNull BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Override
    public void showTransactionsScreen() {
        navigate(TransactionFragment.newInstance());
    }

    @Override
    public void showCategoriesScreen() {
        navigate(CategoryFragment.newInstance());
    }

    @Override
    public void showSettingsScreen() {
        navigate(SettingsFragment.newInstance());
    }

    @Override
    public void back() {
        baseActivity.finish();
    }

    private void navigate(@NonNull BaseFragment fragment) {
        baseActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(baseActivity.getContainerId(), fragment)
                    .commit();
    }
}