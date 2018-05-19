package com.xiandon.facetest.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_list_view_simple,
            R.id.btn_list_view_custom,
            R.id.btn_list_view_custom_base})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_list_view_simple:
                startActivity(new Intent(this, SimpleListViewActivity.class));
                break;
            case R.id.btn_list_view_custom:
                startActivity(new Intent(this, CustomListViewActivity.class));
                break;
            case R.id.btn_list_view_custom_base:
                startActivity(new Intent(this, CustomBaseListViewActivity.class));
                break;
        }

    }
}
