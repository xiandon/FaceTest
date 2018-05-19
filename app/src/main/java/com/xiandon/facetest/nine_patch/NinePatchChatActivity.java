package com.xiandon.facetest.nine_patch;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.xiandon.facetest.R;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NinePatchChatActivity extends AppCompatActivity {
    private static String TAG = "NinePatchChatActivity";
    private List<ChatMessage> messages = new ArrayList<>();
    private NinePatchChatAdapter adapter;

    @BindView(R.id.rv_nine_patch_chat)
    RecyclerView rvNinePatchChat;
    @BindView(R.id.et_nine_patch_chat_context)
    EditText etNinePatchChatContext;
    @BindView(R.id.btn_nine_patch_chat_send)
    Button btnNinePatchChatSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_patch_chat);
        ButterKnife.bind(this);
        initMessages();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvNinePatchChat.setLayoutManager(manager);

        adapter = new NinePatchChatAdapter(messages, this);
        rvNinePatchChat.setAdapter(adapter);

    }

    private void initMessages() {
        ChatMessage messageRec = new ChatMessage("你好，在吗？", ChatMessage.TYPE_RECEIVED);
        messages.add(messageRec);
        ChatMessage messageSend = new ChatMessage("你好，在的，有什么事吗？", ChatMessage.TYPE_SEND);
        messages.add(messageSend);
    }

    @OnClick({R.id.et_nine_patch_chat_context, R.id.btn_nine_patch_chat_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_nine_patch_chat_context:
                rvNinePatchChat.scrollToPosition(messages.size());
                break;
            case R.id.btn_nine_patch_chat_send:
                Random random = new Random();
                int i = random.nextInt(2);
                Log.d(TAG, "随机数 = " + i);
                if (!"".equals(etNinePatchChatContext.getText().toString())) {
                    ChatMessage message = new ChatMessage(etNinePatchChatContext.getText().toString(), i);
                    // 有消息时，刷新数据
                    messages.add(message);
                    adapter.notifyItemInserted(messages.size() - 1);
                    // 将RecycleView定位到最后一行
                    rvNinePatchChat.scrollToPosition(messages.size() - 1);
                    etNinePatchChatContext.setText("");
                }
                break;
        }
    }
}
