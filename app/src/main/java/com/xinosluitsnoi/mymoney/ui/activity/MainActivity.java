package com.xinosluitsnoi.mymoney.ui.activity;

import androidx.annotation.NonNull;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.mvp.contract.MainActivityContract;

public class MainActivity extends BaseActivity<MainActivityContract.Presenter>
        implements MainActivityContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getContainerId() {
        return R.id.container_view;
    }

    @Override
    protected int getToolbarTitleResource() {
        return R.string.app_name;
    }

    @NonNull
    @Override
    MainActivityContract.Presenter createPresenter() {
        // TODO: 09.08.19
        throw new UnsupportedOperationException("Will be implemented later");
    }

    @Override
    public void showProgress() {
        // TODO: 09.08.19
        throw new UnsupportedOperationException("Will be implemented later");
    }

    @Override
    public void hideProgress() {
        // TODO: 09.08.19
        throw new UnsupportedOperationException("Will be implemented later");
    }
}