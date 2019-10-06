package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryListContract;

import java.util.List;

import androidx.annotation.NonNull;

public class CategoryListPresenter
        extends BasePresenter<CategoryListContract.View, CategoryListContract.Router>
        implements CategoryListContract.Presenter {

    @NonNull
    private final CategoryRepository categoryRepository;

    public CategoryListPresenter(@NonNull CategoryListContract.Router router,
                                 @NonNull CategoryRepository categoryRepository) {
        super(router);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void loadCategoryList(int type) {
        List<Category> categories = categoryRepository.getAll(type);

        if(categories.size() == 0) {
            getView().showEmptyList();
        } else {
            getView().showList(categories);
        }
    }

    @Override
    public void showEditCategoryScreen(@NonNull Category category) {
        getRouter().showEditCategoryScreen(category);
    }
}