package com.xiandon.facetest.recycler_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiandon.facetest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_recycler_view_base, R.id.btn_recycler_view_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_recycler_view_base:
                startActivity(new Intent(this, RecyclerViewBaseActivity.class));
                break;
            case R.id.btn_recycler_view_update:
                startActivity(new Intent(this, RecyclerViewHorizontalActivity.class));
                break;
        }
    }
}
