package com.ziabo.ziabo.readmvc.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by ziabo on 2016/12/15.
 */

public class T {
    private static Context mContext;
    private static Toast toast;
    private T(){
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void register(Context context){
        mContext = context.getApplicationContext();
    }

    public static void showShort(CharSequence message){
        if (mContext==null){
            throw new RuntimeException("unRegister Context in Application");
        }
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(mContext,message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void showShort(@StringRes int resId){
        if (mContext==null){
            throw new RuntimeException("unRegister Context in Application");
        }
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(mContext,mContext.getString(resId), Toast.LENGTH_SHORT);
        toast.show();
    }
}
