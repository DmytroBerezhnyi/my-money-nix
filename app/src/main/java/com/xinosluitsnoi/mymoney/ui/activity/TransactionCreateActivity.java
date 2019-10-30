package com.xinosluitsnoi.mymoney.ui.activity;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionCreateContract;

import java.util.List;

import androidx.annotation.NonNull;

public class TransactionCreateActivity extends BaseActivity<TransactionCreateContract.Presenter>
        implements TransactionCreateContract.View {

    @Override
    public void showCategoryList(@NonNull List<Category> categories) {

    }

    @Override
    public void showInvalidTotal() {

    }

    @Override
    public void showInvalidDescription() {

    }

    @Override
    public void showInvalidCategorySelection() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public int getContainerId() {
        return 0;
    }

    @Override
    protected int getToolbarTitleResource() {
        return 0;
    }

    @NonNull
    @Override
    protected TransactionCreateContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
