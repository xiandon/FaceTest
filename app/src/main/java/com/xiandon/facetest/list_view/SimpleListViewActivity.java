package com.xiandon.facetest.list_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleListViewActivity extends BaseActivity {

    @BindView(R.id.lv_list_view_simple)
    ListView lvListViewSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        ButterKnife.bind(this);

        String[] data = {"苹果", "香蕉", "芒果", "油桃", "梨"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lvListViewSimple.setAdapter(arrayAdapter);
    }
}
