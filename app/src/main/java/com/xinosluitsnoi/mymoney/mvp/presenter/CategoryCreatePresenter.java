package com.xinosluitsnoi.mymoney.mvp.presenter;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryCreateContract;

import androidx.annotation.NonNull;

public class CategoryCreatePresenter
        extends BasePresenter<CategoryCreateContract.View, CategoryCreateContract.Router>
        implements CategoryCreateContract.Presenter {

    @NonNull
    private final CategoryRepository categoryRepository;

    public CategoryCreatePresenter(@NonNull CategoryCreateContract.Router router,
                                   @NonNull CategoryRepository categoryRepository) {
        super(router);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveCategory(@NonNull Category category) {
        if (checkCategory(category)) {
            if (category.getId() == 0) {
                categoryRepository.add(category);
            } else {
                categoryRepository.update(category);
            }
            getRouter().back();
        }
    }

    private boolean checkCategory(@NonNull Category category) {
        boolean isCorrect = true;

        if (category.getTitle().length() == 0) {
            getView().showInvalidTitle();
            isCorrect = false;
        } else if (category.getColor() == -1) {
            getView().showInvalidColor();
            isCorrect = false;
        }
        return isCorrect;
    }
}