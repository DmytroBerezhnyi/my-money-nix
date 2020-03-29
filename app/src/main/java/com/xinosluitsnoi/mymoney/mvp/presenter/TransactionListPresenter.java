package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.entity.Transaction;
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionListContract;

import java.util.List;

import androidx.annotation.NonNull;

public class TransactionListPresenter
        extends BasePresenter<TransactionListContract.View, TransactionListContract.Router>
        implements TransactionListContract.Presenter {

    @NonNull
    private final TransactionRepository transactionRepository;

    public TransactionListPresenter(@NonNull TransactionListContract.Router router,
                                    @NonNull TransactionRepository transactionRepository) {
        super(router);
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void loadTransactionList(int type) {
        List<Transaction> transactions = transactionRepository.getAll(type);
        if(transactions.size() == 0) {
            getView().showEmptyList();
        } else {
            getView().showList(transactions);
        }
    }

    @Override
    public void showEditTransactionScreen(@NonNull Transaction transaction) {
        getRouter().showEditTransactionScreen(transaction);
    }

    @Override
    public void deleteTransaction(@NonNull Transaction transaction) {
        transactionRepository.delete(transaction);
    }
}