package com.example.appscars.Model.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserModel{

	@SerializedName("success")
	private boolean success;
	@SerializedName("message")
	private String message;
	@SerializedName("result")
	private List<Users> result;

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

	public List<Users> getResult() {
		return result;
	}

	public void setResult(List<Users> result) {
		this.result = result;
	}

	@Override
 	public String toString(){
		return 
			"UserModel{" + 
			"result = '" + result + '\'' + 
			",success = '" + success + '\'' +
			",message = '" + message + '\'' +
			"}";
		}
}