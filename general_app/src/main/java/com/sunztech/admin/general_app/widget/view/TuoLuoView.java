package com.sunztech.admin.general_app.widget.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.sunztech.admin.general_app.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */

public class TuoLuoView extends SurfaceView {

    public TuoLuoView(Context context) {
        super(context);
        init();
    }

    public TuoLuoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TuoLuoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TuoLuoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private Paint paint;
    private RectF rectF;
    private Bitmap bitmap;

    private void init(){
        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        rectF=new RectF();
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.tuoluo);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w=getWidth();
        int h=getHeight();

        rectF.set(w/3,h/5,w-w/3,h-h/5);
        canvas.drawRoundRect(rectF,(w/2-w/3),(w/2-w/3),paint);
    }

    private void rotating(Canvas canvas){
        int w=getWidth();
        int h=getHeight();

        rectF.set(w/3,h/5,w-w/3,h-h/5);
        canvas.drawRoundRect(rectF,(w/2-w/3),(w/2-w/3),paint);
    }
}
