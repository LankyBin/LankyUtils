package com.lanky.utils;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    private SeekBar mSbViewProportionWidth;
    private TextView mTvViewProportionWidth;
    private SeekBar mSbViewProportionHeight;
    private TextView mTvViewProportionHeight;
    private TextView mTvViewDemo;

    private float mWp = 1.00F;
    private float mHp = 1.00F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initView();
    }

    private void initView() {
        mSbViewProportionWidth = (SeekBar) findViewById(R.id.sb_view_proportion_width);
        mTvViewProportionWidth = (TextView) findViewById(R.id.tv_view_proportion_width);
        mSbViewProportionHeight = (SeekBar) findViewById(R.id.sb_view_proportion_height);
        mTvViewProportionHeight = (TextView) findViewById(R.id.tv_view_proportion_height);

        mTvViewProportionWidth.setText(ViewUtil.WIDTH_PROPORTION + "");
        mSbViewProportionWidth.setProgress((int) (ViewUtil.WIDTH_PROPORTION * 100));
        mSbViewProportionWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mWp = i / 100.0F;
                ViewUtil.WIDTH_PROPORTION = mWp;
                mTvViewProportionWidth.setText(ViewUtil.WIDTH_PROPORTION + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mTvViewProportionHeight.setText(ViewUtil.HEIGHT_PROPORTION + "");
        mSbViewProportionHeight.setProgress((int) (ViewUtil.HEIGHT_PROPORTION * 100));
        mSbViewProportionHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mHp = i / 100.0F;
                ViewUtil.HEIGHT_PROPORTION = mHp;
                mTvViewProportionHeight.setText(ViewUtil.HEIGHT_PROPORTION + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mTvViewDemo = (TextView) findViewById(R.id.tv_view_demo);
        mTvViewDemo.setOnFocusChangeListener(ViewUtil.InteroperableOnFocusChangedListener);
        mTvViewDemo.setOnHoverListener(ViewUtil.InteroperableOnHoverListener);
    }
}