package com.smapley.lottery.fragment;

import android.content.Intent;
import android.view.View;
import com.smapley.base.fragment.BaseFragment;
import com.smapley.lottery.R;
import com.smapley.lottery.activity.ChoseActivity;
import com.smapley.lottery.activity.PlanActivity;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.fragment_main)
public class MainFragment extends BaseFragment {


    @Override
    public void initArgument() {

    }

    @Override
    public void initView() {

    }

    @Event({R.id.main_chose, R.id.main_table, R.id.main_plan})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.main_chose:
                getActivity().startActivity(new Intent(getActivity(),ChoseActivity.class));
                break;
            case R.id.main_table:

                break;
            case R.id.main_plan:
                getActivity().startActivity(new Intent(getActivity(), PlanActivity.class));
                break;
        }
    }
}
