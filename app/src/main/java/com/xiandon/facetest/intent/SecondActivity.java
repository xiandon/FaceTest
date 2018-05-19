package com.xiandon.facetest.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends BaseActivity {
    private static String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_intent_second);
        ButterKnife.bind(this);


        Intent intentGet = getIntent();
        String name = intentGet.getStringExtra("s_name");
        String user_num = intentGet.getStringExtra("s_user_num");

        Log.d(TAG, "活动First传值；姓名：" + name + "  用户ID：" + user_num);
    }

    @OnClick(R.id.btn_intent_second)
    public void onViewClicked() {
        Intent intent = getIntent();
        intent.putExtra("return_data", "Hello First 点击返回值");
        setResult(RESULT_OK, intent);// RESULT_OK是处理返回结果，一般只使用RESULT_OK和RESULT_CANCELED
        finish();// 销毁当前活动
    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("return_data", "Hello First Back 返回值");
        setResult(RESULT_OK, intent);// RESULT_OK是处理返回结果，一般只使用RESULT_OK和RESULT_CANCELED
        finish();// 销毁当前活动
    }

    public static void actionStart(Context context, String name, String user_num) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("s_name", name);
        intent.putExtra("s_user_num", user_num);
        context.startActivity(intent);
    }
}
