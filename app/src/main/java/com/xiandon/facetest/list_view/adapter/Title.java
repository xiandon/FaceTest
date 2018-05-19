package com.xiandon.facetest.list_view.adapter;

public class Title {
    private String titleName;
    private int titleImage;

    public Title(String titleName, int titleImage) {
        this.titleName = titleName;
        this.titleImage = titleImage;
    }

    public String getTitleName() {
        return titleName;
    }

    public int getTitleImage() {
        return titleImage;
    }
}
