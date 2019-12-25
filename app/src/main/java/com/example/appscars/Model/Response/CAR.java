package com.example.appscars.Model.Response;
import com.google.gson.annotations.SerializedName;

public class CAR {

	@SerializedName("Car_No")
	private String Car_No;

	@SerializedName("Car_Status")
	private String Car_Status;

	@SerializedName("Pay_Type")
	private String Pay_Type;

	@SerializedName("City")
	private String City;

	@SerializedName("Car_Photo")
	private String Car_Photo;

	@SerializedName("Check_Photo")
	private String Check_Photo;

	@SerializedName("CarID")
	private int CarID;

	@SerializedName("Colors")
	private String Colors;

	@SerializedName("Car_Price")
	private int Car_Price;

	@SerializedName("Check_Date")
	private String Check_Date;

	@SerializedName("Car_Brand")
	private String Car_Brand;

	@SerializedName("Car_Type")
	private String Car_Type;

	@SerializedName("Category_Type")
	private String Category_Type;

	@SerializedName("Car_Size")
	private String Car_Size;

	@SerializedName("Check_Status")
	private String Check_Status;

	@SerializedName("Notes")
	private String Notes;

	@SerializedName("Car_Model")
	private String Car_Model;

	@SerializedName("Location")
	private String Location;

  public String getCarNo() {
    return Car_No;
  }

  public void setCarNo(String car_No) {
    Car_No = car_No;
  }

  public String getCarStatus() {
    return Car_Status;
  }

  public void setCarStatus(String car_Status) {
    Car_Status = car_Status;
  }

  public String getPayType() {
    return Pay_Type;
  }

  public void setPayType(String pay_Type) {
    Pay_Type = pay_Type;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String city) {
    City = city;
  }

  public String getCarPhoto() {
    return Car_Photo;
  }

  public void setCarPhoto(String car_Photo) {
    Car_Photo = car_Photo;
  }

  public String getCheckPhoto() {
    return Check_Photo;
  }

  public void setCheckPhoto(String check_Photo) {
    Check_Photo = check_Photo;
  }

  public int getCarID() {
    return CarID;
  }

  public void setCarID(int carID) {
    CarID = carID;
  }

  public String getColors() {
    return Colors;
  }

  public void setColors(String colors) {
    Colors = colors;
  }

  public int getCarPrice() {
    return Car_Price;
  }

  public void setCarPrice(int car_Price) {
    Car_Price = car_Price;
  }

  public String getCheckDate() {
    return Check_Date;
  }

  public void setCheckDate(String check_Date) {
    Check_Date = check_Date;
  }

  public String getCarBrand() {
    return Car_Brand;
  }

  public void setCarBrand(String car_Brand) {
    Car_Brand = car_Brand;
  }

  public String getCarType() {
    return Car_Type;
  }

  public void setCarType(String car_Type) {
    Car_Type = car_Type;
  }

  public String getCategoryType() {
    return Category_Type;
  }

  public void setCategoryType(String category_Type) {
    Category_Type = category_Type;
  }

  public String getCarSize() {
    return Car_Size;
  }

  public void setCarSize(String car_Size) {
    Car_Size = car_Size;
  }

  public String getCheckStatus() {
    return Check_Status;
  }

  public void setCheckStatus(String check_Status) {
    Check_Status = check_Status;
  }

  public String getNotes() {
    return Notes;
  }

  public void setNotes(String notes) {
    Notes = notes;
  }

  public String getCarModel() {
    return Car_Model;
  }

  public void setCarModel(String car_Model) {
    Car_Model = car_Model;
  }

  public String getLocation() {
    return Location;
  }

  public void setLocation(String location) {
    Location = location;
  }

  @Override
 	public String toString(){
		return
			"CAR{" +
			"Car_No = '" + Car_No + '\'' +
			",Car_No_Status = '" + Car_Status + '\'' +
			",Pay_Type = '" + Pay_Type + '\'' +
			",City = '" + City + '\'' +
			",Car_Photo = '" + Car_Photo + '\'' +
			",Check_Photo = '" + Check_Photo + '\'' +
			",CarID = '" + CarID + '\'' +
			",Colors = '" + Colors + '\'' +
			",Car_Price = '" + Car_Price + '\'' +
			",Check_Date = '" + Check_Date + '\'' +
			",Car_Brand = '" + Car_Brand + '\'' +
			",Car_Type = '" + Car_Type + '\'' +
			",Category_Type = '" + Category_Type + '\'' +
			",Car_Size = '" + Car_Size + '\'' +
			",Check_Status = '" + Check_Status + '\'' +
			",Notes = '" + Notes + '\'' +
			",Car_Model = '" + Car_Model + '\'' +
			",location = '" + Location + '\'' +
			"}";
		}
}