package com.example.huadong.been;

import java.io.Serializable;

public class ToolsTestData implements Serializable {
    private Integer Images;
    private String text;

    public Integer getImages() {
        return Images;
    }

    public void setImages(Integer images) {
        Images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ToolsTestData{" +
                "Images='" + Images + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
