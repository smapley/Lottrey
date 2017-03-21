package com.smapley.lottery.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.smapley.base.activity.BaseActivity;
import com.smapley.lottery.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by wuzhixiong on 2017/3/19.
 */
@ContentView(R.layout.activity_shareplan)
public class SharePlanActivity extends BaseActivity{

    @ViewInject(R.id.share_num)
    private EditText num;
    @ViewInject(R.id.share_account)
    private EditText account;
    @ViewInject(R.id.share_send)
    private Button send;
    @ViewInject(R.id.share_list)
    private ListView listView;

    @Override
    public void initArgument() {
        setTitle(R.string.title_shareplan);
        showBack();
    }

    @Override
    public void initView() {

    }
}
