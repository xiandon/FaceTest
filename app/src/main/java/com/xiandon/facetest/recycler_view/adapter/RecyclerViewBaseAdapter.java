package com.xiandon.facetest.recycler_view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiandon.facetest.R;
import com.xiandon.facetest.list_view.adapter.Fruit;

import java.util.List;

public class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.ViewHolder> {
    private List<Fruit> fruitList;
    private Context context;

    /**
     * 构造函数
     *
     * @param fruitList 数据源
     * @param context   上下文
     */
    public RecyclerViewBaseAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    /**
     * 构建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 绑定layout_list_view_simple_item布局到View中，并创建ViewHolder实例
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_view_simple_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 给ViewHolder赋值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Fruit fruit = fruitList.get(position);

        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fruit fruitChanged = new Fruit("橙子", R.drawable.node_000c);
                // updateAddFruit(position, fruitChanged);// 新增
                // updateSetFruit(position, fruitChanged);// 更新
                updateChangeViewBindHolder(position, "payloads"); // 重写onBindViewHolder更新item
            }
        });
    }

    /**
     * notifyItemChanged重写onBindViewHolder实现更新
     *
     * @param position 需要更新的项ID
     * @param payloads 标志，可任意字符串
     */
    private void updateChangeViewBindHolder(int position, String payloads) {
        notifyItemChanged(position, payloads);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            ViewHolder viewHolder = holder;
            viewHolder.fruitName.setText("改变我戛纳");
        }
    }

    /**
     * notifyItemChanged(position)更新数据
     *
     * @param position     需要更新的项
     * @param fruitChanged 更新的值
     */
    private void updateSetFruit(int position, Fruit fruitChanged) {
        fruitList.set(position, fruitChanged);
        notifyItemChanged(position);// 只会更新position的item的属性
    }

    /**
     * notifyDataSetChanged()更新数据
     *
     * @param position 需要更新的item坐标
     * @param addFruit 值
     */
    private void updateAddFruit(int position, Fruit addFruit) {
        fruitList.add(position, addFruit);
        notifyDataSetChanged();// 这个方法会造成其他不需要刷新的item也会更新
    }

    @Override
    public int getItemCount() {
        return fruitList == null ? 0 : fruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitImage = itemView.findViewById(R.id.iv_lv_custom_image);
            fruitName = itemView.findViewById(R.id.tv_lv_custom_name);
        }
    }


}
