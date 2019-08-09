package com.xinosluitsnoi.mymoney.mvp.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface BaseContract {

    interface View {

        void onError(@Nullable Throwable throwable);

        void showProgress();

        void hideProgress();
    }

    interface Presenter<V extends View, R extends Router> {

        void back();

        void attach(@NonNull V view);

        void detach();

        @NonNull
        V getView();

        @NonNull
        R getRouter();
    }

    interface Router {

        void back();
    }
}