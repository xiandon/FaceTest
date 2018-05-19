package com.xiandon.facetest.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiandon.facetest.R;
import com.xiandon.facetest.fragment.fragment.RightFragment;
import com.xiandon.facetest.fragment.fragment.RightOtherFragment;

public class SimpleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);
        Button button = findViewById(R.id.btn_fragment_simple_left);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new RightOtherFragment());
            }
        });

        replaceFragment(new RightFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_fragment_right, fragment);
        transaction.addToBackStack(null); //模拟返回栈，添加此属性，可以返回到第一个Fragment，和初始状态，再退出主Activity。不添加此属性，直接退出Activity
        transaction.commit();
    }

}
