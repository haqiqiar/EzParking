package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.menanga.ezparking.R;

public class SuccessPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_pay);
        Button btn_back = (Button) findViewById(R.id.btn_sp_back);
        Button btn_print = (Button)findViewById(R.id.btn_sp_print);
        btn_back.setOnClickListener(op);
        btn_print.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_sp_back:
                    Intent saa = new Intent(getBaseContext(),OutActivity.class);
                    startActivityForResult(saa,0);
                    break;
                case R.id.btn_sp_print:
                    Toast.makeText(getApplicationContext(),"Mencetak tiket",Toast.LENGTH_LONG).show();
            }
        }
    };
}
