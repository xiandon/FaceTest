package com.xiandon.facetest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {
    private static String TAG = "BootCompleteReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "系统已经开机，可以做点啥了", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "系统已经开机，可以做点啥了");
    }
}
