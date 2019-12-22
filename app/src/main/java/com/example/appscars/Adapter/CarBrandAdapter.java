package com.example.appscars.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appscars.API.APIManage;
import com.example.appscars.Common.Common;
import com.example.appscars.Interface.IRecyclerOnClickListener;
import com.example.appscars.Model.EventBus.CarBrandEvent;
import com.example.appscars.Model.Response.CarBrand;
import com.example.appscars.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.CarBrandHolder> {

    Context mContext;
    List<CarBrand> carBrandList;
    CompositeDisposable compositeDisposable;
    static final String TAG = "CarBrandAdapter";

    public CarBrandAdapter(Context mContext, List<CarBrand> carBrandList) {
        this.mContext = mContext;
        this.carBrandList = carBrandList;
    }

    public  void Stop(){
        compositeDisposable.clear();
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
        holder.setOnRecyclerOnClickListener(new IRecyclerOnClickListener() {
            @Override
            public void OnClick(View view, int position) {
                compositeDisposable.add(APIManage.getApi().GetCarBrand(Common.API_KEY)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(carBrandModel -> {
                            if (carBrandModel.isSuccess()) {
                                Log.d(TAG, "carBrandModel:Size " + String.valueOf(carBrandModel.getResult().size()));
                                Log.d(TAG, "carBrandModel:Name " + String.valueOf(carBrandModel.getResult().get(0).getCarBrand()));
                                EventBus.getDefault().postSticky(new CarBrandEvent(true, carBrandModel.getResult()));
                            } else {
                                Toast.makeText(mContext.getApplicationContext(), "Get Car Brand" + carBrandModel.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }, throwable -> {
                            Toast.makeText(mContext.getApplicationContext(), " Throwable Car Brand" + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                        }));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (carBrandList == null) return 0;
        else
            return carBrandList.size();
    }

    public class CarBrandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.txt_carBrand)
        TextView txt_carBrand;

        IRecyclerOnClickListener onRecyclerOnClickListener;

        public void setOnRecyclerOnClickListener(IRecyclerOnClickListener onRecyclerOnClickListener) {
            this.onRecyclerOnClickListener = onRecyclerOnClickListener;
        }

        Unbinder unbinder;

        public CarBrandHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRecyclerOnClickListener.OnClick(v, getAdapterPosition());
        }
    }
}
