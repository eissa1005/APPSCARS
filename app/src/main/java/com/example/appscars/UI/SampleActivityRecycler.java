package com.example.appscars.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.appscars.API.APIManage;
import com.example.appscars.Adapter.CarBrandAdapter;
import com.example.appscars.Common.Common;
import com.example.appscars.R;
import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SampleActivityRecycler extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_cell);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        compositeDisposable.add(APIManage.getApi().GetCarBrand(Common.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(carBrandModel -> {
                    if (carBrandModel.isSuccess()) {
                        Log.d("carBrandModel:size ",String.valueOf(carBrandModel.getResult().size()));
                        CarBrandAdapter adapter = new CarBrandAdapter(getApplicationContext(),carBrandModel.getResult());
                        recyclerView.setAdapter(adapter);
                       // adapter.setItems(carBrandModel.getResult());
                    } else {
                        Toast.makeText(SampleActivityRecycler.this, "Get Car Brand" + carBrandModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }, throwable -> {
                    Toast.makeText(SampleActivityRecycler.this, " Throwable Car Brand" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("CarBrands", throwable.getMessage());
                }));

    }


}
