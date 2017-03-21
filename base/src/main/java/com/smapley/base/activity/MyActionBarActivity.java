package com.smapley.base.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.smapley.base.R;

/**
 * Created by wuzhixiong on 2017/3/19.
 */

public class MyActionBarActivity extends AppCompatActivity {

    private TextView tab1 ;
    private TextView tab2 ;

    protected void initActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
    }

    public void setTitle(int title){
        View actionBar = getSupportActionBar().getCustomView();
        TextView titleView = (TextView) actionBar.findViewById(R.id.title);
        titleView.setText(getResources().getString(title));
    }



    public void showBack(){
        View actionBar = getSupportActionBar().getCustomView();
        View back = actionBar.findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showConfirm(){
        View actionBar = getSupportActionBar().getCustomView();
        View confirm = actionBar.findViewById(R.id.confirm);
        confirm.setVisibility(View.VISIBLE);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onConfirm(v);
            }
        });
    }

    public void onConfirm(View view){

    }


    public void showTab(int name1,int name2){
        View actionBar = getSupportActionBar().getCustomView();
        View tab = actionBar.findViewById(R.id.tab);
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

    public void choseTab(int position){
        if(position==0){
            tab1.setBackgroundResource(R.mipmap.tab_label_a_pre);
            tab1.setTextColor(getResources().getColor(R.color.white));
            tab2.setBackgroundResource(R.mipmap.tab_label_b_nor);
            tab2.setTextColor(getResources().getColor(R.color.blue4));
        }else{
            tab1.setBackgroundResource(R.mipmap.tab_label_a_nor);
            tab1.setTextColor(getResources().getColor(R.color.blue4));
            tab2.setBackgroundResource(R.mipmap.tab_label_b_pre);
            tab2.setTextColor(getResources().getColor(R.color.white));
        }
    }
}
