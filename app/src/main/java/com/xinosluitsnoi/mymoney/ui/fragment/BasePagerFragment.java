package com.xinosluitsnoi.mymoney.ui.fragment;

import com.xinosluitsnoi.mymoney.mvp.contract.BaseContract;

public abstract class BasePagerFragment<P extends BaseContract.Presenter>
        extends BaseFragment<P> {

    @Override
    protected void invalidateToolbarTitle() {
        // none
    }
}