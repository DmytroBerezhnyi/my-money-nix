package com.xinosluitsnoi.mymoney.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.xinosluitsnoi.mymoney.mvp.contract.BaseContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;

public abstract class BaseDialog<P extends BaseContract.Presenter> extends DialogFragment
        implements BaseContract.View {

    private static final String TAG = BaseDialog.class.getSimpleName();

    @Nullable
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        getPresenter().attach(this);
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        getPresenter().detach();
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
    protected BaseActivity requireBaseActivity() {
        return (BaseActivity) requireActivity();
    }

    @StringRes
    protected abstract int getDialogTitle();

    @NonNull
    protected P getPresenter() {
        return Objects.requireNonNull(presenter);
    }

    @NonNull
    protected abstract P createPresenter();

    public interface MyDialogCloseListener {

        public void handleDialogClose();
    }
}