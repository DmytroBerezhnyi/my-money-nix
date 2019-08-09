package com.xinosluitsnoi.mymoney.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.xinosluitsnoi.mymoney.mvp.contract.BaseContract;

import java.util.Objects;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BaseContract.Presenter>
        extends AppCompatActivity
        implements BaseContract.View {

    private static final String TAG = BaseActivity.class.getSimpleName();

    private ViewGroup container;

    @NonNull
    private P presenter = createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        container = findViewById(getContainerId());
        getPresenter().attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().detach();
    }

    protected void invalidateToolbarTitle() {
        setTitle(getToolbarTitle());
    }

    @NonNull
    protected CharSequence getToolbarTitle() {
        return getString(getToolbarTitleResource());
    }

    @NonNull
    protected P getPresenter() {
        return Objects.requireNonNull(presenter);
    }

    @Override
    public void onError(@Nullable Throwable throwable) {
        String message = throwable == null ? "Something went wrong" : throwable.getMessage();

        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show();
        Log.e(TAG, "onError: ", throwable);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @IdRes
    protected abstract int getContainerId();

    @StringRes
    protected abstract int getToolbarTitleResource();

    @NonNull
    abstract P createPresenter();
}