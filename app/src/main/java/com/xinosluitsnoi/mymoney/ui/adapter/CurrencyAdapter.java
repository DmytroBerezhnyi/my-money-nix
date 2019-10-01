package com.xinosluitsnoi.mymoney.ui.adapter;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.xinosluitsnoi.mymoney.R;
import com.xinosluitsnoi.mymoney.domain.entity.Currency;
import com.xinosluitsnoi.mymoney.mvp.contract.SettingsCurrencyContract;

import java.util.List;

import androidx.annotation.NonNull;

public class CurrencyAdapter extends BaseRecyclerAdapter<Currency> {

    @NonNull
    private final SettingsCurrencyContract.View activity;

    private int lastSelectedPosition;

    public CurrencyAdapter(@NonNull SettingsCurrencyContract.View activity) {
        this.activity = activity;
    }

    public void swabData(@NonNull List<Currency> list, int lastSelectedPosition) {
        super.swabData(list);
        this.lastSelectedPosition = lastSelectedPosition;
    }

    public void setCurrencyIndex(int currencyIndex) {
        this.lastSelectedPosition = currencyIndex;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    protected BaseViewHolder<Currency> createHolder(@NonNull View view) {
        return new CurrencyHolder(view);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_currency;
    }

    private class CurrencyHolder extends BaseViewHolder<Currency> {

        @NonNull
        private final TextView title;

        @NonNull
        private final RadioButton radioButton;

        CurrencyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_currency_title);
            radioButton = itemView.findViewById(R.id.rb_currency);
        }

        @Override
        void bind(@NonNull Currency currency) {
            title.setText(currency.getTitle());
            radioButton.setChecked(lastSelectedPosition == getAdapterPosition());

            itemView.setOnClickListener(v -> activity.showSelectedCurrency(getAdapterPosition()));
        }
    }
}