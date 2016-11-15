package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.menanga.ezparking.R;

public class InActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);
        Button mobil_in = (Button) findViewById(R.id.mobil_in);
        Button motor_in = (Button) findViewById(R.id.motor_in);

        mobil_in.setOnClickListener(op);
        motor_in.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.mobil_in:ChangePage(PhotoActivity.class);break;
                case R.id.motor_in:ChangePage(PhotoActivity.class);break;
            }
        }
    };

    void ChangePage(Class x){
        Intent ints = new Intent(getBaseContext(),x);
        startActivityForResult(ints, 0);
    }
}
