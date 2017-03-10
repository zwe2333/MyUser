package com.example.myuser;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Asus on 2017/3/10.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "c2d7b6f9221129d9a674fc9f5db80606");
    }
}
