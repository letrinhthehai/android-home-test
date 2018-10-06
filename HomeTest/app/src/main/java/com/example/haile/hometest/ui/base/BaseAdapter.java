package com.example.haile.hometest.ui.base;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, D extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<D> {

    protected List<T> mItems;

    public BaseAdapter() {
        mItems = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItems(List<T> items) {
        if (items != null) {
            mItems.addAll(items);
            notifyDataSetChanged();
        }
    }

    public void updateItems(List<T> items) {
        if (items != null) {
            mItems.clear();
        }
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(T t) {
        mItems.add(t);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        if (mItems.size() > position) {
            mItems.remove(position);
            notifyDataSetChanged();
        }
    }

    public T getItemAtPosition(int position) {
        if (mItems.size() > position) {
            return mItems.get(position);
        }
        return null;
    }

    public void clearAllItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        if (!mItems.isEmpty()) {
            return mItems;
        } else {
            return null;
        }
    }

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        protected Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
        }

        protected void setData(T t, int position) {

        }
    }
}