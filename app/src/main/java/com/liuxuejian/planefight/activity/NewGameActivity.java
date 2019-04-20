package com.liuxuejian.planefight.activity;
/**
 * @author bruce.liu
 * @version 1.0
 * @time 2015/4/09/10.33
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liuxuejian.planefight.R;
import com.liuxuejian.planefight.view.Abvanceview5;
import com.liuxuejian.planefight.view.Abvanceview6;
import com.liuxuejian.planefight.view.Abvanceview7;
import com.liuxuejian.planefight.view.EndlessView;
import com.liuxuejian.planefight.view.HellView;

public class NewGameActivity extends BaseActivity {
    private EndlessView mEndlessView;
    private HellView mHellView;
    private boolean musiccheck, shockcheck;//音效，震动 默认开启

    private Abvanceview5 mAbvanceview5;
    private Abvanceview6 mAbvanceview6;
    private Abvanceview7 mAbvanceview7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        initView();
        Intent intent = getIntent();
        int mode = intent.getIntExtra("mode", 0);
        musiccheck = intent.getBooleanExtra("musiccheck", true);
        shockcheck = intent.getBooleanExtra("shockcheck", true);
        //根据模式选择View
        if (mode == 1) {
//            setContentView(abvanceview);
        } else if (mode == 2) {
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mEndlessView.setVisibility(View.VISIBLE);
            mEndlessView.setVoiceSettingData(musiccheck,shockcheck);
        } else if (mode == 3) {
            mEndlessView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mHellView.setVisibility(View.VISIBLE);
            mHellView.setVoiceSettingData(musiccheck,shockcheck);
        } else if (mode == 5) {
            mEndlessView.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.VISIBLE);
            mAbvanceview5.setVoiceSettingData(musiccheck,shockcheck);
        } else if (mode == 6) {
            mEndlessView.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.VISIBLE);
            mAbvanceview6.setVoiceSettingData(musiccheck,shockcheck);
        } else if (mode == 7) {
            mEndlessView.setVisibility(View.GONE);
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.VISIBLE);
            mAbvanceview7.setVoiceSettingData(musiccheck,shockcheck);
        }
    }

    public void initView() {
        mEndlessView = findViewById(R.id.end_less_view);
        mHellView = findViewById(R.id.hell_view);
        mAbvanceview5 = findViewById(R.id.abv5);
        mAbvanceview6 = findViewById(R.id.abv6);
        mAbvanceview7 = findViewById(R.id.abv7);
    }


}
