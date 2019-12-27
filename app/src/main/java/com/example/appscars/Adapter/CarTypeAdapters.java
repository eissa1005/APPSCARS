package com.example.appscars.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appscars.Model.Response.CarType;
import com.example.appscars.R;

import java.util.List;

public class CarTypeAdapters extends BaseAdapter {

    public static  final String TAG="CarTypeAdapters";
    Context mContext;
    List<CarType> carTypeList;

    public CarTypeAdapters(Context mContext, List<CarType> carTypeList) {
        this.mContext = mContext;
        this.carTypeList = carTypeList;
    }

    @Override
    public int getCount() {
        if(carTypeList==null)return 0;
        else
         return carTypeList.size();
    }

    @Override
    public Object getItem(int position) {
        return carTypeList.get(position).getCarType();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cartype_layout, parent, false);
        }
        TextView txtCarType =(TextView)convertView.findViewById(R.id.txt_CarType);
        txtCarType.setText(carTypeList.get(position).getCarType());
        return  convertView;
    }
}
