package com.marswang.weatherforecast;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by ${MarsWang} on 2017/4/6.
 */

public class MyApplication extends Application {

    private static Context content;

    @Override
    public void onCreate() {
        content = getApplicationContext();
        LitePal.initialize(this);

    }

    public static Context getContext(){
        return content;
    };
}
