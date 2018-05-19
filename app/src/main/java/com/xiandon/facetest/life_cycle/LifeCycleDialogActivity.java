package com.xiandon.facetest.life_cycle;

import android.os.Bundle;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

public class LifeCycleDialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_dialog);
    }
}
