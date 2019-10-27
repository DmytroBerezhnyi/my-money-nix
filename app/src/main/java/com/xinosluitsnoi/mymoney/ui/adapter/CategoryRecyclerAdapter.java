package com.xinosluitsnoi.mymoney.ui.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.mvp.contract.CategoryListContract;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class CategoryRecyclerAdapter extends BaseRecyclerAdapter<Category> {

    private final CategoryListContract.Presenter presenter;

    public CategoryRecyclerAdapter(CategoryListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    protected BaseViewHolder<Category> createHolder(View view) {
        return new CategoryHolder(view);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_category;
    }

    private class CategoryHolder extends BaseViewHolder<Category> {

        @NonNull
        private final View barColor;

        @NonNull
        private final TextView title;

        @NonNull
        private final TextView type;

        private final float radius;

        CategoryHolder(@NonNull View itemView) {
            super(itemView);

            barColor = itemView.findViewById(R.id.view_color);
            title = itemView.findViewById(R.id.tv_category_title);
            type = itemView.findViewById(R.id.tv_category_type);

            radius = itemView.getResources().getDimensionPixelSize(R.dimen.radius_corner_cardview);
            itemView.setOnClickListener(v -> presenter.showEditCategoryScreen(getList().get(getAdapterPosition())));
        }

        @Override
        void bind(@NonNull Category category) {
            barColor.setBackground(createCornerDrawable(category.getColor()));
            title.setText(category.getTitle());
            showCategoryType(category);
        }

        private void showCategoryType(@NonNull Category category) {
            switch (category.getType()) {

                case Category.Type.Mode.ALL:
                    type.setText(R.string.title_all);
                    break;
                case Category.Type.Mode.INCOME:
                    type.setText(R.string.title_income);
                    break;
                case Category.Type.Mode.CONSUME:
                    type.setText(R.string.title_consume);
                    break;
            }
        }

        private Drawable createCornerDrawable(@ColorInt int color) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            gradientDrawable.setColor(color);
            gradientDrawable.setCornerRadii(new float[]{radius, radius, 0, 0, 0, 0, radius, radius});

            return gradientDrawable;
        }
    }
}