package com.smapley.lottery.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.smapley.base.fragment.BaseFragment;
import com.smapley.lottery.R;
import com.smapley.lottery.activity.RechargeActivity;
import com.smapley.lottery.activity.WithdrawActivity;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;


@ContentView(R.layout.fragment_user)
public class UserFragment extends BaseFragment {


    @ViewInject(R.id.user_money)
    private TextView money;

    @Override
    public void initArgument() {

    }

    @Override
    public void initView() {

    }

    @Event({R.id.user_logout, R.id.user_withdraw, R.id.user_charge, R.id.user_set})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.user_charge:
                getActivity().startActivity(new Intent(getActivity(), RechargeActivity.class));
                break;
            case R.id.user_withdraw:
                getActivity().startActivity(new Intent(getActivity(),WithdrawActivity.class));
                break;
            case R.id.user_set:

                break;
            case R.id.user_logout:

                break;
        }
    }
}
