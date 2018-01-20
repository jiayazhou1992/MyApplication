package com.sunztech.admin.general_app.widget.refreshload;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

/**
 * Created by jiayazhou on 2017/11/9.
 */

public class RefreshFootImpl implements RefreshFoot {

    private Context context;
    private Animatable animatable;
    private ImageView imageView;
    private boolean isBottleneck = false;
    private boolean isLive = false;

    public RefreshFootImpl(Context context) {
        this.context=context;
        imageView=new ImageView(context);
        imageView.setImageResource(R.drawable.refresh_vetor);
        animatable= (Animatable) imageView.getDrawable();
    }

    @Override
    public View getFoot() {
        return imageView;
    }

    @Override
    public int getHight() {
        return imageView.getMeasuredHeight();
    }

    @Override
    public int getWidth() {
        return imageView.getMeasuredWidth();
    }

    @Override
    public void load() {
        animatable.start();
    }

    @Override
    public void loadComplete() {
        isLive=false;
        isBottleneck=false;
        ObjectAnimator.ofFloat(imageView,"TranslationY",ViewCompat.getTranslationY(imageView),0).start();
        //animatable.stop();
    }

    @Override
    public void scrollLisenter(int dy) {

    }

    @Override
    public int pullUp(int dy) {
        isLive=true;
        float ty= ViewCompat.getTranslationY(imageView);
        if (ty-dy<=-getHight()) {
            ViewCompat.setTranslationY(imageView, -getHight());
            isBottleneck=true;
            return (int) (ty+getHight());
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
        return 0;
    }
}
