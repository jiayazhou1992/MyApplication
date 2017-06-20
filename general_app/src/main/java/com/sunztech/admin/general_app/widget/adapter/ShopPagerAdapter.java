package com.sunztech.admin.general_app.widget.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.utils.utils1.ScreenUtils;


/**
 * Created by jiayazhou on 2017/6/19 0019.
 */

public class ShopPagerAdapter extends LoopPagerAdapter {

    private int[] imgs={R.mipmap.ic_launcher
            ,R.mipmap.ic_launcher
            ,R.mipmap.ic_launcher
            ,R.mipmap.ic_launcher};

    public ShopPagerAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView=new ImageView(container.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ScreenUtils.dpToPxInt(container.getContext(),100),ScreenUtils.dpToPxInt(container.getContext(),100)));
        imageView.setBackgroundResource(R.color.colorPrimary);
        imageView.setImageResource(imgs[position]);
        return imageView;
    }

    @Override
    public int getRealCount() {
        return imgs.length;
    }

}
