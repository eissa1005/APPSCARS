package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CarTypeModel {
    @SerializedName("result")
    private List<CarType> result;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public List<CarType> getResult() {
        return result;
    }

    public void setResult(List<CarType> result) {
        this.result = result;
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
    @Override
    public String toString(){
        return
                "CarTypeModel{" +
                        "result = '" + result + '\'' +
                        ",success = '" + success + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
