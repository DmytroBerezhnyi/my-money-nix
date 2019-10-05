package com.xinosluitsnoi.mymoney.ui.router;

import com.xinosluitsnoi.mymoney.mvp.contract.CurrencyDialogContract;
import com.xinosluitsnoi.mymoney.ui.activity.BaseActivity;
import com.xinosluitsnoi.mymoney.ui.fragment.CurrencyDialog;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class CurrencyDialogRouter implements CurrencyDialogContract.Router {

    @NonNull
    private final BaseActivity baseActivity;

    public CurrencyDialogRouter(@NonNull BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Override
    public void back() {
        Fragment fragment = baseActivity.getSupportFragmentManager()
                                        .findFragmentByTag(CurrencyDialog.dialog_tag);

        if (fragment != null) {
            DialogFragment dialogFragment = (DialogFragment) fragment;
            dialogFragment.dismiss();
        }
    }
}