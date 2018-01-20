package com.sunztech.admin.general_app.widget.refreshload;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

/**
 * Created by jiayazhou on 2017/11/9.
 */

public class RefreshHeadImpl implements RefreshHead {
    private static final int CIRCLE_BG_LIGHT = 0xFFFAFAFA;
    private Context context;
    private Animatable animatable;
    private CircleImageView imageView;
    private boolean isBottleneck = false;
    private boolean isLive = false;

    public RefreshHeadImpl(Context context) {
        this.context=context;
        imageView=new CircleImageView(context,CIRCLE_BG_LIGHT);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(context.getResources().getDimensionPixelOffset(R.dimen.dim100),context.getResources().getDimensionPixelSize(R.dimen.dim100));
        imageView.setLayoutParams(layoutParams);
        MaterialProgressDrawable progressDrawable = new MaterialProgressDrawable(context,imageView);
        progressDrawable.updateSizes(MaterialProgressDrawable.LARGE);
        progressDrawable.showArrow(true);
        progressDrawable.setBackgroundColor(CIRCLE_BG_LIGHT);
        progressDrawable.setAlpha(255);
        progressDrawable.setStartEndTrim(0f, 0.8f);
        progressDrawable.setArrowScale(1f); //0~1之间
        progressDrawable.setProgressRotation(1);
        imageView.setImageDrawable(progressDrawable);
        animatable = progressDrawable;
    }

    @Override
    public View getHead() {
        return imageView;
    }

    @Override
    public int getHight() {
        Log.i("headhight",""+imageView.getMeasuredHeight());
        return imageView.getMeasuredHeight();
    }

    @Override
    public int getWidth() {
        //Log.i("headwidth",""+imageView.getMeasuredWidth());
        return imageView.getMeasuredWidth();
    }

    @Override
    public void refresh() {
        animatable.start();
    }

    @Override
    public void refreshComplete() {
        isLive=false;
        isBottleneck=false;
        ObjectAnimator.ofFloat(imageView,"TranslationY",ViewCompat.getTranslationY(imageView),0).start();
        animatable.stop();
    }

    @Override
    public void scrollLisenter(int dy) {

    }

    @Override
    public int pullDown(int dy) {
        Log.i("pullDown--",""+dy);
        isLive=true;
        float ty=ViewCompat.getTranslationY(imageView);
        if (ty-dy>=getHight()) {
            ViewCompat.setTranslationY(imageView, getHight());
            isBottleneck=true;
            return (int) (ty-getHight());
        }
        else {
            ViewCompat.setTranslationY(imageView, ViewCompat.getTranslationY(imageView) - dy);
            isBottleneck=false;
            return dy;
        }
    }

    @Override
    public boolean isBottleneck() {
        return isBottleneck;
    }

    @Override
    public boolean isLive() {
        return isLive;
    }

    @Override
    public int getFixType() {
        return 1;
    }
}
