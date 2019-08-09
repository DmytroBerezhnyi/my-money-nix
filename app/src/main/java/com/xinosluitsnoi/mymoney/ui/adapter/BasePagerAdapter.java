package com.xinosluitsnoi.mymoney.ui.adapter;

import android.content.Context;
import android.content.res.Resources;

import com.xinosluitsnoi.mymoney.ui.fragment.BasePagerFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public abstract class BasePagerAdapter extends FragmentPagerAdapter {

    @NonNull
    private final Resources resources;

    @NonNull
    private final List<BasePagerFragment> basePagerFragmentList = getFragmentList();

    public BasePagerAdapter(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        super(fragmentManager);

        this.resources = context.getResources();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        BasePagerFragment fragment =  basePagerFragmentList.get(position);
        CharSequence title = resources.getString(fragment.getToolbarTitleResource());

        return title;
    }

    @Override
    public Fragment getItem(int position) {
        return basePagerFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return basePagerFragmentList.size();
    }

    @NonNull
    protected abstract List<BasePagerFragment> getFragmentList();
}