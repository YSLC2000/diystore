package com.example.huadong.been;

public class DisplayListTestData {
    public DisplayListTestData(Integer integer){
        this.img=integer;
    }
    public DisplayListTestData(){

    }
    private Integer img;

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "DisplayListTestData{" +
                "img=" + img +
                '}';
    }
}
