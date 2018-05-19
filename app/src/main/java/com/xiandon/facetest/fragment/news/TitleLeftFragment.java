package com.xiandon.facetest.fragment.news;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiandon.facetest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleLeftFragment extends Fragment {
    private static String TAG = "TitleLeftFragment";

    @BindView(R.id.rv_news_left_title)
    RecyclerView rvNewsLeftTitle;
    private boolean isTwoPane;
    private List<NewsContent> newsContentList = new ArrayList<>();


    Unbinder unbinder;
    private View view;

    public TitleLeftFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_title_left, container, false);
        unbinder = ButterKnife.bind(this, view);
        initNewsData();
        initView();
        return view;
    }

    private void initNewsData() {
        for (int i = 0; i < 10; i++) {
            NewsContent new1 = new NewsContent("梦回1986，非洲狮王血虐葡萄牙" + i, "江山代有才人出，各领风骚数百年。2014年的巴西世界杯上，32强为我们奉献了一届精彩的赛事。4年过去了，俄罗斯世界杯将重燃战火，这一次的32强与4年前相比有了不小的变化。参加了上届世界杯的32队中，有20队依然坚守着他们的辉煌，其余12队则换了新颜。在新入围的这12队中，有一支球队尤为特殊，他们是时隔20年后重返世界杯的舞台。" + i);
            newsContentList.add(new1);
        }
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvNewsLeftTitle.setLayoutManager(manager);

        NewsTitleLeftAdapter adapter = new NewsTitleLeftAdapter(newsContentList);
        rvNewsLeftTitle.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.fl_news_content_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    class NewsTitleLeftAdapter extends RecyclerView.Adapter<NewsTitleViewHolder> {
        private List<NewsContent> newsContents;

        public NewsTitleLeftAdapter(List<NewsContent> newsContents) {
            this.newsContents = newsContents;
        }

        @NonNull
        @Override
        public NewsTitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_left_title_item, null);
            NewsTitleViewHolder holder = new NewsTitleViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull NewsTitleViewHolder holder, int position) {
            final NewsContent newsContent = newsContents.get(position);
            holder.title.setText(newsContent.getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isTwoPane) {
                        // 双页模式
                        NewsContentFragment fragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.f_news_content);
                        fragment.refresh(newsContent);
                    } else {
                        // 单页模式
                        NewsContentActivity.actionStart(getActivity(), newsContent);
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return newsContents == null ? 0 : newsContents.size();
        }
    }

    private class NewsTitleViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public NewsTitleViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_news_title_left);
        }
    }
}
