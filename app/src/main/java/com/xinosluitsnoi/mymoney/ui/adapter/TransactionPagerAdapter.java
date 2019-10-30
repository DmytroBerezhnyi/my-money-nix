package com.xinosluitsnoi.mymoney.ui.adapter;

import android.content.Context;

import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.ui.fragment.BasePagerFragment;
import com.xinosluitsnoi.mymoney.ui.fragment.TransactionListFragment;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

public class TransactionPagerAdapter extends BasePagerAdapter {

    public TransactionPagerAdapter(@NonNull Context context,
                                   @NonNull FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    @NonNull
    @Override
    protected List<BasePagerFragment> getFragmentList() {
        return Arrays.asList(TransactionListFragment.newInstance(Category.Type.Mode.ALL),
                             TransactionListFragment.newInstance(Category.Type.Mode.INCOME),
                             TransactionListFragment.newInstance(Category.Type.Mode.CONSUME));
    }
}