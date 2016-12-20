package com.ziabo.ziabo.readmvc.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by ziabo on 2016/12/15.
 * 网络检查工具类
 */

public class NetUtils {
    private static Context mContext;
    private NetUtils(){
        throw new UnsupportedOperationException("cannot be instantiated!");
    }
    public static void register(Context context){mContext = context.getApplicationContext();}

    /**
     * @return boolean isConnected 网络是否连接
     */
    public static boolean isConnected(){
        if (mContext == null){
            throw new RuntimeException("unRegister Context inApplication");
        }
        ConnectivityManager connManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connManager != null && connManager.getActiveNetworkInfo() !=null &&
                connManager.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED;
    }

    /**
     * @return isWifi 判断是否为wifi连接
     */
    public static boolean isWifi(){
        if (mContext == null){
            throw new RuntimeException("unRegister Context in Application");
        }
        ConnectivityManager cm = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm!=null && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 打开网络设置
     */
    public static void openSetting(Activity activity){
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent,0);
    }

}
