package com.smapley.lottery.fragment;

import android.widget.ListView;
import android.widget.TextView;
import com.smapley.base.fragment.BaseFragment;
import com.smapley.lottery.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by wuzhixiong on 2017/3/19.
 */
@ContentView(R.layout.fragment_chose)
public class ChoseFragment extends BaseFragment {

    @ViewInject(R.id.chose_num)
    private TextView num;
    @ViewInject(R.id.chose_total)
    private TextView total;
    @ViewInject(R.id.chose_balance)
    private TextView balance;
    @ViewInject(R.id.chose_tools)
    private TextView tools;
    @ViewInject(R.id.chose_list)
    private ListView listView;

    @Override
    public void initArgument() {

    }

    @Override
    public void initView() {

    }
}
