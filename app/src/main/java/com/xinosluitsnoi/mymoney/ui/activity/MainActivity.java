package com.xinosluitsnoi.mymoney.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.mvp.contract.MainContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.MainPresenter;
import com.xinosluitsnoi.mymoney.ui.router.MainRouter;

public class MainActivity
        extends BaseActivity<MainContract.Presenter>
        implements MainContract.View {

    private BottomNavigationView navigationView;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBar = findViewById(R.id.progress_bar);

        setupNavigationView();

        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.transactions);
        }
    }

    @NonNull
    @Override
    protected MainContract.Presenter createPresenter() {
        MainContract.Router router = new MainRouter(this);
        return new MainPresenter(router);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private void setupNavigationView() {
        navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setOnNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()) {
                case R.id.transactions:
                    getPresenter().showTransactionsScreen();
                    return true;

                case R.id.categories:
                    getPresenter().showCategoriesScreen();
                    return true;

                case R.id.settings:
                    getPresenter().showSettingsScreen();
                    return true;
            }
            return false;
        });
    }

    @Override
    public int getContainerId() {
        return R.id.fragment_container;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getToolbarTitleResource() {
        return R.string.app_name;
    }
}