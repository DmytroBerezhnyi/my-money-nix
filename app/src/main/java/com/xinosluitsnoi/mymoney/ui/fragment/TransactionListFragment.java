package com.xinosluitsnoi.mymoney.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;
import com.xinosluitsnoi.mymoney.domain.mock.MockTransactionRepository;
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionListContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.TransactionListPresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.BaseRecyclerAdapter;
import com.xinosluitsnoi.mymoney.ui.adapter.TransactionRecyclerAdapter;
import com.xinosluitsnoi.mymoney.ui.router.TransactionListRouter;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionListFragment extends BasePagerFragment<TransactionListPresenter>
        implements TransactionListContract.View {

    private static final String mode_arg = "mode_arg";

    private View emptyStateView;

    private BaseRecyclerAdapter<Transaction> recyclerAdapter;

    private RecyclerView recyclerView;

    public static TransactionListFragment newInstance(@Category.Type.Mode int type) {

        Bundle args = new Bundle();
        args.putInt(mode_arg, type);

        TransactionListFragment fragment = new TransactionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emptyStateView = view.findViewById(R.id.empty_transaction_state);
        recyclerView = view.findViewById(R.id.rv_transactions);

        recyclerAdapter = new TransactionRecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().loadTransactionList(Objects.requireNonNull(getArguments()).getInt(mode_arg));
    }

    @Override
    public void showEmptyList() {
        emptyStateView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showList(@NonNull List<Transaction> transactions) {
        emptyStateView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerAdapter.swabData(transactions);
    }

    @StringRes
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
        return R.layout.fragment_transaction_list;
    }

    @NonNull
    @Override
    protected TransactionListPresenter createPresenter() {
        //DBHelper dbHelper = new DBHelper(requireContext());
        //TransactionRepository transactionRepository = new DBTransactionRepository(dbHelper);
        TransactionRepository transactionRepository = new MockTransactionRepository();

        TransactionListContract.Router router = new TransactionListRouter(requireBaseActivity());

        return new TransactionListPresenter(router, transactionRepository);
    }
}