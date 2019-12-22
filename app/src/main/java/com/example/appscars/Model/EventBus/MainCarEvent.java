package com.example.appscars.Model.EventBus;

import com.example.appscars.Model.Response.MainCar;

import java.util.List;

public class MainCarEvent {

    private boolean success;
    private String message;
    private List<MainCar> mainCarList;

    public MainCarEvent(boolean success, List<MainCar> mainCarList) {
        this.success = success;
        this.mainCarList = mainCarList;
    }

    public MainCarEvent(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MainCar> getMainCarList() {
        return mainCarList;
    }

    public void setMainCarList(List<MainCar> mainCarList) {
        this.mainCarList = mainCarList;
    }
}
