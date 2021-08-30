package com.example.kioteacher.qr;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kioteacher.R;
import com.example.kioteacher.home.MainActivity;

//바코드 받아서 넘어갈 임시 화면 - 나중에 버릴 페이지
public class QrActivity extends AppCompatActivity {

    private String qrUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        Intent intent = getIntent();
        qrUrl = intent.getExtras().getString("code");
        //Toast.makeText(getApplicationContext(), qrUrl, Toast.LENGTH_SHORT).show();

        //화면전환
        Button paymentBtn = (Button) findViewById(R.id.button2);
        paymentBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QrActivity.this, MainActivity.class);
                startActivity(intent);//화면전환
            }
        });




    }


}