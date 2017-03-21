package com.smapley.lottery.activity;

import android.widget.ListView;
import com.smapley.base.activity.BaseActivity;
import com.smapley.lottery.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by wuzhixiong on 2017/3/19.
 */
@ContentView(R.layout.activity_plan)
public class PlanActivity extends BaseActivity {

    @ViewInject(R.id.plan_list)
    private ListView listView;

    @Override
    public void initArgument() {
        showBack();
        showTab(R.string.accept, R.string.send);
    }

    @Override
    public void initView() {

    }

    @Override
    public void choseTab(int position) {
        super.choseTab(position);
        System.out.println(position);
    }
}
