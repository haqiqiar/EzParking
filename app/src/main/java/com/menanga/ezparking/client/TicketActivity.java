package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.menanga.ezparking.R;

public class TicketActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        Button btn_cetak = (Button) findViewById(R.id.btn_cetak);

        btn_cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Mencetak tiket",Toast.LENGTH_LONG).show();
                Intent ints = new Intent(getBaseContext(), PhotoActivity.class);
                startActivityForResult(ints, 0);
            }
        });


    }
}
