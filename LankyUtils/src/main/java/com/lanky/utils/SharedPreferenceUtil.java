package com.lanky.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.lanky.utils.log.LankyLog;

public class SharedPreferenceUtil {
    private Context mContext;
    private static SharedPreferenceUtil mSharedPreference = null;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private SharedPreferenceUtil(Context context) {
        mContext = context;
        LankyLog.i("package: " + context.getPackageName());
        sharedPreferences = mContext.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferenceUtil getInstance(Context context) {
        if (mSharedPreference == null) {
            mSharedPreference = new SharedPreferenceUtil(context);
        }
        return mSharedPreference;
    }

    public void set(String key, int value) {
        editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void set(String key, String value) {
        editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void set(String key, boolean bool) {
        editor = sharedPreferences.edit();
        editor.putBoolean(key, bool);
        editor.apply();
    }

    public int get(String key, int def) {
        return sharedPreferences.getInt(key, def);
    }

    public boolean get(String key, boolean def) {
        return sharedPreferences.getBoolean(key, def);
    }

    public String get(String key, String def) {
        return sharedPreferences.getString(key, def);
    }
}
