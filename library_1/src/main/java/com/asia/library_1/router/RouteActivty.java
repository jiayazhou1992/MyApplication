package com.asia.library_1.router;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.asia.library_1.R;
import com.asia.library_1.base.BaseActivity;
import com.asia.library_1.base.BaseFragment;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class RouteActivty extends BaseActivity {
    @Override
    protected void preSetp() {

    }

    @Override
    protected int getContentId() {
        return R.layout.activity_route;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setdata() {

    }

    public void fragmentGo(int fragmentId){
        fragmentGo(fragmentId,null);
    }
    public void fragmentGo(int fragmentId, Bundle bundle){
        BaseFragment fragment = RouteHelp.getFragment(fragmentId);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_content,fragment,fragmentId+"");
        fragmentTransaction.commit();
    }
    public void fragmentBack(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    }
    public void fragmentHide(){

    }
    public void fragmentShow(){

    }

}
