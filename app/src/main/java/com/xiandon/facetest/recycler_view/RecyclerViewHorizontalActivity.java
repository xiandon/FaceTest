package com.xiandon.facetest.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.xiandon.facetest.R;
import com.xiandon.facetest.list_view.adapter.Fruit;
import com.xiandon.facetest.recycler_view.adapter.RecyclerViewBaseAdapter;
import com.xiandon.facetest.recycler_view.adapter.RecyclerViewHorizontalAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHorizontalActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @BindView(R.id.rv_base)
    RecyclerView rvBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_base);
        ButterKnife.bind(this);

        initFruits();

        RecyclerViewHorizontalAdapter adapter = new RecyclerViewHorizontalAdapter(fruitList, this);
        // 横向布局
/*        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);*/

/*        // 网格布局,瀑布流布局
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvBase.setLayoutManager(manager);*/

        rvBase.setAdapter(adapter);


    }

    private void initFruits() {
        Fruit apple = new Fruit(getRandomLengthName("苹果"), R.drawable.node_000a);
        fruitList.add(apple);
        Fruit banana = new Fruit(getRandomLengthName("香蕉"), R.drawable.node_000a);
        fruitList.add(banana);
        Fruit kiwi = new Fruit(getRandomLengthName("猕猴桃"), R.drawable.node_000a);
        fruitList.add(kiwi);
        Fruit nectarine = new Fruit(getRandomLengthName("油桃"), R.drawable.node_000a);
        fruitList.add(nectarine);
    }

    /**
     * 生成1，20的随机数，并把name重复随机数遍
     *
     * @param name 需要重复的字符串
     * @return 返回重复之后的字符串
     */
    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
