package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;

public class CarBrand {

    @SerializedName("Car_Brand")
    private String Car_Brand;

    @SerializedName("CarID")
    private String CarID;


    public String getCarBrand() {
        return Car_Brand;
    }

    public void setCarBrand(String car_Brand) {
        Car_Brand = car_Brand;
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String carID) {
        CarID = carID;
    }

    @Override
    public String toString(){
        return
                "CarBrand{" +
                        "Car_Brand = '" + Car_Brand + '\'' +
                        ",CarID = '" + CarID + '\'' +
                        "}";
    }
}
