package com.xinosluitsnoi.mymoney.ui.adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;

import com.xinosluitsnoi.mymoney.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class ColorRecyclerAdapter extends BaseRecyclerAdapter<Integer> {

    private int lastSelectedPosition = -1;

    public ColorRecyclerAdapter(@NonNull Resources resources) {
        swabData(createColorList(resources));
    }

    private List<Integer> createColorList(@NonNull Resources resources) {
        int[] colorsArray = resources.getIntArray(R.array.colors_palette);
        List<Integer> colorsList = new ArrayList<>(colorsArray.length);

        for (int color : colorsArray) {
            colorsList.add(color);
        }

        return colorsList;
    }

    @NonNull
    @Override
    protected BaseViewHolder<Integer> createHolder(View view) {
        return new ColorHolder(view);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_color;
    }

    public void setColorCircle(@ColorInt int color) {
        this.lastSelectedPosition = getList().indexOf(color);

        if (this.lastSelectedPosition == -1) {
            throw new UnsupportedOperationException("WRONG COLOR!");
        }

        notifyDataSetChanged();
    }

    @ColorInt
    public int getColorCircle() {
        return (lastSelectedPosition == -1) ? -1 : getList().get(lastSelectedPosition);
    }

    private class ColorHolder extends BaseViewHolder<Integer> {

        @NonNull
        private final ImageView ivCircleColor;

        ColorHolder(@NonNull View itemView) {
            super(itemView);
            ivCircleColor = itemView.findViewById(R.id.iv_color_circle);

            itemView.setOnClickListener(v -> setColorCircle(getList().get(getAdapterPosition())));
        }

        @Override
        void bind(@NonNull @ColorInt Integer color) {

            if (getAdapterPosition() == lastSelectedPosition) {
                ivCircleColor.setBackground(createDrawableBlackBorder(color));
            } else {
                ivCircleColor.setBackground(createDrawable(color));
            }
        }

        @NonNull
        private Drawable createDrawable(@ColorInt int color) {
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.OVAL);
            drawable.setColor(color);

            return drawable;
        }

        @NonNull
        private Drawable createDrawableBlackBorder(@ColorInt int color) {
            GradientDrawable drawable = (GradientDrawable) createDrawable(color);
            drawable.setStroke(3, Color.BLACK);

            return drawable;
        }
    }
}