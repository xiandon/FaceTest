package com.xiandon.facetest.list_view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiandon.facetest.R;

import java.util.List;

public class FruitBaseAdapter extends BaseAdapter {
    private static String TAG = "FruitBaseAdapter";
    private List<Fruit> fruitList;
    private Context context;

    public FruitBaseAdapter(@NonNull List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruitList == null ? 0 : fruitList.size();
    }

    @Override
    public Object getItem(int i) {
        return fruitList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.i(TAG, fruitList.get(i).getName());
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.layout_list_view_simple_item, null);
            viewHolder.fruitImage = view.findViewById(R.id.iv_lv_custom_image);
            viewHolder.fruitName = view.findViewById(R.id.tv_lv_custom_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruitList.get(i).getImageId());
        viewHolder.fruitName.setText(fruitList.get(i).getName());

        return view;
    }

    public class ViewHolder {
        public ImageView fruitImage;
        public TextView fruitName;
    }
}
