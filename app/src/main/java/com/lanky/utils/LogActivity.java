package com.lanky.utils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lanky.utils.log.LankyLog;

public class LogActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvLogTag;
    private SeekBar mSbLogLevel;
    private TextView mTvLogLevel;
    private Switch mSwitchLogWithDetail;
    private Button mBtnLogTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        initView();
    }

    private void initView() {

        mTvLogTag = (TextView) findViewById(R.id.tv_log_tag);
        mTvLogTag.setText(LankyLog.getTag());

        mSbLogLevel = (SeekBar) findViewById(R.id.sb_log_level);
        mTvLogLevel = (TextView) findViewById(R.id.tv_log_level);
        mSbLogLevel.setProgress(LankyLog.getLEVEL());
        mSbLogLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                LankyLog.setLEVEL(i);
                syncLogLevelText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSwitchLogWithDetail = (Switch) findViewById(R.id.switch_log_with_detail);
        mSwitchLogWithDetail.setChecked(LankyLog.getNeedDetail());
        mSwitchLogWithDetail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                LankyLog.setWithDetail(b);
            }
        });

        mBtnLogTest = (Button) findViewById(R.id.btn_log_test);
        mBtnLogTest.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        syncLogLevelText();
        super.onResume();
    }

    private void syncLogLevelText() {
        String str_level = "Info";
        switch (LankyLog.getLEVEL()) {
            case 0:
                str_level = "Verbose";
                break;
            case 1:
                str_level = "Debug";
                break;
            case 2:
                str_level = "Info";
                break;
            case 3:
                str_level = "Warning";
                break;
            case 4:
                str_level = "Error";
                break;
            case 5:
                str_level = "Close";
                break;
        }
        mTvLogLevel.setText(str_level);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_log_test:
                LankyLog.v("verbose log - verbose log - verbose log");
                LankyLog.d("~~Debug log~~");
                LankyLog.i("Info log.");
                LankyLog.w("Warning log!");
                LankyLog.e("Error log!!!");
                break;
        }
    }
}