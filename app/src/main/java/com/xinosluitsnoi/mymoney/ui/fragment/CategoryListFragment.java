package com.xinosluitsnoi.mymoney.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.database.DBCategoryRepository;
import com.xinosluitsnoi.mymoney.domain.database.DBHelper;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryListContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.CategoryListPresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.CategoryRecyclerAdapter;
import com.xinosluitsnoi.mymoney.ui.router.CategoryListRouter;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryListFragment extends BasePagerFragment<CategoryListContract.Presenter>
        implements CategoryListContract.View {

    private static final String mode_arg = "mode";

    private View emptyStateView;

    private RecyclerView recyclerView;

    private CategoryRecyclerAdapter recyclerAdapter;

    public static CategoryListFragment newInstance(@Category.Type.Mode int type) {

        Bundle args = new Bundle();
        args.putInt(mode_arg, type);

        CategoryListFragment fragment = new CategoryListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emptyStateView = view.findViewById(R.id.empty_transaction_state);
        recyclerView = view.findViewById(R.id.rv_transactions);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        recyclerAdapter = new CategoryRecyclerAdapter(getPresenter());
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().loadCategoryList(Objects.requireNonNull(getArguments()).getInt(mode_arg));
    }

    @Override
    public void showEmptyList() {
        emptyStateView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showList(@NonNull List<Category> categories) {
        emptyStateView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerAdapter.swabData(categories);
    }

    @Override
    public int getToolbarTitleResource() {

        if (getArguments() != null) {
            switch (getArguments().getInt(mode_arg)) {

                case Category.Type.Mode.ALL:
                    return R.string.title_all;

                case Category.Type.Mode.INCOME:
                    return R.string.title_income;

                case Category.Type.Mode.CONSUME:
                    return R.string.title_consume;
            }
        }
        return -1;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category_list;
    }

    @NonNull
    @Override
    protected CategoryListContract.Presenter createPresenter() {
        CategoryListContract.Router router = new CategoryListRouter(requireBaseActivity());

        DBHelper dbHelper = new DBHelper(requireContext());
        CategoryRepository categoryRepository = new DBCategoryRepository(dbHelper);
        return new CategoryListPresenter(router, categoryRepository);
    }
}