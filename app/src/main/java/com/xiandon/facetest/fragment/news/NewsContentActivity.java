package com.xiandon.facetest.fragment.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.xiandon.facetest.R;

public class NewsContentActivity extends AppCompatActivity {
    private static String TAG = "NewsContentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        // 获取传值数据
        NewsContent newsContent = initGet();

        //刷新数据
        refresh(newsContent);

    }

    private void refresh(NewsContent newsContent) {
        NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.f_news_fragment_content);
        fragment.refresh(newsContent);
    }

    private NewsContent initGet() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("NEWS_TITLE");
        String content = intent.getStringExtra("NEWS_CONTENT");
        NewsContent newsContent = new NewsContent(title, content);
        return newsContent;
    }

    /**
     * 让其他活动调用新闻内容界面
     *
     * @param context     上下文
     * @param newsContent 内容
     */
    public static void actionStart(Context context, NewsContent newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("NEWS_TITLE", newsContent.getTitle());
        intent.putExtra("NEWS_CONTENT", newsContent.getContent());
        context.startActivity(intent);
    }
}
