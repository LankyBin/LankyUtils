package com.lanky.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class HiddenEntranceActivity extends AppCompatActivity {

    private static final int[] PASSWORD = {
            KeyEvent.KEYCODE_DPAD_UP,
            KeyEvent.KEYCODE_DPAD_DOWN,
            KeyEvent.KEYCODE_DPAD_LEFT,
            KeyEvent.KEYCODE_DPAD_RIGHT
    };

    private HiddenEntrance mHiddenEntrance = new HiddenEntrance(PASSWORD);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden_entrance);
    }

    @Override
    protected void onResume() {
        mHiddenEntrance.setOnPasswordCheckedListener(new HiddenEntrance.OnPasswordCheckedListener() {
            @Override
            public void onPasswordChecked(boolean passed) {
                if (passed) {
                    Toast.makeText(HiddenEntranceActivity.this, "bingo~", Toast.LENGTH_SHORT).show();
                }
            }
        });
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {

            mHiddenEntrance.checkPassword(keyCode);

        }
        return super.onKeyDown(keyCode, event);
    }
}