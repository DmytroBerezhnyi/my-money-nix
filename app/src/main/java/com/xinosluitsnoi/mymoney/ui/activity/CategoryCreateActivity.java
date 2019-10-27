package com.xinosluitsnoi.mymoney.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.database.DBCategoryRepository;
import com.xinosluitsnoi.mymoney.domain.database.DBHelper;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.mapper.CategoryFromBundleMapper;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryCreateContract;
import com.xinosluitsnoi.mymoney.mvp.presenter.CategoryCreatePresenter;
import com.xinosluitsnoi.mymoney.ui.adapter.ColorRecyclerAdapter;
import com.xinosluitsnoi.mymoney.ui.router.CategoryCreateRouter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

// FIXME: 27.10.19 all logic to presenter or etc.
public class CategoryCreateActivity extends BaseActivity<CategoryCreateContract.Presenter>
        implements CategoryCreateContract.View {

    private EditText etTitle;

    private RecyclerView rvColors;

    private ColorRecyclerAdapter adapterColors;

    private CheckBox cbIncome;

    private CheckBox cbConsume;

    private Button btnSave;

    private CategoryFromBundleMapper categoryFromDBMapper;

    private Category category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        etTitle = findViewById(R.id.et_category_title);
        rvColors = findViewById(R.id.rv_category_colors);
        cbIncome = findViewById(R.id.cb_category_income);
        cbConsume = findViewById(R.id.cb_category_consume);
        btnSave = findViewById(R.id.btn_category_save);

        adapterColors = new ColorRecyclerAdapter(getResources());
        rvColors.setAdapter(adapterColors);

        categoryFromDBMapper = new CategoryFromBundleMapper();

        category = getCategory();

        btnSave.setOnClickListener(v -> {

            if (!cbIncome.isChecked() && !cbConsume.isChecked()) {
                showInvalidType();
                return;
            }

            category.setType(getType());
            category.setTitle(etTitle.getText().toString());
            category.setColor(adapterColors.getColorCircle());

            getPresenter().saveCategory(category);
        });
    }

    private Category getCategory() {

        Category category;

        if (getIntent().getExtras() != null) {
            category = categoryFromDBMapper.map(getIntent().getExtras());
            etTitle.setText(category.getTitle());
            adapterColors.setColorCircle(category.getColor());
            intiCheckBox(category.getType());
        } else {
            category = new Category();
        }

        return category;
    }

    @Category.Type.Mode
    private int getType() {
        if (cbIncome.isChecked() && cbConsume.isChecked()) {
            return Category.Type.Mode.ALL;
        } else if (cbIncome.isChecked()) {
            return Category.Type.Mode.INCOME;
        } else if (cbConsume.isChecked()) {
            return Category.Type.Mode.CONSUME;
        }

        throw new UnsupportedOperationException();
    }

    private void intiCheckBox(@Category.Type.Mode int type) {
        boolean cbIncomeChecked;
        boolean cbConsumeChecked;

        switch (type) {
            case Category.Type.Mode.ALL:
                cbIncomeChecked = true;
                cbConsumeChecked = true;
                break;

            case Category.Type.Mode.CONSUME:
                cbIncomeChecked = false;
                cbConsumeChecked = true;
                break;

            case Category.Type.Mode.INCOME:
                cbIncomeChecked = true;
                cbConsumeChecked = false;
                break;

            default:
                throw new UnsupportedOperationException();
        }

        cbIncome.setChecked(cbIncomeChecked);
        cbConsume.setChecked(cbConsumeChecked);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_category;
    }

    @Override
    public int getContainerId() {
        return R.id.layout_category_create;
    }

    @Override
    protected int getToolbarTitleResource() {
        return R.string.title_category_create;
    }

    @Override
    public void showInvalidTitle() {
        Snackbar.make(getContainer(), R.string.title_invalid_category_title, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showInvalidType() {
        Snackbar.make(getContainer(), R.string.title_invalid_category_type, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showInvalidColor() {
        Snackbar.make(getContainer(), R.string.title_invalid_category_color, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @NonNull
    @Override
    protected CategoryCreateContract.Presenter createPresenter() {
        CategoryCreateContract.Router router = new CategoryCreateRouter(this);

        DBHelper dbHelper = new DBHelper(this);
        CategoryRepository categoryRepository = new DBCategoryRepository(dbHelper);
        return new CategoryCreatePresenter(router, categoryRepository);
    }
}
