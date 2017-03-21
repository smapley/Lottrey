package com.smapley.lottery.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import com.smapley.base.activity.BaseActivity;
import com.smapley.base.adapter.MyFragmentAdapter;
import com.smapley.lottery.R;
import com.smapley.lottery.fragment.MainFragment;
import com.smapley.lottery.fragment.UserFragment;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.main_viewPager)
    private ViewPager viewPager;

    @ViewInject(R.id.main_navigation)
    private BottomNavigationView navigationView;

    @Override
    public void initArgument() {
        setTitle(R.string.title_home);
    }

    @Override
    public void initView() {
        initViewPager();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
        });

    }

    private void initViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MainFragment());
        fragmentList.add(new UserFragment());
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationView.getMenu().getItem(position).setChecked(true);
                setTitle(position == 0 ? R.string.title_home : R.string.title_user);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
