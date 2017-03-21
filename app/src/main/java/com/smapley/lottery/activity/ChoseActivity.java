package com.smapley.lottery.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.smapley.base.activity.BaseActivity;
import com.smapley.base.adapter.MyFragmentAdapter;
import com.smapley.lottery.R;
import com.smapley.lottery.fragment.ChoseFragment;
import com.smapley.lottery.utils.KeyboardUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smapley on 2017/3/19.
 * 选号
 */
@ContentView(R.layout.activity_chose)
public class ChoseActivity extends BaseActivity {

    @ViewInject(R.id.edit1)
    private EditText edit1;
    @ViewInject(R.id.edit2)
    private EditText edit2;

    @ViewInject(R.id.chose_tabLayout)
    private TabLayout tabLayout;
    @ViewInject(R.id.chose_viewPager)
    private ViewPager viewPager;
    private KeyboardUtil keyboardUtil;

    @Override
    public void initArgument() {
        showBack();
        showConfirm();
        setTitle(R.string.title_chose);
    }

    @Override
    public void onConfirm(View view) {
        startActivity(new Intent(ChoseActivity.this,SharePlanActivity.class));
    }

    @Override
    public void initView() {
        initTab();
        keyboardUtil = new KeyboardUtil(this);

        edit1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                keyboardUtil.setEditText((EditText) view).show();
                return false;
            }
        });
        edit2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                keyboardUtil.setEditText((EditText) view).show();
                return false;
            }
        });


    }

    private void initTab() {
        List<String> titles= new ArrayList<>();
        titles.add(getString(R.string.chose_menu_item1));
        titles.add(getString(R.string.chose_menu_item2));
        titles.add(getString(R.string.chose_menu_item3));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ChoseFragment());
        fragments.add(new ChoseFragment());
        fragments.add(new ChoseFragment());
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments,titles));

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.gray5), ContextCompat.getColor(this, R.color.red5));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red5));
        ViewCompat.setElevation(tabLayout, 10);
        tabLayout.setupWithViewPager(viewPager);
    }


  


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (keyboardUtil != null && keyboardUtil.isShow) {
                keyboardUtil.hide();
            } else {
                finish();
            }
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }
}