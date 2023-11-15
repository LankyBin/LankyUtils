package com.lanky.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnMainLog;
    private Button mBtnMainHiddenEntrance;
    private Button mBtnMainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mBtnMainLog = findViewById(R.id.btn_main_log);
        mBtnMainHiddenEntrance = (Button) findViewById(R.id.btn_main_hidden_entrance);
        mBtnMainView = (Button) findViewById(R.id.btn_main_view);

        mBtnMainLog.setOnClickListener(this);
        mBtnMainHiddenEntrance.setOnClickListener(this);
        mBtnMainView.setOnClickListener(this);

        mBtnMainLog.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainLog.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
        mBtnMainHiddenEntrance.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainHiddenEntrance.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
        mBtnMainView.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mBtnMainView.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
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
        }
    }
}