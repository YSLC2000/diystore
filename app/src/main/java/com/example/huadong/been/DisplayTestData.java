package com.example.huadong.been;

import java.util.List;

public class DisplayTestData {
    private Integer display_avatar;
    private String display_title;
    private String display_userName;
    private List<DisplayListTestData> display_img;
    private String display_user_price;
    private String display_user_ThumbsUpNun;



    public String getDisplay_user_price() {
        return display_user_price;
    }

    public void setDisplay_user_price(String display_user_price) {
        this.display_user_price = display_user_price;
    }

    public String getDisplay_user_ThumbsUpNun() {
        return display_user_ThumbsUpNun;
    }

    public void setDisplay_user_ThumbsUpNun(String display_user_ThumbsUpNun) {
        this.display_user_ThumbsUpNun = display_user_ThumbsUpNun;
    }



    public Integer getDisplay_avatar() {
        return display_avatar;
    }

    public void setDisplay_avatar(Integer display_avatar) {
        this.display_avatar = display_avatar;
    }

    public String getDisplay_title() {
        return display_title;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public String getDisplay_userName() {
        return display_userName;
    }

    public void setDisplay_userName(String display_userName) {
        this.display_userName = display_userName;
    }

    public List<DisplayListTestData> getDisplay_img() {
        return display_img;
    }

    public void setDisplay_img(List<DisplayListTestData> display_img) {
        this.display_img = display_img;
    }
    @Override
    public String toString() {
        return "DisplayTestData{" +
                "display_avatar=" + display_avatar +
                ", display_title='" + display_title + '\'' +
                ", display_userName='" + display_userName + '\'' +
                ", display_img=" + display_img +
                ", display_user_price='" + display_user_price + '\'' +
                ", display_user_ThumbsUpNun=" + display_user_ThumbsUpNun +
                '}';
    }

}
