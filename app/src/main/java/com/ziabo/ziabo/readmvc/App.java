package com.ziabo.ziabo.readmvc;

import android.app.Application;
import android.content.Context;

import com.ziabo.ziabo.readmvc.utils.CrashHandler;
import com.ziabo.ziabo.readmvc.utils.NetUtils;
import com.ziabo.ziabo.readmvc.utils.T;

/**
 * Created by ziabo on 2016/12/20.
 * Application类,做一部分初始化
 */

public class App extends Application{

    private static App instance;
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
        instance = this;
        NetUtils.register(this);
        T.register(this);
    }

    /**
     * 获取App对象
     */
    public static App getInstance(){
        return instance;
    }
}
