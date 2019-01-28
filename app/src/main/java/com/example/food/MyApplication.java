package com.example.food;

import android.app.Application;
import android.content.Context;

/**
 * Created by 木头人 on 2019/1/5.
 */

public class MyApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
