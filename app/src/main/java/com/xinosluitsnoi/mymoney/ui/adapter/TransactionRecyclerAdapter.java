
package com.xinosluitsnoi.mymoney.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;

import java.util.Date;

import androidx.annotation.NonNull;

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

        TransactionHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.iv_transaction_icon);
            tvTitle = itemView.findViewById(R.id.tv_transaction_title);
            tvTotal = itemView.findViewById(R.id.tv_transaction_total);
            tvCategory = itemView.findViewById(R.id.tv_transaction_category);
            tvDate = itemView.findViewById(R.id.tv_transaction_date);
        }

        @Override
        void bind(@NonNull Transaction transaction) {
            if (transaction.getType() == Category.Type.Mode.INCOME) {
                // TODO: 06.10.19
            } else if (transaction.getType() == Category.Type.Mode.CONSUME) {
                // TODO: 06.10.19
            }

            tvTitle.setText(transaction.getTitle());
            tvTotal.setText(transaction.getTotal() + " ");
            tvCategory.setText(transaction.getCategory()
                                          .getTitle());
            tvDate.setText(new Date(transaction.getDate()).toString());
        }
    }
}