package com.dev.gocar.ui.model;


public class ShowCaseModel {

    private String title;

    private int imageResource;


    public ShowCaseModel(String title,int imageResource)  {
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImage() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }
}
