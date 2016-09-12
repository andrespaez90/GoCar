package com.dev.gocar.ui.model;


public class UsedShowCaseModel {

    private String title;

    private String imageResource;

    private int price;

    public UsedShowCaseModel(String title, String imageResource, int price) {
        this.imageResource = imageResource;
        this.title = title;
        this.price = price;
    }

    public String getImage() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
