package com.example.appscars.Model.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CARModel{

	@SerializedName("result")
	private List<CAR> result;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public List<CAR> getResult() {
		return result;
	}

	public void setResult(List<CAR> result) {
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
			"CARModel{" + 
			"result = '" + result + '\'' + 
			",success = '" + success + '\'' +
			",message = '" + message + '\'' +
			"}";
		}
}