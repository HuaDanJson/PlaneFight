package com.liuxuejian.planefight.activity;

/**
 * @author bruce.liu
 * @version 1.0
 * @time 2015/4/07/13.45
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.liuxuejian.planefight.R;
import com.liuxuejian.planefight.view.Abvanceview;

import java.util.List;

public class MainActivity extends BaseActivity {
    private boolean musiccheck, shockcheck;// 音效，震动 默认开启
    private Abvanceview myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFinishReceiver();
        getPermission();
    }

    public void mybtn(View v) {
        switch (v.getId()) {
            case R.id.modeselect:
                Intent intent = new Intent(this, ModeSelectActivity.class);
                intent.putExtra("musiccheck", musiccheck);
                intent.putExtra("shockcheck", shockcheck);
                startActivity(intent);
                break;
            case R.id.ranking:
                startActivity(new Intent(this, RankingListActivity.class));
                break;
            case R.id.gamesetting:
                startActivityForResult(new Intent(this, GameSetActivity.class), 1);
                break;
            case R.id.exit:
//			sendFinish();
                System.exit(0);
                break;
            default:
                break;
        }
    }

    // 处理返回的选项设置
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            musiccheck = data.getBooleanExtra("musiccheck", true);
            shockcheck = data.getBooleanExtra("shockcheck", true);
        }
    }

    /**
     * 发送广播退出多个Activity
     */
    private void sendFinish() {
        getApplicationContext().sendBroadcast(new Intent(INIENT_FINISH));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        unregisterReceiver(mFinishReceiver);
        super.onDestroy();
    }

    public void getPermission() {
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .rationale(new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(final ShouldRequest shouldRequest) {
                        shouldRequest.again(true);
                    }
                })
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {

                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {

                    }
                }).request();
    }

}
