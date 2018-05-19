package com.xiandon.facetest.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiandon.facetest.R;
import com.xiandon.facetest.list_view.adapter.Fruit;
import com.xiandon.facetest.recycler_view.adapter.RecyclerViewBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewBaseActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @BindView(R.id.rv_base)
    RecyclerView rvBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_base);
        ButterKnife.bind(this);

        initFruits();

        RecyclerViewBaseAdapter adapter = new RecyclerViewBaseAdapter(fruitList, this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvBase.setLayoutManager(manager);

        rvBase.setAdapter(adapter);


    }

    private void initFruits() {
        Fruit apple = new Fruit("苹果", R.drawable.node_000a);
        fruitList.add(apple);
        Fruit banana = new Fruit("香蕉", R.drawable.node_000a);
        fruitList.add(banana);
        Fruit kiwi = new Fruit("猕猴桃", R.drawable.node_000a);
        fruitList.add(kiwi);
        Fruit nectarine = new Fruit("油桃", R.drawable.node_000a);
        fruitList.add(nectarine);
    }


}
