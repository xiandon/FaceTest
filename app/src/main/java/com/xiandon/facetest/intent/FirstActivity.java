package com.xiandon.facetest.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends BaseActivity {
    private static String TAG = "FirstActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_intent_first);
        ButterKnife.bind(this);


        /*Intent intentPost = new Intent(this, SecondActivity.class);
        intentPost.putExtra("Extra_Data", "Welcome intent");
        startActivity(intentPost);*/


    }

    @OnClick(R.id.btn_intent_first)
    public void onViewClicked() {
        /*Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivityForResult(intent, 110);// 110表示请求码，值唯一*/
        SecondActivity.actionStart(this, "王五", "10025302");

    }

    /**
     * @param requestCode 启动时传入的请求码，如果启动多个活动，用不同的请求码去判断来源
     * @param resultCode  在返回数据的时候，传入的处理结果
     * @param data        携带返回数据的intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 110:
                if (RESULT_OK == resultCode) {
                    String returnData = data.getStringExtra("return_data");
                    Log.d(TAG, returnData);
                }
                break;
        }
    }
}
