package com.liuxuejian.planefight.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liuxuejian.planefight.R;

public class SelectGameActivity extends BaseActivity implements View.OnClickListener {

    private TextView advance_btn, endless_btn, hell_btn;
    private View v11, v12, v21, v22, v31, v32;
    private Button start;
    private int mode = 5;//默认选择闯关模式
    private boolean musiccheck, shockcheck;//音效，震动 默认开启

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);
        initview();
        initFinishReceiver();
    }

    private void initview() {
        advance_btn = (TextView) findViewById(R.id.advance_btn);
        advance_btn.setOnClickListener(this);
        endless_btn = (TextView) findViewById(R.id.endless_btn);
        endless_btn.setOnClickListener(this);
        hell_btn = (TextView) findViewById(R.id.hell_btn);
        hell_btn.setOnClickListener(this);
        start = (Button) findViewById(R.id.start_select_game);
        start.setOnClickListener(this);
        v11 = (View) findViewById(R.id.v11);
        v12 = (View) findViewById(R.id.v12);
        v21 = (View) findViewById(R.id.v21);
        v22 = (View) findViewById(R.id.v22);
        v31 = (View) findViewById(R.id.v31);
        v32 = (View) findViewById(R.id.v32);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_select_game:
                Intent intent = new Intent(SelectGameActivity.this, NewGameActivity.class);
                intent.putExtra("musiccheck", musiccheck);
                intent.putExtra("shockcheck", shockcheck);
                intent.putExtra("mode", mode);
                startActivity(intent);
                break;
            case R.id.advance_btn:
                v11.setVisibility(View.VISIBLE);
                v12.setVisibility(View.VISIBLE);
                v21.setVisibility(View.GONE);
                v22.setVisibility(View.GONE);
                v31.setVisibility(View.GONE);
                v32.setVisibility(View.GONE);
                mode = 5;
                break;
            case R.id.endless_btn:
                v11.setVisibility(View.GONE);
                v12.setVisibility(View.GONE);
                v21.setVisibility(View.VISIBLE);
                v22.setVisibility(View.VISIBLE);
                v31.setVisibility(View.GONE);
                v32.setVisibility(View.GONE);
                mode = 6;
                break;
            case R.id.hell_btn:
                v11.setVisibility(View.GONE);
                v12.setVisibility(View.GONE);
                v21.setVisibility(View.GONE);
                v22.setVisibility(View.GONE);
                v31.setVisibility(View.VISIBLE);
                v32.setVisibility(View.VISIBLE);
                mode = 7;
                break;
            default:
                break;
        }
    }
}
