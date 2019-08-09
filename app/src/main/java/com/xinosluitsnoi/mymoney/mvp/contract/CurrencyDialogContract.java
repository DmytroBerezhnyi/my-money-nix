package com.xinosluitsnoi.mymoney.mvp.contract;

import com.xinosluitsnoi.mymoney.domain.entity.Currency;

import androidx.annotation.NonNull;

public interface CurrencyDialogContract {

    interface View extends BaseContract.View {

        void showInvalidTitle();
    }

    interface Presenter extends BaseContract.Presenter<View, Router> {

        void saveCurrency(@NonNull Currency currency);
    }

    interface Router extends BaseContract.Router {

    }
}