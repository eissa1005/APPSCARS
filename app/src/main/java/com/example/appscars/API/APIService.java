package com.example.appscars.API;

import com.example.appscars.Model.Response.CAR;
import com.example.appscars.Model.Response.CARModel;
import com.example.appscars.Model.Response.CarBrandModel;
import com.example.appscars.Model.Response.CarTypeModel;
import com.example.appscars.Model.Response.MainModel;

import java.util.Date;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIService {

    @GET("GetALLMain")
    Observable<MainModel> GetALLMainCar(@Query("key")String key);

    @GET("GetAllCARS")
    Observable<CARModel> GetALLCar(@Query("key")String key);

    @GET("GetCarBrand")
    Observable<CarBrandModel> GetCarBrand(@Query("key")String key);

    @GET("GetCarType")
    Observable<CarTypeModel> GetCarType(@Query("key")String key);

    @FormUrlEncoded
    @POST("AddCar")
    Observable<CARModel> AddCar(@Field("key")String key,
                                @Field("Car_NO")String Car_NO,
                                @Field("Car_Brand")String Car_Brand,
                                @Field("'Car_Type'")String Car_Type,
                                @Field("Car_Status")String Car_Status,
                                @Field("Category_Type")String Category_Type,
                                @Field("Car_Model")String Car_Model,
                                @Field("Check_Status")String Check_Status,
                                @Field("Colors")String Colors,
                                @Field("Car_Size")String Car_Size,
                                @Field("Car_Photo")String Car_Photo,
                                @Field("Check_Photo")String Check_Photo,
                                @Field("City")String City,
                                @Field("Pay_Type")String Pay_Type,
                                @Field("Car_Price")double Car_Price,
                                @Field("Check_Date") Date Check_Date,
                                @Field("Notes")String Notes);

    @FormUrlEncoded
    @POST("AddCar")
    Observable<CARModel> AddCars(@Field("key")String key, @FieldMap Map<String, CAR> carMap);

    @Multipart
    @POST("AddCar")
  Observable<CARModel> uploadFile (
                                   @Field("Car_Brand")String Car_Brand,
                                   @Field("Car_Type") String Car_Type,
                                   @Part MultipartBody.Part checkPhoto);
}

