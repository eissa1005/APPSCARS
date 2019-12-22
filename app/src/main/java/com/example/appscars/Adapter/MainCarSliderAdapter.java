package com.example.appscars.Adapter;

import android.content.Context;

import com.example.appscars.Model.Response.MainCar;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainCarSliderAdapter extends SliderAdapter {
    Context mContext;
    List<MainCar>  mainCarList;

    public MainCarSliderAdapter(List<MainCar>  mainCarList) {
        this.mainCarList =mainCarList;
    }

    @Override
    public int getItemCount() {
       if(mainCarList == null) return 0;
       else return  mainCarList.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        imageSlideViewHolder.bindImageSlide(mainCarList.get(position).getImage());
    }
}
