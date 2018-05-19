package com.xiandon.facetest.nine_patch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiandon.facetest.R;

import java.util.List;

public class NinePatchChatAdapter extends RecyclerView.Adapter<NinePatchChatAdapter.MyViewHolder> {
    private List<ChatMessage> messageList;
    private Context context;

    public NinePatchChatAdapter(List<ChatMessage> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_nine_patch_chat_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChatMessage message = messageList.get(position);

        if (message.getType() == ChatMessage.TYPE_RECEIVED) {
            // 接收消息，显示左边的布局，隐藏右边的布局
            holder.linearLayoutLeft.setVisibility(View.VISIBLE);
            holder.linearLayoutRight.setVisibility(View.GONE);

            holder.messageLeft.setText(message.getContent());
        } else if (message.getType() == ChatMessage.TYPE_SEND) {
            // 发送消息，显示右边的布局，隐藏左边的布局
            holder.linearLayoutLeft.setVisibility(View.GONE);
            holder.linearLayoutRight.setVisibility(View.VISIBLE);

            holder.messageRight.setText(message.getContent());

        }
    }

    public void updateMessage(ChatMessage message) {
        messageList.add(messageList.size(), message);
        notifyItemChanged(messageList.size());
    }

    @Override
    public int getItemCount() {
        return messageList == null ? 0 : messageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayoutLeft;
        LinearLayout linearLayoutRight;

        TextView messageLeft;
        TextView messageRight;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayoutLeft = itemView.findViewById(R.id.ll_nine_patch_chat_left_layout);
            linearLayoutRight = itemView.findViewById(R.id.ll_nine_patch_chat_right_layout);

            messageLeft = itemView.findViewById(R.id.tv_nine_patch_chat_message_left);
            messageRight = itemView.findViewById(R.id.tv_nine_patch_chat_message_right);
        }
    }
}
