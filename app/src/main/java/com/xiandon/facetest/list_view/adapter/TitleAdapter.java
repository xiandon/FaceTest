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

public class TitleAdapter extends ArrayAdapter<Title> {
    private int resourceId;


    public TitleAdapter(@NonNull Context context, int resource, @NonNull List<Title> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Title title = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            viewHolder.title_image = view.findViewById(R.id.iv_main_list_view_title_image);
            viewHolder.title_name = view.findViewById(R.id.tv_main_list_view_title_name);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.title_image.setImageResource(title.getTitleImage());
        viewHolder.title_name.setText(title.getTitleName());

        return view;
    }

    class ViewHolder {
        ImageView title_image;
        TextView title_name;
    }
}
