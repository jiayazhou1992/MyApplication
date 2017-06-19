package com.sunztech.admin.general_app.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiayazhou on 2017/2/27 0027.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String ACTION_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    /**
     * 记录处于前台的Activity
     */
    private static BaseActivity mForegroundActivity = null;
    /**
     * 记录所有活动的Activity
     */
    private static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 处理各种情况
            String action = intent.getAction();
            if (ACTION_NETWORK_CHANGE.equals(action)) { // 网络发生变化
                // 处理网络问题
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        mActivities.add(this);

        /*// create our manager instance after the content view is set
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        //tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(this.getResources().getColor(R.color.colorPrimary));
        Log.e("baseactivity","oncreate");*/


        initData();
        initToolBar();
        initFindViewById();
        initEvent();
        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mForegroundActivity=this;
    }

    @Override
    protected void onResume() {
        mForegroundActivity = this;
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_NETWORK_CHANGE);

        registerReceiver(receiver, filter);

    }

    @Override
    protected void onPause() {
        mForegroundActivity = null;
        super.onPause();
        unregisterReceiver(receiver);
    }

    protected void initFindViewById() {}

    protected void initEvent() {}

    protected abstract int getContentView();

    abstract protected void initView();

    abstract protected void initData();

    protected void initToolBar() {}


    /**
     * 关闭所有Activity
     */
    public static void finishAll() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
    }

    /**
     * 关闭所有Activity，除了参数传递的Activity
     */
    public static void finishAll(BaseActivity except) {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            if (activity != except)
                activity.finish();
        }
    }

    /**
     * 是否有启动的Activity
     */
    public static boolean hasActivity() {
        return mActivities.size() > 0;
    }

    /**
     * 获取当前处于前台的activity
     */
    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    /**
     * 获取当前处于栈顶的activity，无论其是否处于前台
     */
    public static BaseActivity getCurrentActivity() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        if (copy.size() > 0) {
            return copy.get(copy.size() - 1);
        }
        return null;
    }

    /**
     * 107.     * 退出应用
     * 108.
     */
    public void exitApp() {
        finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 107.     * 提示
     * 108.
     */

    protected void toast(String mess){
        Toast.makeText(this,mess,Toast.LENGTH_SHORT).show();
    }

}
