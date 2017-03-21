package com.smapley.base.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import com.smapley.base.BaseData;
import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by wuzhixiong on 2017/3/13.
 */

public class BaseApplication extends Application {


    private static BaseApplication instance;

    private SharedPreferences userShared;
    private SharedPreferences setShared;


    //单例模式获取Application实例
    public static BaseApplication getInstance(){
        if(instance==null){
            instance=new BaseApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xUtils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.

        //初始化本地存储
        userShared= getSharedPreferences(BaseData.USERSHARED,MODE_PRIVATE);
        setShared= getSharedPreferences(BaseData.SETSHARED,MODE_PRIVATE);

        Log.d("-----------------","application started");
    }
}
