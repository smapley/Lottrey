package com.smapley.base.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.smapley.base.R;

/**
 * Created by wuzhixiong on 2017/3/19.
 * 标题栏
 */

public class MyActionBarActivity extends AppCompatActivity {

    private TextView tab1;
    private TextView tab2;

    void initActionBar() throws NullPointerException{
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        final ViewGroup nullParent = null;
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, nullParent);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(mActionBarView, lp);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    public void setTitle(int title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            TextView titleView = (TextView) actionBar.getCustomView().findViewById(R.id.title);
            titleView.setText(getResources().getString(title));
        }
    }


    protected void showBack() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            View back = actionBar.getCustomView().findViewById(R.id.back);
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    protected void showConfirm() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            View confirm = actionBar.getCustomView().findViewById(R.id.confirm);
            confirm.setVisibility(View.VISIBLE);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onConfirm(v);
                }
            });
        }
    }

    protected void onConfirm(View view) {

    }


    protected void showTab(int name1, int name2) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            View tab = actionBar.getCustomView().findViewById(R.id.tab);
            tab.setVisibility(View.VISIBLE);
            tab1 = (TextView) tab.findViewById(R.id.tab1);
            tab2 = (TextView) tab.findViewById(R.id.tab2);
            tab1.setText(getString(name1));
            tab2.setText(getString(name2));
            tab1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choseTab(0);
                }
            });
            tab2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choseTab(1);
                }
            });
        }
    }

    protected void choseTab(int position) {
        if (position == 0) {
            tab1.setBackgroundResource(R.mipmap.tab_label_a_pre);
            tab1.setTextColor(ContextCompat.getColor(this,R.color.white));
            tab2.setBackgroundResource(R.mipmap.tab_label_b_nor);
            tab2.setTextColor(ContextCompat.getColor(this,R.color.blue4));
        } else {
            tab1.setBackgroundResource(R.mipmap.tab_label_a_nor);
            tab1.setTextColor(ContextCompat.getColor(this,R.color.blue4));
            tab2.setBackgroundResource(R.mipmap.tab_label_b_pre);
            tab2.setTextColor(ContextCompat.getColor(this,R.color.white));
        }
    }
}
