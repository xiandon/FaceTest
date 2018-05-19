package com.xiandon.facetest.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceTextActivity extends BaseActivity {
    Intent intent = new Intent(this, MyService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_service_control);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.btn_service_control_open, R.id.btn_service_control_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_service_control_open:
                startService(intent);
                break;
            case R.id.btn_service_control_close:
                stopService(intent);
                break;
        }
    }
}
