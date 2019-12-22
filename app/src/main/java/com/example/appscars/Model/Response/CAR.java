package com.example.appscars.Model.Response;
import com.google.gson.annotations.SerializedName;

public class CAR {

	@SerializedName("Car_No")
	private String cARNo;

	@SerializedName("Car_Status")
	private String cARStatus;

	@SerializedName("Pay_Type")
	private String payType;

	@SerializedName("City")
	private String city;

	@SerializedName("Car_Photo")
	private String cARPhoto;

	@SerializedName("Check_Photo")
	private String checkPhoto;

	@SerializedName("CarID")
	private int carID;

	@SerializedName("Colors")
	private String colors;

	@SerializedName("Car_Price")
	private int cARPrice;

	@SerializedName("Check_Date")
	private String checkDate;

	@SerializedName("Car_Brand")
	private String cARBrand;

	@SerializedName("Car_Type")
	private String cARType;

	@SerializedName("Category_Type")
	private String categoryType;

	@SerializedName("Car_Size")
	private String carSize;

	@SerializedName("Check_Status")
	private String checkStatus;

	@SerializedName("Notes")
	private String notes;

	@SerializedName("Car_Model")
	private String cARModel;

	@SerializedName("Location")
	private String location;

	public void setCARNo(String cARNo){
		this.cARNo = cARNo;
	}

	public String getCARNo(){
		return cARNo;
	}

	public void setCARStatus(String cARStatus){
		this.cARStatus = cARStatus;
	}

	public String getCARStatus(){
		return cARStatus;
	}

	public void setPayType(String payType){
		this.payType = payType;
	}

	public String getPayType(){
		return payType;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setCARPhoto(String cARPhoto){
		this.cARPhoto = cARPhoto;
	}

	public String getCARPhoto(){
		return cARPhoto;
	}

	public void setCheckPhoto(String checkPhoto){
		this.checkPhoto = checkPhoto;
	}

	public String getCheckPhoto(){
		return checkPhoto;
	}

	public void setCarID(int carID){
		this.carID = carID;
	}

	public int getCarID(){
		return carID;
	}

	public void setColors(String colors){
		this.colors = colors;
	}

	public String getColors(){
		return colors;
	}

	public void setCARPrice(int cARPrice){
		this.cARPrice = cARPrice;
	}

	public int getCARPrice(){
		return cARPrice;
	}

	public void setCheckDate(String checkDate){
		this.checkDate = checkDate;
	}

	public String getCheckDate(){
		return checkDate;
	}

	public void setCARBrand(String cARBrand){
		this.cARBrand = cARBrand;
	}

	public String getCARBrand(){
		return cARBrand;
	}

	public void setCARType(String cARType){
		this.cARType = cARType;
	}

	public String getCARType(){
		return cARType;
	}

	public void setCategoryType(String categoryType){
		this.categoryType = categoryType;
	}

	public String getCategoryType(){
		return categoryType;
	}

	public void setCarSize(String carSize){
		this.carSize = carSize;
	}

	public String getCarSize(){
		return carSize;
	}

	public void setCheckStatus(String checkStatus){
		this.checkStatus = checkStatus;
	}

	public String getCheckStatus(){
		return checkStatus;
	}

	public void setNotes(String notes){
		this.notes = notes;
	}

	public String getNotes(){
		return notes;
	}

	public void setCARCAR_NoModel(String cARModel){
		this.cARModel = cARModel;
	}

	public String getCARModel(){
		return cARModel;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"CAR{" +
			"cAR_No = '" + cARNo + '\'' + 
			",cAR_Status = '" + cARStatus + '\'' + 
			",pay_Type = '" + payType + '\'' + 
			",city = '" + city + '\'' + 
			",cAR_Photo = '" + cARPhoto + '\'' + 
			",check_Photo = '" + checkPhoto + '\'' + 
			",carID = '" + carID + '\'' + 
			",colors = '" + colors + '\'' + 
			",cAR_Price = '" + cARPrice + '\'' + 
			",check_Date = '" + checkDate + '\'' + 
			",cAR_Brand = '" + cARBrand + '\'' + 
			",cAR_Type = '" + cARType + '\'' + 
			",category_Type = '" + categoryType + '\'' + 
			",car_Size = '" + carSize + '\'' + 
			",check_Status = '" + checkStatus + '\'' + 
			",notes = '" + notes + '\'' + 
			",cAR_Model = '" + cARModel + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}
}