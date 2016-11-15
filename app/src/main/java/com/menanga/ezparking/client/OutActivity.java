package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.menanga.ezparking.R;

public class OutActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView mScannerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
    @Override
    public void onPause(){
        super.onPause();
        mScannerView.stopCamera();
    }
    @Override
    public void handleResult(Result result) {
        //Log.e("handler", result.getText());
        // Log.e("handler", result.getBarcodeFormat().toString());
        Intent ints = new Intent(getBaseContext(),CodeResultActivity.class);
        startActivityForResult(ints, 0);
    }
}
