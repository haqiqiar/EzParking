package com.menanga.ezparking.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.menanga.ezparking.R;

public class CodeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_result);
        Button btn_payof = (Button) findViewById(R.id.btn_cr_payof);
        Button btn_payon = (Button) findViewById(R.id.btn_cr_payon);

        btn_payof.setOnClickListener(op);
        btn_payon.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_cr_payof:changePage(SuccessPayActivity.class); break;
                case R.id.btn_cr_payon:changePage(MemberPaidActivity.class);break;
            }
        }
    };

    void changePage(Class ad){
        Intent ints = new Intent(getBaseContext(),ad);
        startActivityForResult(ints,0);
    }
}
