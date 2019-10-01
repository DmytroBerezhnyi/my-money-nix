package com.xinosluitsnoi.mymoney.ui.fragment;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.TransactionPresenter;
import com.xinosluitsnoi.mymoney.ui.router.TransactionRouter;

import androidx.annotation.NonNull;

public class TransactionFragment
        extends BaseFragment<TransactionContract.Presenter>
        implements TransactionContract.View {

    public static TransactionFragment newInstance() {
        return new TransactionFragment();
    }

    @Override
    public int getToolbarTitleResource() {
        return R.string.title_transaction;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_transaction;
    }

    @NonNull
    @Override
    protected TransactionContract.Presenter createPresenter() {
        TransactionContract.Router router = new TransactionRouter(requireBaseActivity());
        return new TransactionPresenter(router);
    }
}