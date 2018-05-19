package com.xiandon.facetest.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiandon.facetest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadcastCustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_custom);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_broadcast_custom_send_one, R.id.btn_broadcast_custom_send_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_broadcast_custom_send_one:
                // 标准广播
                Intent intent = new Intent("com.xiandon.facetest.broadcast.CUSTOM_BROADCAST");
                sendBroadcast(intent);
                break;
            case R.id.btn_broadcast_custom_send_two:
                Intent intentNum = new Intent("com.xiandon.facetest.broadcast.ORDERLY_BROADCAST");
                sendBroadcast(intentNum, null);
                break;
        }
    }
}
