package com.lanky.utils;

import android.content.Context;
import android.widget.Toast;

public class LankyToast {
    private static Toast mToast;
    private static long lastShowTime = 0l;
    private static String lastShowMsg = null;
    private static final int TOAST_DURATION = 2000;

    /***
     * 显示Toast，实时顶栈并避免短时间内重复显示
     * @param context
     * @param s
     */
    public static void show(Context context, CharSequence s) {
        String curShowMsg = s.toString();
        long curShowTime = System.currentTimeMillis();
        if (curShowMsg.equals(lastShowMsg)) {
            if (curShowTime - lastShowTime > TOAST_DURATION) {
                privShow(context, s);
                lastShowTime = curShowTime;
                lastShowMsg = curShowMsg;
            }
        } else {
            privShow(context, s);
            lastShowTime = curShowTime;
            lastShowMsg = curShowMsg;
        }
    }

    private static void privShow(Context context, CharSequence s) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
