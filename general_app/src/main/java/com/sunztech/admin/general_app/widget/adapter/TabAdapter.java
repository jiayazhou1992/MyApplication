package com.sunztech.admin.general_app.widget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sunztech.admin.general_app.ui.fragment.ChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiayazhou on 2017/6/14 0014.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private List<String> titls=new ArrayList<>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
        titls.add("tab1");
        titls.add("tab2");
        titls.add("tab3");
        titls.add("tab4");
        titls.add("tab5");
    }

    @Override
    public Fragment getItem(int position) {
        return ChildFragment.newInstance(null,null);
    }

    @Override
    public int getCount() {
        return titls.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titls.get(position);
    }
}
