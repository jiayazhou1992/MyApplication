package com.sunztech.admin.general_app.widget.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private final SparseArray<View> mViews;  
    private static int mPosition;
    private View mConvertView;  
  
    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;  
        this.mViews = new SparseArray<View>();  
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        // setTag  
        mConvertView.setTag(this);  
    }  
  
    /** 
     * �õ�һ��ViewHolder���� 
     *  
     * @param context 
     * @param convertView 
     * @param parent 
     * @param layoutId 
     * @param position 
     * @return 
     */  
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        mPosition=position;
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);  
        }  
        return (ViewHolder) convertView.getTag();  
    }  
  
    public View getConvertView()  
    {  
        return mConvertView;  
    }  
  
    /** 
     * ͨ��ؼ���Id��ȡ���ڵĿؼ������û�������views 
     *  
     * @param viewId 
     * @return 
     */  
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
    public ViewHolder setText(int viewId, String text) {
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
    public ViewHolder setImageResource(int viewId, int drawableId) {
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
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
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
    public ViewHolder setImageByUrl(int viewId, String url) {
        //x.image().bind((ImageView)getView(viewId),url );
        return this;  
    }  
  
    public int getPosition()  
    {  
        return mPosition;  
    }  
  
}  