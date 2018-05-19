package com.xiandon.facetest.list_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xiandon.facetest.R;
import com.xiandon.facetest.base.BaseActivity;
import com.xiandon.facetest.list_view.adapter.Fruit;
import com.xiandon.facetest.list_view.adapter.FruitAdapter;
import com.xiandon.facetest.list_view.adapter.FruitBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomBaseListViewActivity extends BaseActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitBaseAdapter adapter;
    @BindView(R.id.lv_list_view_custom)
    ListView lvListViewCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        ButterKnife.bind(this);
        initFruits();// 初始化水果数据
        adapter = new FruitBaseAdapter(fruitList, this);
        lvListViewCustom.setAdapter(adapter);

        lvListViewCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // notifyDataSetChangedRefresh(i);// notifyDataSetChanged局部刷新
                // updateSingle(i);// 更新对应内容
                // updateViewHolder(i);// 通过ViewHolder去设置值
                updateGetView(i); // 调用一次getView
            }
        });
    }

    private void updateGetView(int i) {
        Fruit fruit = new Fruit("新增水果：西红柿", R.drawable.node_000b);
        fruitList.set(i, fruit);

        int firstVisiblePosition = lvListViewCustom.getFirstVisiblePosition();
        int lastVisiblePosition = lvListViewCustom.getLastVisiblePosition();


        /*在看见的范围内才更新，不可见的滑动后自动调用getView方法更新*/
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            // 获取View对象
            View view = lvListViewCustom.getChildAt(i - firstVisiblePosition);

            adapter.getView(i, view, lvListViewCustom);
        }
    }

    private void updateViewHolder(int i) {
        Fruit fruit = new Fruit("新增水果：火龙果", R.drawable.node_000b);
        fruitList.set(i, fruit);

        int firstVisiblePosition = lvListViewCustom.getFirstVisiblePosition();
        int lastVisiblePosition = lvListViewCustom.getLastVisiblePosition();

        /*在看见的范围内才更新，不可见的滑动后自动调用getView方法更新*/
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            // 获取View对象
            View view = lvListViewCustom.getChildAt(i - firstVisiblePosition);
            if (view.getTag() instanceof FruitBaseAdapter.ViewHolder) {
                FruitBaseAdapter.ViewHolder viewHolder = (FruitBaseAdapter.ViewHolder) view.getTag();
                viewHolder.fruitImage.setImageResource(fruitList.get(i).getImageId());
                viewHolder.fruitName.setText(fruitList.get(i).getName());
            }
        }
    }

    private void updateSingle(int i) {
        Fruit fruit = new Fruit("新增水果：桃子", R.drawable.node_000b);
        fruitList.set(i, fruit);

        int firstVisiblePosition = lvListViewCustom.getFirstVisiblePosition();
        int lastVisiblePosition = lvListViewCustom.getLastVisiblePosition();

        /*在看见的范围内才更新，不可见的滑动后自动调用getView方法更新*/
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            // 获取View对象
            View view = lvListViewCustom.getChildAt(i - firstVisiblePosition);
            TextView textView = view.findViewById(R.id.tv_lv_custom_name);
            ImageView imageView = view.findViewById(R.id.iv_lv_custom_image);

            textView.setText(fruitList.get(i).getName());
            imageView.setImageResource(fruitList.get(i).getImageId());
        }

    }

    private void notifyDataSetChangedRefresh(int i) {
        Fruit fruit = new Fruit("新增水果：栗子", R.drawable.node_000b);
        fruitList.set(i, fruit);
        adapter.notifyDataSetChanged();
    }

    private void initFruits() {
        for (int i = 0; i < 10; i++) {
            Fruit fruit1 = new Fruit("苹果", R.drawable.node_000a);
            fruitList.add(fruit1);
            Fruit fruit2 = new Fruit("芒果", R.drawable.node_000b);
            fruitList.add(fruit2);
            Fruit fruit3 = new Fruit("香蕉", R.drawable.node_000c);
            fruitList.add(fruit3);
            Fruit fruit4 = new Fruit("油桃", R.drawable.node_000d);
            fruitList.add(fruit4);
            Fruit fruit5 = new Fruit("猕猴桃", R.drawable.node_000e);
            fruitList.add(fruit5);
        }
    }
}
