package com.xinosluitsnoi.mymoney.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerAdapter<T>
        extends RecyclerView.Adapter<BaseViewHolder<T>> {

    @NonNull
    private final List<T> list = new ArrayList<>();

    public void swabData(@NonNull List<T> list) {
        this.list.clear();
        this.list.addAll(list);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(getLayoutRes(), parent, false);

        return createHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        T t = list.get(position);

        holder.bind(t);
    }

    @NonNull
    public List<T> getList() {
        return list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    protected abstract BaseViewHolder<T> createHolder(View view);

    @LayoutRes
    protected abstract int getLayoutRes();
}