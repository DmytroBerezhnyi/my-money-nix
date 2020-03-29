package com.xinosluitsnoi.mymoney.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.TransactionPresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.BasePagerAdapter;
import com.xinosluitsnoi.mymoney.ui.adapter.TransactionPagerAdapter;
import com.xinosluitsnoi.mymoney.ui.router.TransactionRouter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class TransactionFragment
        extends BaseFragment<TransactionContract.Presenter>
        implements TransactionContract.View {

    private ViewPager viewPager;

    private BasePagerAdapter pagerAdapter;

    private TabLayout tabLayout;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewpager_transaction);
        tabLayout = view.findViewById(R.id.tablayout_transaction);

        pagerAdapter = new TransactionPagerAdapter(requireContext(), getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        view.findViewById(R.id.fab_create_transaction)
            .setOnClickListener(v -> getPresenter().showCreateTransactionScreen());
    }

    @NonNull
    @Override
    protected TransactionContract.Presenter createPresenter() {
        TransactionContract.Router router = new TransactionRouter(requireBaseActivity());
        return new TransactionPresenter(router);
    }
}