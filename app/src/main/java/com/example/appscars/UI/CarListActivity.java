package com.example.appscars.UI;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;
import com.example.appscars.API.APIManage;
import com.example.appscars.Adapter.CarListAdapter;
import com.example.appscars.Base.BaseActivity;
import com.example.appscars.Common.Common;
import com.example.appscars.Model.Response.CAR;
import com.example.appscars.R;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class CarListActivity extends BaseActivity {

    public  static  final  String TAG =CarListActivity.class.getName();

    @BindView(R.id.RecyclerView_carList)
    RecyclerView recyclerView_carList;
    @BindView(R.id.toolbar_carList)
    Toolbar toolbar;
    CompositeDisposable compositeDisposable;
    LayoutAnimationController layoutAnimationController;
    LinearLayoutManager linearLayoutManager;
    CarListAdapter adapter;
    AlertDialog mDialog;

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        init();
        initView();
        loadAllCars();
    }

    private void initView() {
        Log.d(TAG,"initView:Called");
        ButterKnife.bind(activity);

      // toolbar.setTitle(R.string.cars);
      // setSupportActionBar(toolbar);
      // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      // getSupportActionBar().setDisplayShowHomeEnabled(true);


        linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView_carList.setLayoutManager(linearLayoutManager);
        recyclerView_carList.addItemDecoration(new DividerItemDecoration(activity,linearLayoutManager.getOrientation()));
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(activity,R.anim.layout_item_from_left);
        recyclerView_carList.setLayoutAnimation(layoutAnimationController);



    }

    public void displayCars(List<CAR> carList) {
        Log.d(TAG, "displayCars");
        Log.d(TAG, "displayCars: size: " + carList.size());
        adapter = new CarListAdapter(activity, carList);
        recyclerView_carList.setAdapter(adapter);
    }

    public void loadAllCars() {
        mDialog.show();
        compositeDisposable.add(APIManage.getApi().GetALLCar(Common.API_KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(carModel -> {
            if(carModel.isSuccess()){
                displayCars(carModel.getResult());
                mDialog.dismiss();
            }else{
                Toast.makeText(activity, " Get Car Falied"+carModel.getMessage(), Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        },throwable -> {
            Toast.makeText(activity, " Get Car Falied"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            mDialog.dismiss();
        }));
    }

    private void init() {
        Log.d(TAG,"init:Called");
        compositeDisposable = new CompositeDisposable();
        mDialog=new SpotsDialog.Builder().setContext(activity).setCancelable(false).build();

    }


}
