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

  public String getCar_No() {
    return Car_No;
  }

  public void setCar_No(String car_No) {
    Car_No = car_No;
  }

  public String getCar_Status() {
    return Car_Status;
  }

  public void setCar_Status(String car_Status) {
    Car_Status = car_Status;
  }

  public String getPay_Type() {
    return Pay_Type;
  }

  public void setPay_Type(String pay_Type) {
    Pay_Type = pay_Type;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String city) {
    City = city;
  }

  public String getCar_Photo() {
    return Car_Photo;
  }

  public void setCar_Photo(String car_Photo) {
    Car_Photo = car_Photo;
  }

  public String getCheck_Photo() {
    return Check_Photo;
  }

  public void setCheck_Photo(String check_Photo) {
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

  public int getCar_Price() {
    return Car_Price;
  }

  public void setCar_Price(int car_Price) {
    Car_Price = car_Price;
  }

  public String getCheck_Date() {
    return Check_Date;
  }

  public void setCheck_Date(String check_Date) {
    Check_Date = check_Date;
  }

  public String getCar_Brand() {
    return Car_Brand;
  }

  public void setCar_Brand(String car_Brand) {
    Car_Brand = car_Brand;
  }

  public String getCar_Type() {
    return Car_Type;
  }

  public void setCar_Type(String car_Type) {
    Car_Type = car_Type;
  }

  public String getCategory_Type() {
    return Category_Type;
  }

  public void setCategory_Type(String category_Type) {
    Category_Type = category_Type;
  }

  public String getCar_Size() {
    return Car_Size;
  }

  public void setCar_Size(String car_Size) {
    Car_Size = car_Size;
  }

  public String getCheck_Status() {
    return Check_Status;
  }

  public void setCheck_Status(String check_Status) {
    Check_Status = check_Status;
  }

  public String getNotes() {
    return Notes;
  }

  public void setNotes(String notes) {
    Notes = notes;
  }

  public String getCar_Model() {
    return Car_Model;
  }

  public void setCar_Model(String car_Model) {
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