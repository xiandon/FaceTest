package com.xiandon.facetest.fragment.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiandon.facetest.R;

import java.util.List;

public class NewsTitleAdapter extends RecyclerView.Adapter<NewsTitleAdapter.NewViewHolder> {

    private Context context;
    private List<NewsContent> newsContents;
    private boolean isTwoPane;

    public NewsTitleAdapter(Context context, List<NewsContent> newsContents, boolean isTwoPane) {
        this.context = context;
        this.newsContents = newsContents;
        this.isTwoPane = isTwoPane;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_news_left_title_item, null);
        NewViewHolder holder = new NewViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        holder.title.setText(newsContents.get(position).getTitle());
        NewsContent newsContent = newsContents.get(position);
        if (isTwoPane) {
            //双页模式
        } else {
            //单页模式
            NewsContentActivity.actionStart(context, newsContent);
        }
    }

    @Override
    public int getItemCount() {
        return newsContents == null ? 0 : newsContents.size();
    }

    class NewViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public NewViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_news_title_left);
        }
    }
}
