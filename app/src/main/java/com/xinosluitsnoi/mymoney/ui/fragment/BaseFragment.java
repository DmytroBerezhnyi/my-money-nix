package com.xinosluitsnoi.mymoney.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinosluitsnoi.mymoney.mvp.contract.BaseContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;

import java.util.Objects;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BaseContract.Presenter> extends Fragment
        implements BaseContract.View {

    private static final String TAG = BaseFragment.class.getSimpleName();

    @Nullable
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().attach(this);
        invalidateToolbarTitle();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getPresenter().detach();
    }

    protected void invalidateToolbarTitle() {
        if (getActivity() != null) {
            requireBaseActivity().setTitle(getToolbarTitle());
        } else {
            Log.e(TAG, "getActivity(); returns null. Couldn't call invalidateToolbarTitle();");
        }
    }

    @NonNull
    public CharSequence getToolbarTitle() {
        return getString(getToolbarTitleResource());
    }

    @Override
    public void onError(@Nullable Throwable throwable) {
        if (getActivity() != null) {
            requireBaseActivity().onError(throwable);
        } else {
            Log.e(TAG, "getActivity(); returns null. Couldn't call onError();");
        }
    }

    @Override
    public void showProgress() {
        if (getActivity() != null) {
            requireBaseActivity().showProgress();
        } else {
            Log.e(TAG, "getActivity(); returns null. Couldn't call showProgress();");
        }
    }

    @Override
    public void hideProgress() {
        if (getActivity() != null) {
            requireBaseActivity().hideProgress();
        } else {
            Log.e(TAG, "getActivity(); returns null. Couldn't call hideProgress();");
        }
    }

    @NonNull
    protected P getPresenter() {
        return Objects.requireNonNull(presenter);
    }

    @NonNull
    private BaseActivity requireBaseActivity() {
        return (BaseActivity) requireActivity();
    }

    @StringRes
    public abstract int getToolbarTitleResource();

    @LayoutRes
    protected abstract int getLayoutId();

    @NonNull
    protected abstract P createPresenter();
}