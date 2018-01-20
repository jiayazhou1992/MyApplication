package com.sunztech.admin.general_app.widget.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jiayazhou on 2018/1/4.
 */

public class TestTouchView extends View {
    private String tag = "";

    public TestTouchView(Context context) {
        super(context);
    }

    public TestTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TestTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("onTouchEvent","------------"+tag);
        if (tag.equals("view2")){
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
