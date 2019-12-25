package com.example.appscars.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appscars.Model.Response.CarBrand;
import com.example.appscars.R;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.CarBrandHolder> {
    static final String TAG = "CarBrandAdapter";

    Context mContext;
    List<CarBrand> carBrandList;


    public CarBrandAdapter(Context mContext, List<CarBrand> carBrandList) {
        this.mContext = mContext;
        this.carBrandList = carBrandList;
    }

    @NonNull
    @Override
    public CarBrandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_brand, parent, false);
        return new CarBrandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarBrandHolder holder, int position) {
        holder.txt_carBrand.setText(new StringBuilder(carBrandList.get(position).getCarBrand()));

    }

    @Override
    public int getItemCount() {
        if (carBrandList == null) return 0;
        else
            return carBrandList.size();
    }
    public void setItems(List<CarBrand> items) {
        this.carBrandList.addAll(items);
        notifyDataSetChanged();
    }

    public class CarBrandHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.txt_carBrand)
        TextView txt_carBrand;



        Unbinder unbinder;
        public CarBrandHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }



    }
}
