package com.example.huadong.been;

public class HomeTestData {
    private String HomeTitle;
    private String HomeDay;
    private Integer HomeImage;


    private Integer HomeNum;

    public String getHomeTitle() {
        return HomeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        HomeTitle = homeTitle;
    }

    public String getHomeDay() {
        return HomeDay;
    }

    public void setHomeDay(String homeDay) {
        HomeDay = homeDay;
    }

    public Integer getHomeImage() {
        return HomeImage;
    }

    public void setHomeImage(Integer homeImage) {
        HomeImage = homeImage;
    }

    public Integer getHomeNum() {
        return HomeNum;
    }

    public void setHomeNum(Integer homeNum) {
        HomeNum = homeNum;
    }
    @Override
    public String toString() {
        return "HomeTestData{" +
                "HomeTitle='" + HomeTitle + '\'' +
                ", HomeDay='" + HomeDay + '\'' +
                ", HomeImage=" + HomeImage +
                ", HomeNum=" + HomeNum +
                '}';
    }

}
