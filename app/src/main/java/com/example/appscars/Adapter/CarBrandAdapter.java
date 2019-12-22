package com.example.appscars.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
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
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.CarBrandHolder> {
    static final String TAG = "CarBrandAdapter";

    Context mContext;
    List<CarBrand> carBrandList;
    private SparseBooleanArray expandStates = new SparseBooleanArray();

    public CarBrandAdapter(Context mContext, List<CarBrand> carBrandList) {
        this.mContext = mContext;
        this.carBrandList = carBrandList;

        for (int i = 0; i < carBrandList.size(); i++) {
            expandStates.append(i, false);
        }
    }

    @NonNull
    @Override
    public CarBrandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_brand, parent, false);
        return new CarBrandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarBrandHolder holder, int position) {
        final CarBrand carBrand = carBrandList.get(position);
        holder.setIsRecyclable(false);
        holder.txt_carBrand.setText(new StringBuilder(carBrandList.get(position).getCarBrand()));
        holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorRecycler));
        holder.expansionLayout.setBackgroundColor(ContextCompat.getColor(mContext,R.color.bt_blue_pressed));

    }

    @Override
    public int getItemCount() {
        if (carBrandList == null) return 0;
        else
            return carBrandList.size();
    }

    private void onClickButton(final ExpansionLayout expansionLayout) {
        expansionLayout.toggle(true);
    }

    public class CarBrandHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.txt_carBrand)
        TextView txt_carBrand;
        @BindView(R.id.expansionLayout)
        ExpansionLayout expansionLayout;

        Unbinder unbinder;

        public CarBrandHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }

    }
}
