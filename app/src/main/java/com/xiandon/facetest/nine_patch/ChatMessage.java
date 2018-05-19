package com.xiandon.facetest.nine_patch;

public class ChatMessage {

    public static final int TYPE_RECEIVED = 0;// 这是一条收到的消息
    public static final int TYPE_SEND = 1; // 这是一条发送的消息

    private String content;
    private int type;

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public ChatMessage(String content, int type) {
        this.content = content;
        this.type = type;
    }
}
