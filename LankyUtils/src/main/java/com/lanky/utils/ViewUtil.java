package com.lanky.utils;

import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.ViewCompat;

public class ViewUtil {
    public static float WIDTH_PROPORTION = 1.03f;
    public static float HEIGHT_PROPORTION = 1.03f;
    public static void animateView(View v,boolean hasFocus){
        if (hasFocus) {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(WIDTH_PROPORTION)
                    .scaleY(HEIGHT_PROPORTION)
                    .start();
        } else {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(1f)
                    .scaleY(1f)
                    .start();
        }
    }

    public static View.OnFocusChangeListener InteroperableOnFocusChangedListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            animateView(v, hasFocus);
        }
    };

    public static View.OnHoverListener InteroperableOnHoverListener = new View.OnHoverListener() {
        @Override
        public boolean onHover(View v, MotionEvent event) {
            boolean hasFocus = false;
            switch (event.getAction()) {
                case MotionEvent.ACTION_HOVER_ENTER:
                    hasFocus = true;
                    break;
                case MotionEvent.ACTION_HOVER_EXIT:
                    hasFocus = false;
                    break;
            }
            animateView(v, hasFocus);
            return false;
        }
    };
}
