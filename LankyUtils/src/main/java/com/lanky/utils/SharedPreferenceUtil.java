package com.lanky.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.lanky.utils.log.LankyLog;

import java.util.Map;

public class SharedPreferenceUtil {
    private Context mContext;
    private static SharedPreferenceUtil mSharedPreferenceUtil = null;

    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    private SharedPreferenceUtil(Context context) {
        mContext = context;
        LankyLog.i("package: " + context.getPackageName());
        mSharedPreferences = mContext.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static SharedPreferenceUtil getInstance(Context context) {
        if (mSharedPreferenceUtil == null) {
            mSharedPreferenceUtil = new SharedPreferenceUtil(context);
        }
        return mSharedPreferenceUtil;
    }

    public void set(String key, Object object) {
        if (object instanceof String) {
            mEditor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            mEditor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            mEditor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            mEditor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            mEditor.putLong(key, (Long) object);
        } else {
            mEditor.putString(key, object.toString());
        }
        mEditor.apply();
    }

    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return mSharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return mSharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return mSharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return mSharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return mSharedPreferences.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    public Map<String, ?> getAll() {
        return mSharedPreferences.getAll();
    }

    public void remove(String key) {
        mEditor.remove(key);
        mEditor.apply();
    }

    public void clear() {
        mEditor.clear().apply();
    }

    public int get(String key, int def) {
        return mSharedPreferences.getInt(key, def);
    }

    public boolean get(String key, boolean def) {
        return mSharedPreferences.getBoolean(key, def);
    }

    public String get(String key, String def) {
        return mSharedPreferences.getString(key, def);
    }

    public Long get(String key, Long def) {
        return mSharedPreferences.getLong(key, def);
    }

    public Float get(String key, Float def) {
        return mSharedPreferences.getFloat(key, def);
    }
}
