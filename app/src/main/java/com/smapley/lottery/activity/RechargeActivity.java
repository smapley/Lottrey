package com.smapley.lottery.activity;

import android.view.View;
import android.widget.TextView;
import com.smapley.base.activity.BaseActivity;
import com.smapley.lottery.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 2017/3/19.
 * 充值
 */
@ContentView(R.layout.activity_recharge)
public class RechargeActivity extends BaseActivity {

    @ViewInject(R.id.charge_num)
    private TextView num;

    @ViewInject(R.id.charge_item1)
    private View item1;
    @ViewInject(R.id.charge_item2)
    private View item2;
    @ViewInject(R.id.charge_item3)
    private View item3;
    @ViewInject(R.id.charge_item4)
    private View item4;
    @ViewInject(R.id.charge_item5)
    private View item5;
    @ViewInject(R.id.charge_item6)
    private View item6;
    @ViewInject(R.id.charge_item7)
    private View item7;
    @ViewInject(R.id.charge_item8)
    private View item8;
    @ViewInject(R.id.charge_item9)
    private View item9;

    private List<View> viewList;
    @Override
    public void initArgument() {
        showBack();
        setTitle(R.string.charge);

        viewList=new ArrayList<>();
        viewList.add(item1);
        viewList.add(item2);
        viewList.add(item3);
        viewList.add(item4);
        viewList.add(item5);
        viewList.add(item6);
        viewList.add(item7);
        viewList.add(item8);
        viewList.add(item9);
    }

    @Override
    public void initView() {

    }

    @Event({R.id.charge_weixin, R.id.charge_zhifubao, R.id.charge_item1, R.id.charge_item2, R.id.charge_item3, R.id.charge_item4, R.id.charge_item5, R.id.charge_item6, R.id.charge_item7, R.id.charge_item8, R.id.charge_item9})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.charge_weixin:
                break;
            case R.id.charge_zhifubao:
                break;
            default:
                for(View v:viewList){
                    v.setBackgroundResource(R.mipmap.choose_nor);
                }
                view.setBackgroundResource(R.mipmap.choose_pre);
                num.setText(view.getTag().toString());
                break;
        }
    }
}
