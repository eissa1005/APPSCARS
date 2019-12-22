package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarBrandModel{

	@SerializedName("result")
	private List<CarBrand> result;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public List<CarBrand> getResult() {
		return result;
	}

	public void setResult(List<CarBrand> result) {
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
			"CarBrandModel{" + 
			"result = '" + result + '\'' + 
			",success = '" + success + '\'' +
			",message = '" + message + '\'' +
			"}";
		}
}