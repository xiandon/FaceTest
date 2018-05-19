package com.xiandon.facetest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "第二个广播", Toast.LENGTH_SHORT).show();
        // 有序广播可以截断，设置优先级，也可以收到广播后，继续广播下去
        abortBroadcast();// 截断
    }
}
