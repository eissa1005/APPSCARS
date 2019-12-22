package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;

public class CarType {

    @SerializedName("Car_Type")
    private String Car_Type;

    public String getCarType() {
        return Car_Type;
    }

    public void setCarType(String car_Type) {
        Car_Type = car_Type;
    }

    @Override
    public String toString(){
        return
                "CarType{" +
                        "Car_Type = '" + Car_Type + '\'' +
                        "}";
    }
}
