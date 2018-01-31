package com.example.umarsaeedkhan.fyp_foodies;

/**
 * Created by Shah on 2017-10-31.
 */

public class RestaurantsData {
    private String restName;
    private String restDesc;

    public String getRestID() {
        return restID;
    }

    public void setRestID(String restID) {
        this.restID = restID;
    }

    private String restID;

    public RestaurantsData(){ }

    public RestaurantsData(String restName, String restDesc, String restImage, String deliveryTime) {
        super();
        this.restName = restName;
        this.restDesc = restDesc;
        this.restImage = restImage;
        this.deliveryTime = deliveryTime;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestDesc() {
        return restDesc;
    }

    public void setRestDesc(String restDesc) {
        this.restDesc = restDesc;
    }

    public String getRestImage() {
        return restImage;
    }

    public void setRestImage(String restImage) {
        this.restImage = restImage;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    private String restImage;
    private String deliveryTime;

//    public void restName(String restName) {
//    }
//
//    public void restDesc(String restDesc) {
//    }
//
//    public void deliveryTime(String deliveryTime) {
//    }
//
//    public void restImage(String restImage) {
//    }
//
//    public String getImage() {
//        return restImage;
//    }
}
