package com.example.appscars.API;


import com.example.appscars.Model.Response.CAR;
import com.example.appscars.Model.Response.CARModel;
import com.example.appscars.Model.Response.CarBrand;
import com.example.appscars.Model.Response.CarBrandModel;
import com.example.appscars.Model.Response.CarTypeModel;
import com.example.appscars.Model.Response.MainModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
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


}

