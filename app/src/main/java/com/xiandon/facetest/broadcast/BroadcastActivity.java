package com.xiandon.facetest.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiandon.facetest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_broadcast_dynamic_book, R.id.btn_broadcast_custom, R.id.btn_broadcast_local})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_broadcast_dynamic_book:
                startActivity(new Intent(this, DynamicBookBroadcastActivity.class));
                break;
            case R.id.btn_broadcast_custom:
                startActivity(new Intent(this, BroadcastCustomActivity.class));
                break;
            case R.id.btn_broadcast_local:
                startActivity(new Intent(this, LocalBroadcastActivity.class));
                break;
        }
    }
}
