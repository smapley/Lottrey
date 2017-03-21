package com.smapley.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wuzhixiong on 2017/3/18.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;


    public MyFragmentPagerAdapter(FragmentManager fragmentManager, List fragmentList){
        super(fragmentManager);
        this.fragmentList= fragmentList;
    }

    public void setFragmentList(List fragmentList){
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    public void addItem(Fragment fragment){
        this.fragmentList.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
