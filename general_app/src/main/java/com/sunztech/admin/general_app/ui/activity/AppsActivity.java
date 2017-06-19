package com.sunztech.admin.general_app.ui.activity;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.base.BaseActivity;
import com.sunztech.admin.general_app.ui.fragment.ChildFragment;
import com.sunztech.admin.general_app.ui.fragment.HomeFragment;

public class AppsActivity extends BaseActivity implements HomeFragment.OnFragmentInteractionListener{

    private Toolbar toolbar;
    private RadioGroup tabs_b;

    @Override
    protected int getContentView() {
        return R.layout.activity_apps;
    }

    @Override
    protected void initToolBar() {
        super.initToolBar();
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initFindViewById() {
        super.initFindViewById();
        tabs_b= (RadioGroup) findViewById(R.id.tabs);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
