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

public class RecyclerViewHorizontalAdapter extends RecyclerView.Adapter<RecyclerViewHorizontalAdapter.ViewHolder> {
    private List<Fruit> fruitList;
    private Context context;

    public RecyclerViewHorizontalAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recycle_view_horizontal_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Fruit fruit = fruitList.get(position);

        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击 " + fruit.getName() + " 的图片", Toast.LENGTH_SHORT).show();
            }
        });

        holder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击 " + fruit.getName() + " 文字", Toast.LENGTH_SHORT).show();
            }
        });
    }

   
    @Override
    public int getItemCount() {
        return fruitList == null ? 0 : fruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = itemView.findViewById(R.id.iv_lv_custom_image);
            fruitName = itemView.findViewById(R.id.tv_lv_custom_name);
        }
    }
}
