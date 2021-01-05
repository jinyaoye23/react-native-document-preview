
package com.mg.documentPreview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.mogu.picturepreview.BigImgBrowse;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class RNDocumentPreviewModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNDocumentPreviewModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNDocumentPreview";
    }

    @ReactMethod
    public void preview(String url, String type) {
        if (url.endsWith("jpg") || url.endsWith("png") || url.endsWith("jpeg")) {
            String imgs[] = {url};
            Intent intent = new Intent(getCurrentActivity(), BigImgBrowse.class);
            intent.putExtra("imgUrlArr", imgs);
            intent.putExtra("currentIndex", 0);
            intent.putExtra("isShowSave", true);
            getCurrentActivity().startActivity(intent);
            ((Activity) getCurrentActivity()).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return;
        }
        String fileUrl = url;
        int index = url.lastIndexOf("/");
        String fileName = url.substring(index);
        //动态权限申请
        if (ContextCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getCurrentActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            FileDisplayActivity.actionStart(getCurrentActivity(), fileUrl, fileName,type);
        }


    }
}