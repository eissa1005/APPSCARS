package com.example.appscars.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.appscars.Model.Response.CarBrand;
import com.example.appscars.R;
import java.util.List;

public class CarBrandAdapters extends BaseAdapter {

    static final String TAG = "CarBrandAdapters";
    Context mContext;
    List<CarBrand> carBrandList;

    public CarBrandAdapters(Context mContext, List<CarBrand> carBrandList) {
        this.mContext = mContext;
        this.carBrandList = carBrandList;
    }

    @Override
    public int getCount() {
        if (carBrandList == null) return 0;
        else
            return carBrandList.size();
    }

    @Override
    public Object getItem(int position) {
        return carBrandList.get(position).getCarBrand();
    }

    @Override
    public long getItemId(int position) {
        return  Integer.parseInt(carBrandList.get(position).getCarID());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
           convertView =LayoutInflater.from(parent.getContext())
                   .inflate(R.layout.item_car_brand, parent, false);
        }
       TextView txtCarBrand =(TextView)convertView.findViewById(R.id.txt_carBrand);
        txtCarBrand.setText(carBrandList.get(position).getCarBrand());
        return  convertView;
    }
}
