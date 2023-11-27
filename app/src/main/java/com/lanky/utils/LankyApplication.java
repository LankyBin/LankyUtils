package com.lanky.utils;

import android.app.Application;
import android.content.res.Configuration;

import com.lanky.utils.log.LankyLog;

public class LankyApplication extends Application {

    @Override
    public void onCreate() {
        LankyLog.syncConfig(this);
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        LankyLog.w("onLowMemory:");
        super.onLowMemory();
    }
}
