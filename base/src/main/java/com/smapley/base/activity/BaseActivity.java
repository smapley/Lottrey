package com.smapley.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import org.xutils.x;

/**
 * Created by wuzhixiong on 2017/3/13.
 */

public abstract class BaseActivity extends MyActionBarActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initActionBar();
        initArgument();
        initView();
    }




    public abstract void initArgument();

    public abstract void initView();
}