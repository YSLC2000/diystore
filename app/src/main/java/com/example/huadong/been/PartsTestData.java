package com.example.huadong.been;

import java.io.Serializable;

public class PartsTestData implements Serializable {
    private String partName;
    private String partParameter;
    private Integer partImage;
    private Integer partPrice;
    private String partTime;
    private String partType;
    public PartsTestData(){

    }
    public PartsTestData(String partName,String partParameter,String partType,Integer partPrice,String partTime){
        this.partName=partName;
        this.partParameter=partParameter;
        this.partType=partType;
        this.partPrice=partPrice;
        this.partTime=partTime;
    }

    public String getPartTime() {
        return partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    private String type;
    private Integer partId;

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
                ", partTime='" + partTime + '\'' +
                ", type='" + type + '\'' +
                ", partId=" + partId +
                '}';
    }
}
