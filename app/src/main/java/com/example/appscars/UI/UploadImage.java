package com.example.appscars.UI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.appscars.API.APIManage;
import com.example.appscars.Base.BaseActivity;
import com.example.appscars.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@SuppressLint("Registered")
public class UploadImage extends BaseActivity {

    @BindView(R.id.imagesPhoto)
    ImageView imagesPhoto;
    @BindView(R.id.title_Image)
    EditText title_Image;
    @BindView(R.id.btnChosePhoto)
    Button btnChosePhoto;
    @BindView(R.id.btnUploadPhoto)
    Button btnUploadPhoto;
    Bitmap bitmap;

    private static final String TAG = UploadImage.class.getName();
    CompositeDisposable compositeDisposable;
    private static final int PICK_IMAGE = 7777;
    AlertDialog mDialog;
    private String filePath;
    private boolean isOnlyImageAllowed=true;
    private static final int PICK_PHOTO = 7777;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_checkphoto_layout);
        Log.d(TAG, "onCreate:Called");
        //requestPermissions();
        requestPermission();
        init();
        initView();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void initView() {
        ButterKnife.bind(activity);
        Log.d(TAG, "initView:Called");
    }

    private String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    @OnClick(R.id.btnChosePhoto)
    public void choosePhoto() {
        Log.d(TAG, "choosePhoto:Called");
        Intent intent;
       // intent.setType("image/*");
        if (isOnlyImageAllowed) {
            // only image can be selected
            intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        } else {
            // any type of files including image can be selected
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file/*");
        }
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);
    }

    private String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            filePath = getPath(imageUri);
            imagesPhoto.setImageURI(imageUri);
        }
    }

    private void uploadImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
        //String imgname = String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    @OnClick(R.id.btnUploadPhoto)
    public void UploadPhoto() {
        Log.d(TAG, "UploadPhoto:Called");
        File file = new File(filePath);
        Log.d("getPath", file.getPath());
        Log.d("getName", file.getName());
        Log.d("getAbsolutePath", file.getAbsolutePath());

        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("Check_Photo", file.getName(), fileReqBody);
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "image-type");


        compositeDisposable.add(APIManage.getApi().uploadFile("KIA-99", "KIA", part)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(carModel -> {
                    mDialog.show();
                    if (carModel.isSuccess()) {
                        mDialog.dismiss();
                        Toast.makeText(activity, "Car Add" + carModel.getResult(), Toast.LENGTH_SHORT).show();
                    } else {
                        mDialog.dismiss();
                        Toast.makeText(activity, "Car Add" + carModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    mDialog.dismiss();
                }, throwable -> {
                    mDialog.dismiss();
                    Toast.makeText(activity, "Car Add" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                }));
    }

    private void init() {
        Log.d(TAG, "init:Called");
        compositeDisposable = new CompositeDisposable();
        mDialog = new SpotsDialog.Builder().setContext(activity).setCancelable(false).build();
        //imagesPhoto.setVisibility(View.GONE);
        // btnUploadPhoto.setVisibility(View.GONE);
    }



    private  void  requestPermission(){
        // Check if we have write permission
       int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


}
