package com.smapley.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wuzhixiong on 2017/3/19.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {

    private List<String> titles;
    private List<Fragment> fragments;


    public TabLayoutAdapter(FragmentManager fragmentManager, List titles, List fragments) {
        super(fragmentManager);
        this.titles=titles;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
