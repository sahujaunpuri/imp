package com.gnnsnowszerro.psngiftcardsgenerator.models;

/**
 * Created by mykola on 17.06.17.
 */

public class Coupon {
    private String desc;
    private int logo;
    private int price;

    public String getDesc() {
        return desc;
    }

    public int getLogo() {
        return logo;
    }

    public int getPrice() {
        return price;
    }

    public Coupon(String desc, int logo, int price) {

        this.desc = desc;
        this.logo = logo;
        this.price = price;
    }
}
