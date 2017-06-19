package com.sunztech.admin.general_app.ui.activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.base.BaseActivity;
import com.sunztech.admin.general_app.ui.fragment.HomeFragment;
import com.sunztech.admin.general_app.widget.adapter.TabAdapter;

public class HomeActivity extends BaseActivity implements HomeFragment.OnFragmentInteractionListener{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private FragmentTabHost tabHost;
    private ViewPager viewPager;

    private TabAdapter tabAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
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
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        tabHost= (FragmentTabHost) findViewById(R.id.tabhost);
        //View view=View.inflate(this,R.layout.content_main,null);
        viewPager= (ViewPager) findViewById(R.id.content_viewPager);
    }

    @Override
    protected void initView() {

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        tabAdapter=new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabHost.setup(this,getSupportFragmentManager(),R.id.fragment_content);
        for(int i=0;i<4;i++){
            TabHost.TabSpec tabSpec=tabHost.newTabSpec("Tab"+i).setIndicator(getTabView());
            tabHost.addTab(tabSpec, HomeFragment.class,null);
        }
    }

    @Override
    protected void initData() {

    }

    private View getTabView(){
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        return imageView;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
