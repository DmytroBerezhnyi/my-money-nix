package com.xinosluitsnoi.mymoney.ui.activity;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.database.DBCategoryRepository;
import com.xinosluitsnoi.mymoney.domain.database.DBHelper;
import com.xinosluitsnoi.mymoney.domain.database.DBTransactionRepository;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.TransactionCreateContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.TransactionCreatePresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.CategoryRecyclerAdapter;
import com.xinosluitsnoi.mymoney.ui.router.TransactionCreateRouter;

import java.util.List;

import androidx.annotation.NonNull;

public class TransactionCreateActivity extends BaseActivity<TransactionCreateContract.Presenter>
        implements TransactionCreateContract.View {

    private CategoryRecyclerAdapter categoryRecyclerAdapter;

    @Override
    public void showCategoryList(@NonNull List<Category> categories) {
        categoryRecyclerAdapter.swabData(categories);
    }

    @Override
    public void showInvalidTotal() {
        showSnack(getString(R.string.title_invalid_transaction_transaction));
    }

    @Override
    public void showInvalidDescription() {
        showSnack(getString(R.string.title_invalid_description_transaction));
    }

    @Override
    public void showInvalidCategorySelection() {
        showSnack(getString(R.string.title_invalid_category_transaction));

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
        return R.string.title_transaction_create;
    }

    // FIXME: 29.03.20 I should make single instance of dbHelper and CategoryRepository and readable db
    @NonNull
    @Override
    protected TransactionCreateContract.Presenter createPresenter() {
        TransactionCreateContract.Router router = new TransactionCreateRouter(this);
        DBHelper dbHelper = new DBHelper(this);

        CategoryRepository categoryRepository = new DBCategoryRepository(dbHelper);
        TransactionRepository transactionRepository = new DBTransactionRepository(dbHelper, categoryRepository);
        return new TransactionCreatePresenter(router, transactionRepository, categoryRepository);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}