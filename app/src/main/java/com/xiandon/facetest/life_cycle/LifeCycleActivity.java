package com.xiandon.facetest.life_cycle;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifeCycleActivity extends BaseActivity {

    private static String TAG = "LifeCycleActivity";
    @BindView(R.id.tv_life_cycle_context)
    TextView tvLifeCycleContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            String data = savedInstanceState.getString("life_cycle_context");
            tvLifeCycleContext.setText(data);
        }
        Log.d(TAG, "活动ID = " + this.toString());
        Log.d(TAG, "onCreate 创建");
    }

    @OnClick({R.id.btn_life_cycle_into_second, R.id.btn_life_cycle_into_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_life_cycle_into_second:
                startActivity(new Intent(this, LifeCycleSecondActivity.class));
                break;
            case R.id.btn_life_cycle_into_dialog:
                startActivity(new Intent(this, LifeCycleDialogActivity.class));
                break;
        }
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String data = tvLifeCycleContext.getText().toString();
        outPersistentState.putString("life_cycle_context", data);
    }
}
