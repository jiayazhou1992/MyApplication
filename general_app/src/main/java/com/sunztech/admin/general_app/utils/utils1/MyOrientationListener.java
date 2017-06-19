package com.sunztech.admin.general_app.utils.utils1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by admin on 2017/1/6.
 */


public class MyOrientationListener implements SensorEventListener
{
    private SensorManager mSensorManager;
    private Context mContext;
    //传感器
    private Sensor mSensor;
    private float lastX;

    //构造方法
    public MyOrientationListener(Context context)
    {
        this.mContext = context;
    }

    @SuppressWarnings("deprecation")
    //开始监听
    public void start()
    {
        //拿到系统服务
        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager != null)
        {
            // 获得方向传感器
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        }

        if (mSensor != null)
        {
            mSensorManager.registerListener(this, mSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }
    }

    //结束监听
    public void stop()
    {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1)
    {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings(
            { "deprecation" })
    @Override
    //方向发生变化
    public void onSensorChanged(SensorEvent event)
    {
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION)
        {
            float x = event.values[SensorManager.DATA_X];

            if (Math.abs(x - lastX) > 1.0)
            {
                if (mOnOrientationListener != null)
                {
                    mOnOrientationListener.onOrientationChanged(x);
                }
            }

            lastX = x;

        }
    }

    private OnOrientationListener mOnOrientationListener;

    public void setOnOrientationListener(
            OnOrientationListener mOnOrientationListener)
    {
        this.mOnOrientationListener = mOnOrientationListener;
    }

    public interface OnOrientationListener
    {
        void onOrientationChanged(float x);
    }

}
