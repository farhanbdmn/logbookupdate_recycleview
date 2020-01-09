package com.example.logbooklimaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnLaporan, btnPO, btnReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLaporan = findViewById(R.id.btn_laporan_sprint);
        btnPO = findViewById(R.id.btn_po_review);
        btnReview = findViewById(R.id.btn_hasil_review);

        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LaporanActivity.class);
                startActivity(intent);
            }
        });

        btnPO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, );
//                startActivity(intent);
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, );
//                startActivity(intent);
            }
        });
    }
}
