package com.example.kioteacher.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kioteacher.R;
import com.example.kioteacher.qr.QrActivity;
import com.example.kioteacher.qr.ScannerActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //QR 찍을거다 - jw - 0826
        Button qrBtn = (Button) findViewById(R.id.button1);
        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScannerActivity.class);
                startActivity(intent);//화면전환
            }
        });
    };




}

