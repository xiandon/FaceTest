package com.xiandon.facetest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xiandon.facetest.R;

public class DynamicBookBroadcastActivity extends AppCompatActivity {
    private DynamicBookBroadcast broadcast;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_book_broadcast);
        intentFilter = new IntentFilter();

        // 系统网络发生变化了，发出了一条值为android.net.conn.CONNECTIVITY_CHANGE的广播
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        broadcast = new DynamicBookBroadcast();
        // 注册广播
        registerReceiver(broadcast, intentFilter);
    }

    class DynamicBookBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // ConnectivityManager专门用来管理网络
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消注册
        unregisterReceiver(broadcast);
    }
}
