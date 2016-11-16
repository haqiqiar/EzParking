package com.menanga.ezparking.server;

import android.content.DialogInterface;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import com.menanga.ezparking.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sscan);
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
        Log.e("handler", result.getText());
        Log.e("handler", result.getBarcodeFormat().toString());
        View input = LayoutInflater.from(this).inflate(R.layout.detail_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(input);
        builder.setPositiveButton("Add to MyTickets", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Berhasil ditambahkan ke MyTickets", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        AlertDialog alert = builder.create();
        alert.show();

    }
}
