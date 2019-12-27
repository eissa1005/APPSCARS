package com.example.appscars.UI;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appscars.API.APIManage;
import com.example.appscars.Adapter.CarBrandAdapters;
import com.example.appscars.Adapter.CarTypeAdapter;
import com.example.appscars.Adapter.CarTypeAdapters;
import com.example.appscars.Base.BaseActivity;
import com.example.appscars.Common.Common;
import com.example.appscars.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class AddCarActivity extends BaseActivity {

    private static final String TAG = AddCarActivity.class.getName();
    @BindView(R.id.listView_carBrand)
    ListView listView_carBrand;
    @BindView(R.id.listView_CarType)
    ListView listView_CarType;
    @BindView(R.id.list_carstatus)
    ListView listView_carStatus;
    @BindView(R.id.list_category_type)
    ListView list_category;
    @BindView(R.id.lstView_CarModel)
    ListView lstView_CarModel;
    @BindView(R.id.btn_check_Photo)
    Button btn_checkPhoto;
    @BindView(R.id.list_check_Status)
    ListView listView_checkStatus;
    @BindView(R.id.list_pay_type)
    ListView list_pay_type;
    @BindView(R.id.list_Car_City)
    ListView list_Car_City;
    @BindView(R.id.edit_Price)
    EditText edit_Price;
    @BindView(R.id.edit_check_date)
    EditText check_Date;
    @BindView(R.id.btn_AddCar)
    Button btn_AddCar;
    @BindView(R.id.selectCarBrand)
    TextView selectCarBrand;
    @BindView(R.id.selectCarType)
    TextView selectCarType;
    @BindView(R.id.selectCarModel)
    TextView selectCarModel;
    @BindView(R.id.selectCategoryType)
    TextView selectCategoryType;
    @BindView(R.id.selectCarStatus)
    TextView selectCarStatus;
    @BindView(R.id.selectCheckStatus)
    TextView selectCheckStatus;
    @BindView(R.id.selectPayType)
    TextView selectPayType;
    @BindView(R.id.selectCity)
    TextView selectCity;

    CompositeDisposable compositeDisposable;
    LayoutAnimationController layoutAnimationController;
    AlertDialog mDialog;
    String[] lstStatus = {"NEW", "USED"};
    String[] lstCategory = {"Automatic", "Manual"};
    String[] lstPayType = {"Cash", "Credit"};
    String[] lstCheckStatus = {"Valid", "Expired"};

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
        loadCarType();
        loadCarStatus();
        loadCategory();
        loadCarModel();
        loadCheckStatus();
        loadPayType();
        loadCity();

    }

    private void loadCity() {
        Log.d(TAG, "loadCity:display");
        ArrayAdapter adapter = new ArrayAdapter<String>(activity,R.layout.item_carcity_layout,getResources().getStringArray(R.array.lstCity));
        list_Car_City.setAdapter(adapter);
        list_Car_City.setOnItemClickListener(((parent, view, position, id) -> {
             selectCity.setText(getResources().getStringArray(R.array.lstCity)[position]);
        }));
    }

    private void loadPayType() {
        Log.d(TAG, "loadPayType:display");
        ArrayAdapter adapter = new ArrayAdapter<String>(activity,R.layout.item_paytype_layout,lstPayType);
        list_pay_type.setAdapter(adapter);
        list_pay_type.setOnItemClickListener(((parent, view, position, id) -> {
            selectPayType.setText(lstPayType[position]);
        }));
    }

    private void loadCheckStatus() {
        Log.d(TAG, "loadCheckStatus:display");
        ArrayAdapter adapter = new ArrayAdapter<String>(activity,R.layout.item_checkstatus_layout,lstCheckStatus);
        listView_checkStatus.setAdapter(adapter);
        listView_checkStatus.setOnItemClickListener(((parent, view, position, id) -> {
            selectCheckStatus.setText(lstCheckStatus[position]);
        }));
    }

    private void loadCarModel() {
        Log.d(TAG, "loadDate:display");
        ArrayAdapter adapter = new ArrayAdapter<String>(activity,R.layout.item_carmodel_layout,getResources().getStringArray(R.array.CarModel));
        lstView_CarModel.setAdapter(adapter);
        lstView_CarModel.setOnItemClickListener(((parent, view, position, id) -> {
            selectCarModel.setText(getResources().getStringArray(R.array.CarModel)[position]);
        }));
    }

    private void loadCategory() {
        Log.d(TAG, "loadCategory:display");
        ArrayAdapter adapter = new ArrayAdapter<String>(activity,R.layout.item_category_layout,lstCategory);
        list_category.setAdapter(adapter);
        list_category.setOnItemClickListener(((parent, view, position, id) -> {
            selectCategoryType.setText(lstCategory[position]);
        }));
    }

    public void loadCarType() {
        mDialog.show();
        compositeDisposable.add(APIManage.getApi().GetCarType(Common.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(carTypeModel -> {
                    if (carTypeModel.isSuccess()) {
                        Log.d(TAG, "CarType:Size " + String.valueOf(carTypeModel.getResult().size()));
                        // EventBus.getDefault().post(new CarBrandEvent(true, carBrandModel.getResult()));
                        listView_CarType.setAdapter(new CarTypeAdapters(getApplicationContext(),carTypeModel.getResult()));
                        listView_CarType.setOnItemClickListener(((parent, view, position, id) -> {
                        selectCarType.setText(carTypeModel.getResult().get(position).getCarType());
                        }));
                        mDialog.dismiss();
                    } else {
                        Toast.makeText(activity, "Get Car Type " + carTypeModel.getMessage(), Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                }, throwable -> {
                    Toast.makeText(activity, " Throwable Car Type" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("CarBrands",throwable.getMessage());
                    mDialog.dismiss();
                }));

    }

    @Override
    protected void onStart() {
        super.onStart();
        //EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        // EventBus.getDefault().unregister(this);
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

    public void loadCarBrand() {
        mDialog.show();
        compositeDisposable.add(APIManage.getApi().GetCarBrand(Common.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(carBrandModel -> {
                    if (carBrandModel.isSuccess()) {
                        Log.d(TAG, "carBrandModel:Size " + String.valueOf(carBrandModel.getResult().size()));
                        // EventBus.getDefault().post(new CarBrandEvent(true, carBrandModel.getResult()));
                       listView_carBrand.setAdapter(new CarBrandAdapters(getApplicationContext(),carBrandModel.getResult()));
                       listView_carBrand.setOnItemClickListener(((parent, view, position, id) -> {
                       selectCarBrand.setText(carBrandModel.getResult().get(position).getCarBrand());
                       }));
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

    public  void loadCarStatus(){
        Log.d(TAG, "loadCarStatus:display");
        ArrayAdapter adapter = new ArrayAdapter<String>(activity,R.layout.item_carstatus_layout,lstStatus);
        listView_carStatus.setAdapter(adapter);
        listView_carStatus.setOnItemClickListener(((parent, view, position, id) -> {
            selectCarStatus.setText(lstStatus[position]);
        }));
    }

    @OnClick(R.id.btn_AddCar)
    public  void  AddCar(){

    }

}
