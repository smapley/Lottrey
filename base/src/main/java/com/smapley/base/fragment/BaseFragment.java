package com.smapley.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.xutils.x;

/**
 * Created by wuzhixiong on 2017/3/18.
 */

public abstract class BaseFragment extends Fragment {

    private boolean injected =false;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        injected = true;
        View view =x.view().inject(this,inflater,container);
        initArgument();
        initView();
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!injected){
            x.view().inject(this,this.getView());
        }
    }

    public abstract void initArgument();

    public abstract void initView();
}
