package com.example.appscars.Model.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MainModel{

	@SerializedName("result")
	private List<MainCar> result;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResult(List<MainCar> result){
		this.result = result;
	}

	public List<MainCar> getResult(){
		return result;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"MainModel{" + 
			"result = '" + result + '\'' + 
			",success = '" + success + '\'' +
			",message = '" + message + '\'' +
			"}";
		}
}