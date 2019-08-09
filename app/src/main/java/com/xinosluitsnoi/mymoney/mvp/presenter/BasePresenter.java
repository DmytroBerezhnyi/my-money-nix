package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.mvp.contract.BaseContract;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BasePresenter<V extends BaseContract.View, R extends BaseContract.Router>
        implements BaseContract.Presenter<V, R> {

    @NonNull
    private final R router;

    @Nullable
    private V view;

    public BasePresenter(@NonNull R router) {
        this.router = router;
    }

    @Override
    public void back() {
        router.back();
    }

    @CallSuper
    @Override
    public void attach(@NonNull V view) {
        this.view = view;
    }

    @CallSuper
    @Override
    public void detach() {
        this.view = null;
    }

    @NonNull
    @Override
    public V getView() {
        return view;
    }

    @Override
    @NonNull
    public R getRouter() {
        return router;
    }
}