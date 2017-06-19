package com.sunztech.admin.general_app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jiayazhou on 2017/2/27 0027.
 */

public abstract class BaseFragment extends Fragment {

    public BaseActivity mActivity;

    /**
     * 此方法可以得到上下文对象
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
    }


    /**
     * 返回一个需要展示的View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = initView(inflater, container);
        initFindViewById(view);

        return view;
    }

    /**
     * 当Activity初始化之后可以在这里进行一些数据的初始化操作
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initEvent();
    }

    /**
     * 子类可以复写此方法初始化事件
     */
    protected void initEvent() {

    }


    /**
     * 子类实现此抽象方法返回View进行展示
     *
     * @return
     */
    public abstract View initView(LayoutInflater inflater,ViewGroup container);

    /**
     * 初始化控件
     */
    protected abstract void initFindViewById(View view);

    /**
     * 子类在此方法中实现数据的初始化
     */
    public abstract void initData();

    /*
    * 获取宿主Activity
    */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

}
