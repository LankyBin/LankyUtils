package com.lanky.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lanky.utils.log.LankyLog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button mBtnMainLog;
    private Button mBtnMainHiddenEntrance;
    private Button mBtnMainView;
    private Button mBtnMainToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        initViews();
    }

    private void initViews() {
        mBtnMainLog = findViewById(R.id.btn_main_log);
        mBtnMainHiddenEntrance = (Button) findViewById(R.id.btn_main_hidden_entrance);
        mBtnMainView = (Button) findViewById(R.id.btn_main_view);
        mBtnMainToast = (Button) findViewById(R.id.btn_main_toast);

        mBtnMainLog.setOnClickListener(this);
        mBtnMainHiddenEntrance.setOnClickListener(this);
        mBtnMainView.setOnClickListener(this);
        mBtnMainToast.setOnClickListener(this);

        mBtnMainLog.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainLog.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
        mBtnMainHiddenEntrance.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainHiddenEntrance.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
        mBtnMainView.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainView.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
        mBtnMainToast.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainToast.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);

        LankyLog.syncConfig(mContext);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_log:
                startActivity(new Intent(this, LogActivity.class));
                break;
            case R.id.btn_main_hidden_entrance:
                startActivity(new Intent(this, HiddenEntranceActivity.class));
                break;
            case R.id.btn_main_view:
                startActivity(new Intent(this, ViewActivity.class));
                break;
            case R.id.btn_main_toast:
                startActivity(new Intent(this, ToastActivity.class));
                break;
        }
    }
}