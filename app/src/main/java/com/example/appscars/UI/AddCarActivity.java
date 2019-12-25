package com.example.appscars.UI;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appscars.API.APIManage;
import com.example.appscars.Adapter.CarBrandAdapter;
import com.example.appscars.Adapter.CarTypeAdapter;
import com.example.appscars.Base.BaseActivity;
import com.example.appscars.Common.Common;
import com.example.appscars.Model.EventBus.CarBrandEvent;
import com.example.appscars.Model.Response.CarBrand;
import com.example.appscars.Model.Response.CarType;
import com.example.appscars.R;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.google.android.material.textfield.TextInputEditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class AddCarActivity extends BaseActivity {

    private static final String TAG = AddCarActivity.class.getName();
    @BindView(R.id.recycler_carBrand)
    RecyclerView recycler_carBrand;
    @BindView(R.id.recycler_carType)
    RecyclerView recycler_carType;
    @BindView(R.id.listView_carStatus)
    ListView listView_carStatus;
    @BindView(R.id.list_category)
    ListView list_category;
    @BindView(R.id.car_Model)
    TextInputEditText car_Model;
    @BindView(R.id.btn_check_Photo)
    Button btn_checkPhoto;
    @BindView(R.id.check_staus)
    TextInputEditText check_staus;
    @BindView(R.id.car_city)
    TextInputEditText car_City;
    @BindView(R.id.recycler_payType)
    RecyclerView recycler_payType;
    @BindView(R.id.car_Price)
    TextInputEditText car_Price;
    @BindView(R.id.check_Date)
    TextInputEditText check_Date;
    @BindView(R.id.btn_AddCar)
    Button btn_AddCar;
    @BindView(R.id.expansionLayout)
    ExpansionLayout expansionLayout;

    CompositeDisposable compositeDisposable;
    LayoutAnimationController layoutAnimationController;
    AlertDialog mDialog;
    String[] lstStatus = {"NEW", "USED"};
    String[] lstCategory = {"Automatic", "Manual"};

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        Log.d(TAG, "onCreate:Called");
        init();
        initView();
        loadCarBrand();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void initView() {
        Log.d(TAG, "initView:Called");
        ButterKnife.bind(activity);

    }

    private void init() {
        compositeDisposable = new CompositeDisposable();
        mDialog = new SpotsDialog.Builder().setContext(activity).setCancelable(false).build();

    }

    // Load Data From Server
   // @OnClick(R.id.headerIndicator)
    public void loadCarBrand() {
        mDialog.show();
        compositeDisposable.add(APIManage.getApi().GetCarBrand(Common.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(carBrandModel -> {
                    if (carBrandModel.isSuccess()) {
                        Log.d(TAG, "carBrandModel:Size " + String.valueOf(carBrandModel.getResult().size()));
                        EventBus.getDefault().post(new CarBrandEvent(true, carBrandModel.getResult()));
                        mDialog.dismiss();
                    } else {
                        Toast.makeText(activity, "Get Car Brand" + carBrandModel.getMessage(), Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                }, throwable -> {
                    Toast.makeText(activity, " Throwable Car Brand" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("CarBrands",throwable.getMessage());
                    mDialog.dismiss();
                }));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void displayCarBrand(CarBrandEvent event) {
        Log.d(TAG, "displayCarBrand: called!!");
        Log.d(TAG, "displayCarBrand: "+event.getBrandList().get(0).toString());
        if (event.isSuccess()) {

            recycler_carBrand.setHasFixedSize(true);
            recycler_carBrand.setLayoutManager(new LinearLayoutManager(this));
            recycler_carBrand.setAdapter(new CarBrandAdapter(AddCarActivity.this, event.getBrandList()));
        }
    }




}
