package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.menanga.ezparking.R;

public class CMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmain);
        Button ib_in = (Button)findViewById(R.id.ib_m_in);
        Button ib_out = (Button) findViewById(R.id.ib_m_out);
        Button btn_rekap = (Button) findViewById(R.id.btn_m_rekap);

        ib_in.setOnClickListener(oprasi);
        ib_out.setOnClickListener(oprasi);
        btn_rekap.setOnClickListener(oprasi);
    }

    View.OnClickListener oprasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ib_m_in:ChangePage(InActivity.class);break;
                case R.id.ib_m_out:ChangePage(OutActivity.class);break;
                case R.id.btn_m_rekap:ChangePage(RekapActivity.class);break;
            }
        }
    };

    void ChangePage(Class x){
        Intent ints = new Intent(getBaseContext(),x);
        startActivityForResult(ints,0);
    }
}
