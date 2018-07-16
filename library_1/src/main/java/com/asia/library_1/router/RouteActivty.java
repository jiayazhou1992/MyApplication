package com.asia.library_1.router;

import android.content.Intent;
import android.os.Bundle;

import com.asia.library_1.R;
import com.asia.library_1.base.BaseActivity;


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
        toFragment();
    }

    /**
     * 跳转目标页面
     * */
    private void toFragment(){
        Intent intent = getIntent();
        int fragment_id = intent.getIntExtra(RouteConfig.FRAGMENT_ID_TIP,0);
        Bundle bundle = intent.getExtras();
        fragmentGo(fragment_id,bundle);
    }
}
