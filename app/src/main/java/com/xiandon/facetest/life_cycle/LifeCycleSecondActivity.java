package com.xiandon.facetest.life_cycle;

import android.os.Bundle;
import android.util.Log;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.ActivityController;
import com.xiandon.facetest.base.BaseActivity;

public class LifeCycleSecondActivity extends BaseActivity {

    private static String TAG = "LifeCycleSecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart 开始");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume 恢复");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause 暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy 销毁");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart 重启");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "点击了返回键");
        ActivityController.finishApp();
    }
}
