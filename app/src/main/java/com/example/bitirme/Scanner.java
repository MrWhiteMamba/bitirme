package com.example.bitirme;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scannerView =(ZXingScannerView)findViewById(R.id.zxscan);
        txtResult =(TextView)findViewById(R.id.txt_result);

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                    scannerView.setResultHandler(Scanner.this);
                    scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(Scanner.this,"Kabul et!",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                })
                .check();
    }

    @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        // Raw Result Buraya Gelıyor !!
        txtResult.setText(rawResult.getText());
       /* Intent karekod=new Intent(Scanner.this,DersSecim.class);//yeni açaçağımız sayfa
        karekod.putExtra("veri",txtResult.getText().toString());//açtığımız sayfaya değer gönderme
        startActivity(karekod);
*/
    }
}
