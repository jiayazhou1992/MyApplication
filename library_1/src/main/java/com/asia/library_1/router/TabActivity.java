package com.asia.library_1.router;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.asia.library_1.base.BaseActivity;
import com.asia.library_1.base.BaseFragment;

/**
 * Created by 11845 on 2018/6/18 0018.
 */

public abstract class TabActivity extends BaseActivity{

    private static final String TAG = "TabActivity";

    public void fragmentShow(int fragmentId, Bundle bundle) {
        Log.i(TAG,">>>>>fragment显示");
        fragmentGo(fragmentId,bundle);

        if (fragment_ids[0]!=0){
            fragmentHide(fragment_ids[0]);
        }
    }

    public void fragmentHide(int fragmentId) {
        Log.i(TAG,">>>>>fragment隐藏");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BaseFragment fragment = null;
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentId+"");

        if (fragment.isAdded()&&!fragment.isHidden()){
            fragmentTransaction.hide(fragment);
            fragmentTransaction.commit();
            Log.i(TAG,">>>>>fragment隐藏完成");
        }
    }
}
