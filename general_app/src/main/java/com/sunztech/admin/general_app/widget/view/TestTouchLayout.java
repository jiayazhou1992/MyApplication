package com.sunztech.admin.general_app.widget.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by jiayazhou on 2018/1/4.
 */

public class TestTouchLayout extends RelativeLayout {
    public TestTouchLayout(Context context) {
        super(context);
    }

    public TestTouchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestTouchLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TestTouchLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        View view = getChildAt(0);
        Rect rect=new Rect();
        view.getHitRect(rect);
        if (ev.getRawX()<=rect.right&&ev.getRawX()>=rect.left&&ev.getRawY()<=rect.bottom&&ev.getRawY()>=rect.top){
            Log.i("onInterceptTouchEvent","----------------------onInterceptTouchEvent");
            return super.onInterceptTouchEvent(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }
}
