package com.asia.library_1.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jiayazhou on 2017/2/27 0027.
 */

public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    protected View rootView;

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
        rootView = inflater.inflate(getContentId(), container,false);
        return rootView;
    }
    /**
     * 当Activity初始化之后可以在这里进行一些数据的初始化操作
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initToolBar();
        initView();
        setView();
        setdata();
    }

    //protected abstract void preSetp();
    protected abstract int getContentId();
    protected abstract void initData();
    protected abstract void initToolBar();
    protected abstract void initView();
    protected abstract void setView();
    protected abstract void setdata();

    //find view
    public View findView(View view, @IdRes int viewId){
        return view.findViewById(viewId);
    }
    /*
    * 获取宿主Activity
    */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
