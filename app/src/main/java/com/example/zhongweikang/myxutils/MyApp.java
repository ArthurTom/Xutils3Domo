package com.example.zhongweikang.myxutils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by zhongweikang on 2017/3/15.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
