package com.example.appscars.UI;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import com.example.appscars.API.APIManage;
import com.example.appscars.Adapter.MainCarAdapter;
import com.example.appscars.Adapter.MainCarSliderAdapter;
import com.example.appscars.Base.BaseActivity;
import com.example.appscars.Common.Common;
import com.example.appscars.Model.EventBus.MainCarEvent;
import com.example.appscars.Model.Response.MainCar;
import com.example.appscars.R;
import com.example.appscars.Service.PicassoImageLoadingService;
import com.example.appscars.Utility.SpaceItemDecoration;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ss.com.bannerslider.Slider;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.recycler_main)
    RecyclerView recycler_main;
    @BindView(R.id.banner_slider)
    Slider banner_slider;
    CompositeDisposable compositeDisposable;
    LayoutAnimationController layoutAnimationController;
    AlertDialog mDialog;
    MainCarAdapter carAdapter;

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started!!");
        init();
        initView();
        loadMainCars();

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        // TextView personName = headerView.findViewById(R.id.personName);
        // personName.setText(Common.currentUser.getUserName());
    }

    public void init() {
        compositeDisposable = new CompositeDisposable();
        mDialog = new SpotsDialog.Builder().setContext(activity).setCancelable(false).build();
        Slider.init(new PicassoImageLoadingService());
    }

    public void initView() {
        Log.d(TAG, "initView:Called");
        ButterKnife.bind(activity);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (carAdapter != null) {
                    switch (carAdapter.getItemViewType(position)) {
                        case Common.DEFAULT_COLUMN_COUNT:
                            return 1;
                        case Common.FULL_WIDTH_COLUMN:
                            return 2;
                        default:
                            return -1;
                    }
                } else {

                }
                return -1;
            }
        });

        recycler_main.setLayoutManager(layoutManager);
        recycler_main.addItemDecoration(new SpaceItemDecoration(8));
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(activity, R.anim.layout_item_from_left);
        recycler_main.setLayoutAnimation(layoutAnimationController);

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

    public void displayCarsSlider(List<MainCar> mainCarList) {
        Log.d(TAG, "displayBanner: called!!");
        Log.d(TAG, "displayBanner: size: " + mainCarList.size());
        banner_slider.setAdapter(new MainCarSliderAdapter(mainCarList));
    }

    public void displayCars(List<MainCar> mainCarList) {
        Log.d(TAG, "displayCars");
        Log.d(TAG, "displayCars: size: " + mainCarList.size());
        carAdapter = new MainCarAdapter(activity, mainCarList);
        recycler_main.setAdapter(carAdapter);
    }

    public void loadMainCars() {
        mDialog.show();
        compositeDisposable.add(APIManage.getApi().GetALLMainCar(Common.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mainModel -> {
                    if (mainModel.isSuccess()) {
                        EventBus.getDefault().post(new MainCarEvent(true, mainModel.getResult()));
                        mDialog.dismiss();
                    } else {
                        Toast.makeText(activity, "Main Car" + mainModel.getMessage(), Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                    mDialog.dismiss();
                }, throwable -> {
                    Toast.makeText(activity, "[Main Car Failed]" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                }));
    }

    // Listen EventBus
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadMainCarEvent(MainCarEvent event) {
        Log.d(TAG, "loadMainCarEvent:Called");
        if (event.isSuccess()) {
            Log.d(TAG, "loadMainCarEvent:isSuccess");
            displayCarsSlider(event.getMainCarList());
            int size = event.getMainCarList().size();
            Log.d("Listsize", "Size of CAR Slider : " + size);
            displayCars(event.getMainCarList());
            int sizeListRestaurant = event.getMainCarList().size();
            Log.e("sizeListCars", "Size of Cars : " + sizeListRestaurant);
        } else {
            Toast.makeText(this, "[CARS LOAD]" + event.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("Message", event.getMessage());
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int ItemId = item.getItemId();
        switch (ItemId) {
            case R.id.nav_account:
                startActivity(new Intent(MainActivity.this, SampleActivityRecycler.class));
                break;
            case R.id.nav_Advertisement:
                startActivity(new Intent(MainActivity.this, AddCarActivity.class));
                break;
            case R.id.nav_message:
                break;
            case R.id.nav_help:
                break;
            case R.id.nav_setting:
                break;
            case R.id.nav_contact:
                break;
            case R.id.nav_asked:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
