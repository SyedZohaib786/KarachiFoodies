package com.example.umarsaeedkhan.fyp_foodies;

/**
 * Created by Shah on 2017-11-12.
 */

public class DishData {
    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    private String dishID;
    public String dishName;

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String distPrice) {
        this.dishPrice = distPrice;
    }

    public String dishPrice;

    public DishData(){}


}
