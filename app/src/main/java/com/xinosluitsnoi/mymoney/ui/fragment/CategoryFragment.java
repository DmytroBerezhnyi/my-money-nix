package com.xinosluitsnoi.mymoney.ui.fragment;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.CategoryPresenter;
import com.xinosluitsnoi.mymoney.ui.router.CategoryRouter;

import androidx.annotation.NonNull;

public class CategoryFragment
        extends BaseFragment<CategoryContract.Presenter>
        implements CategoryContract.View {

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public int getToolbarTitleResource() {
        return R.string.title_categories;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }

    @NonNull
    @Override
    protected CategoryContract.Presenter createPresenter() {
        CategoryContract.Router router = new CategoryRouter(requireBaseActivity());
        return new CategoryPresenter(router);
    }
}