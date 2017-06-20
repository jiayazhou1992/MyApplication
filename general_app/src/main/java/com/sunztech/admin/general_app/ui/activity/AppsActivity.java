package com.sunztech.admin.general_app.ui.activity;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.base.BaseActivity;
import com.sunztech.admin.general_app.base.BaseFragment;
import com.sunztech.admin.general_app.ui.fragment.ChildFragment;
import com.sunztech.admin.general_app.ui.fragment.HomeFragment;
import com.sunztech.admin.general_app.ui.fragment.ShopFragment;

public class AppsActivity extends BaseActivity implements HomeFragment.OnFragmentInteractionListener{

    private CoordinatorLayout coordinatorLayout;
    private RadioGroup tabs_b;
    private BaseFragment shopFragment;
    private FragmentTransaction transaction;

    @Override
    protected int getContentView() {
        return R.layout.activity_apps;
    }

    @Override
    protected void initToolBar() {
        super.initToolBar();

    }

    @Override
    protected void initFindViewById() {
        super.initFindViewById();
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.apps_coordinatorlayout);
        //coordinatorLayout.setStatusBarBackgroundResource(R.color.colorPrimary);
        tabs_b= (RadioGroup) findViewById(R.id.tabs);

    }

    @Override
    protected void initView() {
        tabs_b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radio1:
                        if (shopFragment==null)
                            shopFragment= ShopFragment.newInstance(null,null);
                        addFragment(shopFragment);
                        break;
                    case R.id.radio2:

                        break;
                    case R.id.radio3:

                        break;
                    case R.id.radio4:

                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void addFragment(BaseFragment baseFragment){
        if (transaction==null) transaction=getSupportFragmentManager().beginTransaction();
        if (!baseFragment.isAdded()) {
            transaction.add(R.id.fragment_content, baseFragment);
            transaction.commit();
        }
    }
}
