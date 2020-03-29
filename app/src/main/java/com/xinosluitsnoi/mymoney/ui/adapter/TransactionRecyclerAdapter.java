package com.xinosluitsnoi.mymoney.ui.adapter;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;

public class TransactionRecyclerAdapter extends BaseRecyclerAdapter<Transaction> {

    @NonNull
    @Override
    protected BaseViewHolder<Transaction> createHolder(View view) {
        return new TransactionHolder(view);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_transaction;
    }

    private class TransactionHolder extends BaseViewHolder<Transaction> {

        private final ImageView icon;

        private final TextView tvTitle;

        private final TextView tvTotal;

        private final TextView tvCategory;

        private final TextView tvDate;

        private final Drawable icIncome;

        private final Drawable icConsume;

        private final Drawable icAll;

        TransactionHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.iv_transaction_icon);
            tvTitle = itemView.findViewById(R.id.tv_transaction_title);
            tvTotal = itemView.findViewById(R.id.tv_transaction_total);
            tvCategory = itemView.findViewById(R.id.tv_transaction_category);
            tvDate = itemView.findViewById(R.id.tv_transaction_date);

            icAll = getDrawable(R.drawable.ic_arrow_transaction_income_24dp);
            icIncome = getDrawable(R.drawable.ic_arrow_transaction_income_24dp);
            icConsume = getDrawable(R.drawable.ic_arrow_transaction_consume_24dp);
        }

        @Override
        void bind(@NonNull Transaction transaction) {

            Drawable current = icAll;

            if (transaction.getType() == Category.Type.Mode.INCOME) {
                current = icIncome;
            } else if (transaction.getType() == Category.Type.Mode.CONSUME) {
                current = icConsume;
            }

            current.setColorFilter(transaction.getCategory().getColor(), PorterDuff.Mode.SRC_IN);
            icon.setBackground(current);

            tvTitle.setText(transaction.getTitle());
            tvTotal.setText(Double.toString(transaction.getTotal()));
            tvCategory.setText(transaction.getCategory().getTitle());

            tvDate.setText(getFormattedTime(transaction.getDate()));
        }

        private String getFormattedTime(long millis) {
            Calendar today = Calendar.getInstance();

            Calendar yesterday = Calendar.getInstance();
            yesterday.add(Calendar.DAY_OF_YEAR, -1);

            Calendar date = Calendar.getInstance();
            date.setTime(new Date(millis));

            String time = date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE);
            String formattedDate = date.get(Calendar.DAY_OF_MONTH) + "." +
                    date.get(Calendar.MONTH) + "." + date.get(Calendar.YEAR);

            if(compareDay(yesterday, date)) {
                return itemView.getContext().getString(R.string.yesterday);
            } else if(compareDay(today, date)) {
                return itemView.getContext().getString(R.string.today) + " " + time;

            } else {
                return formattedDate;

            }
        }

        private boolean compareDay(Calendar c1, Calendar c2) {
            return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                    && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
        }

        private Drawable getDrawable(@DrawableRes int resId) {
            return AppCompatResources.getDrawable(itemView.getContext(), resId);
        }
    }
}