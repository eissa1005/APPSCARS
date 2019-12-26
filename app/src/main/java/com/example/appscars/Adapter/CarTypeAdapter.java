package com.example.appscars.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appscars.Model.Response.CarType;
import com.example.appscars.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarTypeAdapter extends RecyclerView.Adapter<CarTypeAdapter.CarTypeHolder> {

    Context mContext;
    List<CarType> carTypeList;

    public CarTypeAdapter(Context mContext, List<CarType> carTypeList) {
        this.mContext = mContext;
        this.carTypeList = carTypeList;
    }

    @NonNull
    @Override
    public CarTypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartype_layout, parent, false);
        return new CarTypeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarTypeHolder holder, int position) {
        holder.txt_carType.setText(carTypeList.get(position).getCarType());
    }

    @Override
    public int getItemCount() {
        if(carTypeList == null)return 0;
        else
            return carTypeList.size();
    }
    public class CarTypeHolder  extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_CarType)
        TextView txt_carType;

        Unbinder unbinder;
        public CarTypeHolder(@NonNull View itemView) {
            super(itemView);
            unbinder= ButterKnife.bind(this,itemView);

        }
    }
}
