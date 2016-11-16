package com.menanga.ezparking.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.menanga.ezparking.R;

public class DetailRekapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rekap);
        Button btn_back = (Button) findViewById(R.id.btn_dr_back);
        btn_back.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dr_back:
                    finish();
                    break;
            }
        }
    };
}
