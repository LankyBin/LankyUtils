package com.lanky.utils;


import android.view.KeyEvent;

import com.lanky.utils.log.LankyLog;

/***
 * 隐藏入口
 * 组合顺序按键调用隐藏动作
 * onKeyDown传递keycode到checkPassword()
 */
public class HiddenEntrance {
    private final int[] mPassword;

    public HiddenEntrance(int[] password) {
        mPassword = password;
    }

    private OnPasswordCheckedListener mListener = new OnPasswordCheckedListener() {
        @Override
        public void onPasswordChecked(boolean passed) {
            LankyLog.w("Have you called setOnPasswordCheckedListener()?");
        }
    };
    private int mPwdNo = 0;

    public boolean checkPassword(int keyCode) {
        boolean ret = false;
        if (keyCode == KeyEvent.KEYCODE_UNKNOWN) {
            return false;
        }
        if (keyCode == mPassword[mPwdNo]) {
            ++mPwdNo;
        } else {
            mPwdNo = 0;
        }
        if (mPwdNo == mPassword.length) {
            ret = true;
            mPwdNo = 0;
        }
        mListener.onPasswordChecked(ret);
        return ret;
    }

    public void setOnPasswordCheckedListener(OnPasswordCheckedListener listener) {
        mListener = listener;
    }

    public interface OnPasswordCheckedListener {
        void onPasswordChecked(boolean passed);
    }
}
