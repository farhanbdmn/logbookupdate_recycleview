package com.example.logbooklimaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logbooklimaapplication.model.Sprint;
import com.example.logbooklimaapplication.network.GetDataService;
import com.example.logbooklimaapplication.network.UtilsApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewLaporanActivity extends AppCompatActivity {

//    final public static String KEY_SPRINTS = "key_sprints";

    GetDataService service;
    private RecyclerView rvSprint;
    private ArrayList<Sprint> sprints = new ArrayList<>();
    private SprintAdapter adapter;

    private Button btnSubmitTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint);

        adapter = new SprintAdapter(this);
        service = UtilsApi.getAPIService();

        initViews();
        ambildata();
    }

    private void initViews() {
        rvSprint = findViewById(R.id.rv_sprint);
        rvSprint.setHasFixedSize(true);
        rvSprint.setLayoutManager(new LinearLayoutManager(this));

        btnSubmitTask = findViewById(R.id.btn_submit_task);
        btnSubmitTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewLaporanActivity.this, LaporanActivity.class);
                startActivity(intent);
            }
        });
    }

    void ambildata(){
        Log.i("TES","memanggilapi");
        service.getAllSprint().enqueue(new Callback<ArrayList<Sprint>>() {
            @Override
            public void onResponse(Call< ArrayList<Sprint>> call, Response< ArrayList<Sprint>> response) {
                if (response.isSuccessful()) {
                    Log.i("TES","YEAYYYYYYYY");
                    sprints = response.body();
                    generateSprintList();
                } else {
                    Log.i("TES","YAHHHH");
                    Toast.makeText( ReviewLaporanActivity.this, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call< ArrayList<com.example.logbooklimaapplication.model.Sprint>> call, Throwable t) {
                Log.i("TES","NYERAH PAK");
                t.printStackTrace();
                Toast.makeText(ReviewLaporanActivity.this, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateSprintList() {
        adapter.setListSprint(sprints);
        rvSprint.setAdapter(adapter);
    }
}
