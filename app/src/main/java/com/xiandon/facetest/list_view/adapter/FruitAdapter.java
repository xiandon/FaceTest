package com.xiandon.facetest.list_view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiandon.facetest.R;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    /**
     * @param context   上下文
     * @param resource  子布局ID
     * @param fruitList 数据
     */
    public FruitAdapter(@NonNull Context context, int resource, List<Fruit> fruitList) {
        super(context, resource, fruitList);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 得到Fruit实例
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        // 将之前加载好的布局，进行缓存
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);// 为子项传入item布局
            viewHolder = new ViewHolder();
            viewHolder.imageId = view.findViewById(R.id.iv_lv_custom_image);
            viewHolder.name = view.findViewById(R.id.tv_lv_custom_name);
            view.setTag(viewHolder);// 将ViewHolder存储在View中
        } else {
            view = convertView; // convertView不为空，直接加载布局
            viewHolder = (ViewHolder) view.getTag();// 重新获取ViewHolder
        }
        viewHolder.imageId.setImageResource(fruit.getImageId());
        viewHolder.name.setText(fruit.getName());

        return view;
    }

    //用于缓存控件实例
    class ViewHolder {
        ImageView imageId;
        TextView name;
    }
}
