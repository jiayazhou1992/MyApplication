package com.sunztech.admin.general_app.widget.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Administrator on 2016/8/3.
 */
public class RecyclayerViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;
    private View mConvertView;

    public RecyclayerViewHolder(View itemView) {
        super(itemView);
        mViews=new SparseArray<View>();
        mConvertView=itemView;
    }

    public static RecyclayerViewHolder get(Context context,ViewGroup parent, int mItemLayoutId,int viewType){
        View view= LayoutInflater.from(context).inflate(mItemLayoutId,parent,false);
        RecyclayerViewHolder recyclayerViewHolder=new RecyclayerViewHolder(view);
        return recyclayerViewHolder;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * ΪTextView�����ַ�
     *
     * @param viewId
     * @param text
     * @return
     */
    public RecyclayerViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * ΪImageView����ͼƬ
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public RecyclayerViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * ΪImageView����ͼƬ
     *
     * @param viewId
     *
     * @return
     */
    public RecyclayerViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * ΪImageView����ͼƬ
     *
     * @param viewId
     *
     * @return
     */
    public RecyclayerViewHolder setImageByUrl(int viewId, String url) {
        //x.image().bind((ImageView)getView(viewId),url );
        return this;
    }

    public View getmConvertView(){
        return mConvertView;
    }

}
