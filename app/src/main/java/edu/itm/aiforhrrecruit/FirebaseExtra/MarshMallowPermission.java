package edu.itm.aiforhrrecruit.FirebaseExtra;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by saiso on 03-02-2017.
 */

public class MarshMallowPermission {


    public static final int CAMera_PERMISSION_REQUEST_CODE = 4;
    public static final int INTERNET_PERMISSION_REQUEST_CODE = 5;
    Activity activity;

    public MarshMallowPermission(Activity activity) {
        this.activity = activity;
    }


    public boolean checkPermissionForCamera() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPermissionForInternet() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void requestPermissionForCamera(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)){
            Toast.makeText(activity, "Calling permission needed. Please allow in App Settings for calling YoBykes Sales Team App", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CAMERA},CAMera_PERMISSION_REQUEST_CODE);
        }
    }

    public void requestPermissionForInternet(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.INTERNET)){
            Toast.makeText(activity, "Internet permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.INTERNET},INTERNET_PERMISSION_REQUEST_CODE);
        }
    }
}
