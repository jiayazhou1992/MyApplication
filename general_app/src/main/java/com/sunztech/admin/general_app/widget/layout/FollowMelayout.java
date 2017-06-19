package com.sunztech.admin.general_app.widget.layout;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sunztech.admin.general_app.utils.utils1.ScreenUtils;


/**
 * Created by jiayazhou on 2017/1/5 0005.
 */

public class FollowMelayout extends LinearLayout{

    private float downY;
    private float lastY;
    private float pullDownY;
    private float pullUpY;

    private int maxY=450;//dp
    private int minY=120;//dp

    public FollowMelayout(Context context) {
        super(context);
    }

    public FollowMelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FollowMelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FollowMelayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("followlayout","onmeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("followlayout", "onLayout");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action= MotionEventCompat.getActionMasked(event);

        switch (action){
            case MotionEvent.ACTION_DOWN:

                downY=event.getY();
                lastY=downY;
                break;

            case MotionEvent.ACTION_MOVE:
                pullDownY=event.getY()-lastY;
                pullUpY=lastY-event.getY();
                if (pullDownY>0&&getHeight()>= ScreenUtils.dpToPx(getContext(),120)){
                    /*ViewGroup.LayoutParams params=getLayoutParams();
                    params.height=params.height-(int) pullDownY;
                    setLayoutParams(params);*/
                    layout(getLeft(),getTop()+(int)pullDownY,getRight(),getBottom());

                }
                if (pullUpY>0&&getHeight()<=ScreenUtils.dpToPx(getContext(),350)){
                    /*ViewGroup.LayoutParams params=getLayoutParams();
                    params.height=params.height+(int) pullUpY;
                    setLayoutParams(params);*/
                    layout(getLeft(),getTop()-(int)pullUpY,getRight(),getBottom());

                }
                lastY=event.getY();
                break;

            case MotionEventCompat.ACTION_POINTER_DOWN:

                break;

            case MotionEventCompat.ACTION_POINTER_UP:

                break;

            case MotionEvent.ACTION_UP:
                Log.e("height",getHeight()+"");
                break;

            case MotionEvent.ACTION_CANCEL:

                break;
        }



        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action= MotionEventCompat.getActionMasked(ev);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downY=ev.getY();
                lastY=downY;
                Log.e("follow","down");
                break;

            case MotionEvent.ACTION_MOVE:
                pullDownY=ev.getY()-lastY;
                pullUpY=lastY-ev.getY();
                if (pullDownY>0&&getHeight()>= ScreenUtils.dpToPx(getContext(),120)){
                    return true;
                }
                if (pullUpY>0&&getHeight()<=ScreenUtils.dpToPx(getContext(),450)){
                    return true;
                }
                lastY=ev.getY();
                break;

            case MotionEventCompat.ACTION_POINTER_DOWN:

                break;

            case MotionEventCompat.ACTION_POINTER_UP:

                break;

            case MotionEvent.ACTION_UP:

                break;

            case MotionEvent.ACTION_CANCEL:

                break;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
