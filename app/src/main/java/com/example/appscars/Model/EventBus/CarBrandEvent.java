package com.example.appscars.Model.EventBus;

import com.example.appscars.Model.Response.CarBrand;

import java.util.List;

public class CarBrandEvent {

    private  boolean isSuccess;
    private String message;
    private List<CarBrand> brandList;

    public CarBrandEvent(boolean isSuccess, List<CarBrand> brandList) {
        this.isSuccess = isSuccess;
        this.brandList = brandList;
    }

    public CarBrandEvent(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CarBrand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<CarBrand> brandList) {
        this.brandList = brandList;
    }
}
