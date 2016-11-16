package com.menanga.ezparking.server;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.menanga.ezparking.R;

import java.util.Timer;
import java.util.TimerTask;

public class SMainActivity extends AppCompatActivity {
    private Handler handler;
    private SliderAdapter sAdapter;
    private CustomViewPager slider;
    private int position =0;
    private int delay = 2000;
    private int currentPage;
    private int NUM_PAGES;

    Runnable runnable = new Runnable() {
        public void run() {
            if (sAdapter.getCount() == currentPage) {
                currentPage= 0;
            } else {
                currentPage++;
            }
            slider.setCurrentItem(currentPage, true);
            handler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_access_time_black_24dp);
        setContentView(R.layout.activity_smain);
        Button scan = (Button) findViewById(R.id.btnScan);
        Button history = (Button) findViewById(R.id.btnHistory);
        Button find = (Button) findViewById(R.id.btnFind);
        Button profile = (Button) findViewById(R.id.btnProfile);

        slider = (CustomViewPager) findViewById(R.id.fslider);
        slider.setOffscreenPageLimit(2);

        sAdapter = new SliderAdapter(this);
        slider.setAdapter(sAdapter);
        handler = new Handler();



        currentPage = 0;
        NUM_PAGES = 2;


        profile.setOnClickListener(op);
        find.setOnClickListener(op);
        scan.setOnClickListener(op);
        history.setOnClickListener(op);
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }



    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnScan:
                    openIntent(SScanActivity.class);
                    break;
                case R.id.btnHistory:
                    openIntent(SHistoryActivity.class);
                    break;
                case R.id.btnFind:
                    openIntent(SFindActivity.class);
                    break;
                case R.id.btnProfile:
                    openIntent(SProfileActivity.class);
                    break;
            }
        }
    };

    private void openIntent(Class x){
        Intent intent = new Intent(getBaseContext(), x);
        startActivityForResult(intent, 0);
    }



}
