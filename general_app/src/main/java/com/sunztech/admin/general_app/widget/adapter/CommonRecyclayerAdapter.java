package com.sunztech.admin.general_app.widget.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunztech.admin.general_app.utils.utils1.LogUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public abstract class CommonRecyclayerAdapter<T> extends RecyclerView.Adapter<RecyclayerViewHolder> {

    private String TAG="CommonRecyclayerAdapter";
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonRecyclayerAdapter(Context context, List<T> mDatas, int itemLayoutId){

        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RecyclayerViewHolder.get(mContext,parent,mItemLayoutId,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclayerViewHolder holder, final int position) {
        convert(holder,getItem(position));
        holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onItemClick(view,CommonRecyclayerAdapter.this.getItem(position),position);

                Log.i(TAG,"onitemclick");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }
    public T getItem(int position){
        return mDatas==null?null:mDatas.get(position);
    }

    public abstract void convert(RecyclayerViewHolder holder, T item);
    public abstract void onItemClick(View view,T item,int position);

    private RecyclayerViewHolder getViewHolder( ViewGroup parent,int viewType) {

        return RecyclayerViewHolder.get(mContext, parent, mItemLayoutId, viewType);

    }
}
