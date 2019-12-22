package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;


public class CarBrand {

	@SerializedName("Car_Brand")
	private String Car_Brand;

	public String getCarBrand() {
		return Car_Brand;
	}

	public void setCarBrand(String car_Brand) {
		Car_Brand = car_Brand;
	}

	@Override
 	public String toString(){
		return 
		"CarBrand{" +
			"Car_Brand = '" + Car_Brand + '\'' +
			"}";
		}
}