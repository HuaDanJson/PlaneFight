package com.liuxuejian.planefight.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.liuxuejian.planefight.R;
import com.liuxuejian.planefight.dialog.LogoutDialog;
import com.liuxuejian.planefight.utils.PlayMusicManager;
import com.liuxuejian.planefight.view.Abvanceview5;
import com.liuxuejian.planefight.view.Abvanceview6;
import com.liuxuejian.planefight.view.Abvanceview7;
import com.liuxuejian.planefight.view.EndlessView;
import com.liuxuejian.planefight.view.HellView;

public class NewGameActivity extends FragmentActivity implements LogoutDialog.FinishGameListener {
    private EndlessView mEndlessView;
    private HellView mHellView;
    private boolean musiccheck, shockcheck;//音效，震动 默认开启

    private Abvanceview5 mAbvanceview5;
    private Abvanceview6 mAbvanceview6;
    private Abvanceview7 mAbvanceview7;
    private ImageView mSoundImageView;
    private ImageView mFinishImageView;

    private LogoutDialog mLogoutDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_game);
        PlayMusicManager.getInstance().playMusic(NewGameActivity.this, R.raw.bg1);
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
            mEndlessView.setVoiceSettingData(musiccheck, shockcheck,this);
        } else if (mode == 3) {
            mEndlessView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mHellView.setVisibility(View.VISIBLE);
            mHellView.setVoiceSettingData(musiccheck, shockcheck,this);
        } else if (mode == 5) {
            mEndlessView.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.VISIBLE);
            mAbvanceview5.setVoiceSettingData(musiccheck, shockcheck,this);
        } else if (mode == 6) {
            mEndlessView.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.GONE);
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.VISIBLE);
            mAbvanceview6.setVoiceSettingData(musiccheck, shockcheck,this);
        } else if (mode == 7) {
            mEndlessView.setVisibility(View.GONE);
            mHellView.setVisibility(View.GONE);
            mAbvanceview5.setVisibility(View.GONE);
            mAbvanceview6.setVisibility(View.GONE);
            mAbvanceview7.setVisibility(View.VISIBLE);
            mAbvanceview7.setVoiceSettingData(musiccheck, shockcheck,this);
        }
    }

    public void initView() {
        mEndlessView = findViewById(R.id.end_less_view);
        mHellView = findViewById(R.id.hell_view);
        mAbvanceview5 = findViewById(R.id.abv5);
        mAbvanceview6 = findViewById(R.id.abv6);
        mAbvanceview7 = findViewById(R.id.abv7);
        mSoundImageView = findViewById(R.id.iv_sound_main_activity);
        mFinishImageView = findViewById(R.id.iv_back);
        mSoundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSoundImageView.isSelected()) {
                    mSoundImageView.setSelected(false);
                    PlayMusicManager.getInstance().playMusic(NewGameActivity.this, R.raw.bg1);
                } else {
                    mSoundImageView.setSelected(true);
                    PlayMusicManager.getInstance().stopMusic();
                }
            }
        });
        mFinishImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFinishGameDialog();
            }
        });
    }

    public void showFinishGameDialog() {
        if (mLogoutDialog == null) {
            mLogoutDialog = new LogoutDialog();
        }
        mLogoutDialog.setListener(this);

        mLogoutDialog.tryShow(getSupportFragmentManager());
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public void onFinishGame() {
        PlayMusicManager.getInstance().stopMusic();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PlayMusicManager.getInstance().stopMusic();
    }
}
