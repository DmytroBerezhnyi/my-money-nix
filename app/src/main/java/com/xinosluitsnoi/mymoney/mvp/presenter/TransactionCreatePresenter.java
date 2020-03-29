package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.entity.Transaction;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionCreateContract;

import androidx.annotation.NonNull;

public class TransactionCreatePresenter
        extends BasePresenter<TransactionCreateContract.View, TransactionCreateContract.Router>
        implements TransactionCreateContract.Presenter {

    @NonNull
    private final TransactionRepository transactionRepository;

    @NonNull
    private final CategoryRepository categoryRepository;

    public TransactionCreatePresenter(@NonNull TransactionCreateContract.Router router,
                                      @NonNull TransactionRepository transactionRepository,
                                      @NonNull CategoryRepository categoryRepository) {
        super(router);
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveTransaction(@NonNull Transaction transaction) {
        if(transaction.getId() != 0) {
            transactionRepository.update(transaction);
        } else {
            transactionRepository.add(transaction);
        }
    }

    @Override
    public void loadCategoryList(int type) {
        getView().showCategoryList(categoryRepository.getAll(type));
    }
}