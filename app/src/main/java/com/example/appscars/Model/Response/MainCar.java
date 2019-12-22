package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;

public class MainCar {

	@SerializedName("id")
	private int id;

	@SerializedName("Desc_ar")
	private String descAr;

	@SerializedName("Desc_en")
	private String descEn;

	@SerializedName("Image")
	private String image;

	public void setDescEn(String descEn){
		this.descEn = descEn;
	}

	public String getDescEn(){
		return descEn;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDescAr(String descAr){
		this.descAr = descAr;
	}

	public String getDescAr(){
		return descAr;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	@Override
 	public String toString(){
		return 
			"MainCar{" +
			"desc_en = '" + descEn + '\'' + 
			",id = '" + id + '\'' + 
			",desc_ar = '" + descAr + '\'' + 
			",image = '" + image + '\'' + 
			"}";
		}
}