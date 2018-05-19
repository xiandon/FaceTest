package com.xiandon.facetest.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiandon.facetest.R;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    public TitleLayout(Context context) {
        super(context);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_title, this);
        Button title_back = findViewById(R.id.btn_title_back);
        Button title_setting = findViewById(R.id.btn_title_setting);
        TextView title_content = findViewById(R.id.tv_title_content);

        title_back.setOnClickListener(this);
        title_setting.setOnClickListener(this);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_title_back:
                Toast.makeText(getContext(), "点击返回", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_title_setting:
                Toast.makeText(getContext(), "点击设置", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
