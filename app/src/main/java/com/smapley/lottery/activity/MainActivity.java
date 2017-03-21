package com.smapley.lottery.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import com.smapley.base.activity.BaseActivity;
import com.smapley.base.adapter.MyFragmentPagerAdapter;
import com.smapley.lottery.R;
import com.smapley.lottery.fragment.MainFragment;
import com.smapley.lottery.fragment.UserFragment;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.main_viewPager)
    private ViewPager viewPager;

    @ViewInject(R.id.main_navigation)
    private BottomNavigationView navigationView;

    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private UserFragment userFragment;
    private MyFragmentPagerAdapter viewPagerAdapter;
    private List fragmentList;


    @Override
    public void initArgument() {
        setTitle(R.string.title_home);
    }

    @Override
    public void initView() {
        initViewPager();


    }

    private void initViewPager() {
        fragmentManager = getSupportFragmentManager();
        mainFragment = new MainFragment();
        userFragment = new UserFragment();
        fragmentList=new ArrayList();
        fragmentList.add(mainFragment);
        fragmentList.add(userFragment);
        viewPagerAdapter = new MyFragmentPagerAdapter(fragmentManager,fragmentList);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationView.getMenu().getItem(position).setChecked(true);
                setTitle(position==0? R.string.title_home: R.string.title_user);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Event(value= R.id.main_navigation,type = BottomNavigationView.OnNavigationItemSelectedListener.class)
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                viewPager.setCurrentItem(0);
                return true;
            case R.id.navigation_user:
                viewPager.setCurrentItem(1);
                return true;
        }
        return false;
    }

}
