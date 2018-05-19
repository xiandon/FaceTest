package com.xiandon.facetest.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.xiandon.facetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressActivity extends AppCompatActivity {

    @BindView(R.id.pb_ui_bar)
    ProgressBar pbUiBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_ui_bar_start, R.id.btn_ui_bar_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_ui_bar_start:
                int progress = pbUiBar.getProgress();
                progress = progress + 10;
                pbUiBar.setProgress(progress);
                break;
            case R.id.btn_ui_bar_stop:
                new Thread(runnable).start();
                break;
        }
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            pbUiBar.setProgress(message.what);
            return false;
        }
    });
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i <= 100; ) {
                Message message = handler.obtainMessage();
                message.what = i;
                i += 10;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(message);
            }
        }
    };
}
