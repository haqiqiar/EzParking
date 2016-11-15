package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.menanga.ezparking.Class.Contain;
import com.menanga.ezparking.Class.ParkAdapter;
import com.menanga.ezparking.R;

import java.util.ArrayList;

public class RekapActivity extends AppCompatActivity {
    ParkAdapter pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap);
        ListView lv = (ListView) findViewById(R.id.lv_r1);
        Button btn_detail = (Button) findViewById(R.id.btn_r_detail);
        btn_detail.setOnClickListener(op);
        ArrayList<String> listKontak = new ArrayList<String>();
        pa= new ParkAdapter(this,0,listKontak);
        lv.setAdapter(pa);

        for(int i=0;i<32;i++){
            Contain con = new Contain(String.valueOf(i+1),"ID142"+String.valueOf(i));
            pa.add(con);
        }


    }
    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_r_detail:
                    Intent ints = new Intent(getBaseContext(),DetailRekapActivity.class);
                    startActivityForResult(ints,0);
                    break;
            }
        }
    };
}
