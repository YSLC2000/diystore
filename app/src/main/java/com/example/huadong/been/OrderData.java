package com.example.huadong.been;

import java.io.Serializable;

public class OrderData implements Serializable {
    private String order_name;
    private int order_price;
    private String order_time;




    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }



    public OrderData(String order_name, int order_price,String order_time) {
        this.order_name = order_name;
        this.order_price = order_price;
        this.order_time = order_time;

    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }
    @Override
    public String toString() {
        return "OrderData{" +
                "order_name='" + order_name + '\'' +
                ", order_price=" + order_price +
                ", order_time='" + order_time + '\'' +
                '}';
    }


}
