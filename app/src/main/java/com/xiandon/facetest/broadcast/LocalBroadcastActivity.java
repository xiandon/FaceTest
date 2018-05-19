package com.xiandon.facetest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xiandon.facetest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocalBroadcastActivity extends AppCompatActivity {
    private IntentFilter intentFilter;

    private LocalBroadcast localBroadcast;

    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        ButterKnife.bind(this);
        intentFilter = new IntentFilter();
        manager = LocalBroadcastManager.getInstance(this);
        intentFilter.addAction("com.xiandon.facetest.broadcast.LOCAL_BROADCAST");
        localBroadcast = new LocalBroadcast();
        manager.registerReceiver(localBroadcast, intentFilter); // 注册本地广播监听器
    }

    @OnClick(R.id.btn_broadcast_local)
    public void onViewClicked() {
        Intent intent = new Intent("com.xiandon.facetest.broadcast.LOCAL_BROADCAST");
        manager.sendBroadcast(intent);// 发送本地广播
    }

    class LocalBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "接收到本地广播", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadcast);
    }
}
