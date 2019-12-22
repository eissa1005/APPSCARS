package com.example.appscars.UI;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import com.example.appscars.Base.BaseActivity;

@SuppressLint("Registered")
public class SplashActivity extends BaseActivity {
    private static final String TAG=SplashActivity.class.getSimpleName();
     private  static final  int  delayMillis=2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate :Called");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        },delayMillis);
    }
}
