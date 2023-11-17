package com.lanky.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button mBtnToastFinalTips;
    private Button mBtnToastChangedTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mContext = ToastActivity.this;
        initView();
    }

    private void initView() {
        mBtnToastFinalTips = (Button) findViewById(R.id.btn_toast_final_tips);
        mBtnToastChangedTips = (Button) findViewById(R.id.btn_toast_changed_tips);
        mBtnToastFinalTips.setOnClickListener(this);
        mBtnToastChangedTips.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast_final_tips:
                LankyToast.show(mContext, "这是一条不变的内容");
                break;
            case R.id.btn_toast_changed_tips:
                String s = System.currentTimeMillis() + "";
                LankyToast.show(mContext, s);
                break;
        }
    }
}