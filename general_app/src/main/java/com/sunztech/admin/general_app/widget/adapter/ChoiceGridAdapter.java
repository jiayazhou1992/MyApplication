package com.sunztech.admin.general_app.widget.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by jiayazhou on 2017/12/27.
 */

public class ChoiceGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerView recyclerView;

    public ChoiceGridAdapter(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
