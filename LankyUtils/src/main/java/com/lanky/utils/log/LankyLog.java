package com.lanky.utils.log;

import android.text.TextUtils;
import android.util.Log;

public class LankyLog {
    private static String mTag = "lanky";

    public static final int VERBOSE = 0;
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARN = 3;
    public static final int ERROR = 4;
    public static final int CLOSE = 5;

    public static int LEVEL = INFO;//默认Log的打印等级
    private static boolean mWithDetail = false;//是否需要Log详细信息

    private static String mClassName;//类名
    private static String mFileName;//文件名
    private static String mMethodName;//方法名
    private static int mLineNumber;//行数

    private static String createLog(String log) {
        StringBuilder buffer = new StringBuilder();
        if (mWithDetail) {
            buffer.append("[").append(mFileName).append(":")
                    .append(mLineNumber).append("]: ");
        }
        buffer.append(log);
        return buffer.toString();
    }

    private static void getCodeInfo(StackTraceElement[] sElements) {
        mClassName = sElements[1].getClassName();
        mFileName = sElements[1].getFileName();
        mMethodName = sElements[1].getMethodName();
        mLineNumber = sElements[1].getLineNumber();
    }

    public static void v(String log) {
        if (LEVEL <= VERBOSE) {
            if (!TextUtils.isEmpty(log)) {
                getCodeInfo(new Throwable().getStackTrace());
                Log.v(mTag, createLog(log));
            }
        }
    }

    public static void d(String log) {
        if (LEVEL <= DEBUG) {
            if (!TextUtils.isEmpty(log)) {
                getCodeInfo(new Throwable().getStackTrace());
                Log.d(mTag, createLog(log));
            }
        }
    }

    public static void i(String log) {
        if (LEVEL <= INFO) {
            if (!TextUtils.isEmpty(log)) {
                getCodeInfo(new Throwable().getStackTrace());
                Log.i(mTag, createLog(log));
            }
        }
    }

    public static void w(String log) {
        if (LEVEL <= WARN) {
            if (!TextUtils.isEmpty(log)) {
                getCodeInfo(new Throwable().getStackTrace());
                Log.w(mTag, createLog(log));
            }
        }
    }

    public static void e(String log) {
        if (LEVEL <= ERROR) {
            if (!TextUtils.isEmpty(log)) {
                getCodeInfo(new Throwable().getStackTrace());
                Log.e(mTag, createLog(log));
            }
        }
    }

    public static void setTag(String tag) {
        mTag = tag;
    }

    public static String getTag() {
        return mTag;
    }

    public static void setLEVEL(int level) {
        LEVEL = level;
    }

    public static int getLEVEL() {
        return LEVEL;
    }

    public static void setWithDetail(boolean need_detail) {
        mWithDetail = need_detail;
    }

    public static boolean isWithDetail() {
        return mWithDetail;
    }
}
