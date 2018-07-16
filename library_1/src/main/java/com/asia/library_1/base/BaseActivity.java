package com.asia.library_1.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.asia.library_1.R;
import com.asia.library_1.router.RouteActivty;
import com.asia.library_1.router.RouteConfig;
import com.asia.library_1.router.TabActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Created by jiayazhou on 2017/2/27 0027.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected static final String ACTION_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    /**
     * 记录处于前台的Activity
     */
    protected static BaseActivity mForegroundActivity = null;
    /**
     * 记录所有活动的Activity
     */
    protected static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    /**
     * 记录最近两个fragment id
     * */
    protected static int[] fragment_ids = new int[2];

    /**
     * 广播
     * */
    static final BroadcastReceiver receiver = new BroadcastReceiver() {
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
        preSetp();
        setContentView(getContentId());
        mActivities.add(this);

        initData();
        initToolBar();
        initView();
        setView();
        setdata();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract void preSetp();
    protected abstract int getContentId();
    protected abstract void initData();
    protected abstract void initToolBar();
    protected abstract void initView();
    protected abstract void setView();
    protected abstract void setdata();
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
     * 退出应用
     */
    public void exitApp() {
        finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
    }


    /*----------------------页面跳转--------------------------*/

    public void fragmentGo(int fragmentId) {
        fragmentGo(fragmentId, null);
    }

    public void fragmentGo(int fragmentId, Bundle bundle) {

        fragment_ids[0] = fragment_ids[1];
        fragment_ids[1] = fragmentId;

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BaseFragment fragment = null;
            fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentId+"");

            if (fragment == null) {
                Class aClass = Class.forName(this.getPackageName() + ".router.RouteHelp");
                Method method = aClass.getMethod("getFragment", int.class);
                fragment = (BaseFragment) method.invoke(aClass.newInstance(), fragmentId);
            }

            if (this instanceof RouteActivty){

                fragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fragment_content, fragment, fragmentId + "");
                fragmentTransaction.commit();

            }else if (this instanceof TabActivity){

                if (fragment.isAdded()){
                    //fragment.setArguments(bundle);
                    fragmentTransaction.show(fragment);
                    fragmentTransaction.commit();
                }else {
                    fragment.setArguments(bundle);
                    fragmentTransaction.add(R.id.fragment_content, fragment, fragmentId + "");
                    fragmentTransaction.commit();
                }

            }else {

                Intent intent = new Intent();
                intent.setClass(this,RouteActivty.class);
                intent.putExtra(RouteConfig.FRAGMENT_ID_TIP,fragmentId);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void fragmentBack() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

}
