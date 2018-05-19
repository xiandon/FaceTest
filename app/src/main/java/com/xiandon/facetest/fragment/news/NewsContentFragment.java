package com.xiandon.facetest.fragment.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiandon.facetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends Fragment {
    private static String TAG = "NewsContentFragment";

    @BindView(R.id.tv_news_fragment_title)
    TextView tvNewsFragmentTitle;
    @BindView(R.id.tv_news_fragment_content)
    TextView tvNewsFragmentContent;
    Unbinder unbinder;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_content, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /**
     * 刷新新闻界面
     */
    public void refresh(NewsContent newsContent) {
        tvNewsFragmentTitle.setText(newsContent.getTitle()); // 刷新新闻标题
        tvNewsFragmentContent.setText(newsContent.getContent()); //刷新新闻内容
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
