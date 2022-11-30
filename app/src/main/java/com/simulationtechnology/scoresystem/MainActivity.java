package com.simulationtechnology.scoresystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    private final static String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private final static int PERMISSION_RESULT_CODE = 1000;
    private final static int PERMISSION_NAV_RESULT = 1100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (checkPermission()) {
            //Show main fragment
        } else {
            requestPermission();
        }
    }

    private boolean checkPermission() {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    private void requestPermission() {
        requestPermissions(permissions, PERMISSION_RESULT_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_RESULT_CODE) {
            boolean isAllGranted = true;
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false;
                    break;
                }
            }
            if (isAllGranted) {
                //start main fragment
            } else {
                permissionDenied();
            }
        }
    }

    private void permissionDenied() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage(R.string.permission_message)
                .setPositiveButton(R.string.go_setting, (dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.fromParts("package", getPackageName(), null));
                    startActivityForResult(intent, PERMISSION_NAV_RESULT);
                })
                .setNegativeButton(R.string.exit_app, (dialog, which) -> {
                    dialog.dismiss();
                    finish();
                })
                .create()
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PERMISSION_NAV_RESULT) {
            if (checkPermission()) {

            } else {

            }
        }
    }
}