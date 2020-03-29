package com.xinosluitsnoi.mymoney.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.CategoryPresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.BasePagerAdapter;
import com.xinosluitsnoi.mymoney.ui.adapter.CategoryPagerAdapter;
import com.xinosluitsnoi.mymoney.ui.router.CategoryRouter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CategoryFragment
        extends BaseFragment<CategoryContract.Presenter>
        implements CategoryContract.View {

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private BasePagerAdapter pagerAdapter;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewpager_category);
        tabLayout = view.findViewById(R.id.tablayout_category);

        view.findViewById(R.id.fab_create_category)
            .setOnClickListener(v -> getPresenter().showCreateCategoryScreen());

        pagerAdapter = new CategoryPagerAdapter(requireContext(), getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

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