package com.xiandon.facetest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiandon.facetest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_base);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_simple_fragment, R.id.btn_custom_fragment, R.id.btn_news_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_fragment:
                startActivity(new Intent(this, SimpleFragmentActivity.class));
                break;
            case R.id.btn_custom_fragment:
                startActivity(new Intent(this, FragmentCustomActivity.class));
                break;
            case R.id.btn_news_test:
                startActivity(new Intent(this, NewsFragmentActivity.class));
                break;
        }
    }
}
