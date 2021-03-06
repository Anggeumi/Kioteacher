package com.example.kioteacher.qr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kioteacher.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScannerActivity extends AppCompatActivity {
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        qrScan = new IntentIntegrator(this);
        qrScan.setCaptureActivity(CaptureFormActivity.class);
        qrScan.setOrientationLocked(false);                  //휴대폰 방향에 따라 가로, 세로로 자동 변경

        qrScan.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {

                Intent intent = new Intent(com.example.kioteacher.qr.ScannerActivity.this, QrActivity.class);
                Toast.makeText(getApplicationContext(), result.getContents(), Toast.LENGTH_SHORT).show();
                //여기서 맥날/병원 구분해서 화면 넘겨주기

                intent.putExtra("code",result.getContents());

                startActivity(intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}