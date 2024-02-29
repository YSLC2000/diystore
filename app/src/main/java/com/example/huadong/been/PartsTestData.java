package com.example.huadong.been;

import java.io.Serializable;

public class PartsTestData implements Serializable {
    private String partName;
    private String partParameter;
    private Integer partImage;
    private Integer partPrice;

    public Integer getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(Integer partPrice) {
        this.partPrice = partPrice;
    }


    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartParameter() {
        return partParameter;
    }

    public void setPartParameter(String partParameter) {
        this.partParameter = partParameter;
    }

    public Integer getPartImage() {
        return partImage;
    }

    public void setPartImage(Integer partImage) {
        this.partImage = partImage;
    }

    @Override
    public String toString() {
        return "PartsTestData{" +
                "partName='" + partName + '\'' +
                ", partParameter='" + partParameter + '\'' +
                ", partImage=" + partImage +
                ", partPrice=" + partPrice +
                '}';
    }
}
