package com.smapley.lottery.activity;

import com.smapley.base.activity.BaseActivity;
import com.smapley.lottery.R;
import org.xutils.view.annotation.ContentView;

/**
 * Created by wuzhixiong on 2017/3/20.
 */
@ContentView(R.layout.activity_withdraw)
public class WithdrawActivity extends BaseActivity{


    @Override
    public void initArgument() {
        showBack();
        setTitle(R.string.title_withdraw);
    }

    @Override
    public void initView() {

    }
}
