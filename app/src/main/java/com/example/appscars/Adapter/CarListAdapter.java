package com.example.appscars.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appscars.Model.Response.CAR;
import com.example.appscars.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListHolder> {
    Context mContext;
    List<CAR> carList;

    public CarListAdapter(Context mContext, List<CAR> carList) {
        this.mContext = mContext;
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_layout, parent, false);
        return new CarListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListHolder holder, int position) {
        Picasso.get().load(carList.get(position).getCarPhoto()).into(holder.img_car);
        holder.txt_car_name.setText(carList.get(position).getCarBrand());
        holder.txt_carno.setText(new StringBuilder("Ref :").append(carList.get(position).getCarNo()));
        holder.txt_price_car.setText(new StringBuilder("EG ").append(carList.get(position).getCarPrice()));
        holder.txt_car_size.setText(new StringBuilder("Size : ").append(carList.get(position).getCarSize()));
        holder.txt_car_color.setText(new StringBuilder("Color : ").append(carList.get(position).getColors()));
    }

    @Override
    public int getItemCount() {
        if (carList == null) return 0;
        else
            return carList.size();
    }

    public class CarListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_car)
        ImageView img_car;
        @BindView(R.id.txt_car_name)
        TextView txt_car_name;
        @BindView(R.id.txt_carno)
        TextView txt_carno;
        @BindView(R.id.txt_price_car)
        TextView txt_price_car;
        @BindView(R.id.txt_car_size)
        TextView txt_car_size;
        @BindView(R.id.txt_car_color)
        TextView txt_car_color;

        Unbinder unbinder;

        public CarListHolder(@NonNull View itemView) {
            super(itemView);
            Object target;
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}
