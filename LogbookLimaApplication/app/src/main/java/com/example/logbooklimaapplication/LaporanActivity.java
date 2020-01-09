package com.example.logbooklimaapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logbooklimaapplication.model.Sprint;
import com.example.logbooklimaapplication.model.Task;
import com.example.logbooklimaapplication.network.GetDataService;
import com.example.logbooklimaapplication.network.UtilsApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LaporanActivity extends AppCompatActivity {

    GetDataService service;
    Spinner spinnerSprint;
    Context context;
//    CheckBox task1, task2, task3;
    RecyclerView rvTask;
    Button btnfile;

    TaskCheckboxAdapter adapter;

    ArrayList<Sprint> sprints;
    ArrayList<Task> tasks;
//    int sprintId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        service = UtilsApi.getAPIService();

        spinnerSprint = findViewById(R.id.spinner_sprint);
        rvTask = findViewById(R.id.rv_task_checkbox);
        rvTask.setHasFixedSize(true);
        rvTask.setLayoutManager(new LinearLayoutManager(this));

        ambildata();

        //btnfile = findViewById(R.id.upload);
        //btnfile.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(this, FilePicker.class);
                //startActivityForResult(intent, REQUEST_PICK_FILE);
            //}
        //});
    }

    void ambildata(){
        Log.i("TES","memanggilapi");
        service.getAllSprint().enqueue(new Callback< ArrayList<Sprint>>() {
            @Override
            public void onResponse(Call< ArrayList<Sprint>> call, Response< ArrayList<Sprint>> response) {
                if (response.isSuccessful()) {
                    sprints = response.body();
                    Log.i("TES", sprints.get(0).getTitle());

                    ArrayAdapter<Sprint> adapter = new ArrayAdapter<Sprint>(context,
                            android.R.layout.simple_spinner_item, sprints);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerSprint.setAdapter(adapter);

                    spinnerSprint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            Sprint sprint = (Sprint) parent.getSelectedItem();
                            displaySprintData(sprint);
                            ambildataTask(sprint.getId());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else {
                    Log.i("TES","YAHHHH");
                    Toast.makeText(context, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call< ArrayList<Sprint>> call, Throwable t) {
                Log.i("TES","NYERAH PAK");
                t.printStackTrace();
                Toast.makeText(context, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void ambildataTask(int sprintId){
        Log.i("TES","memanggilapi");
        service.getTaskBySprintId(sprintId).enqueue(new Callback< ArrayList<Task>>() {
            @Override
            public void onResponse(Call< ArrayList<Task>> call, Response< ArrayList<Task>> response) {
                if (response.isSuccessful()) {
                    tasks = response.body();
                    Log.i("TES", tasks.get(0).getNamaTask());

                    adapter = new TaskCheckboxAdapter(context);
                    adapter.setListTask(tasks);
                    rvTask.setAdapter(adapter);
                } else {
                    Log.i("TES","YAHHHH");
                    Toast.makeText(context, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call< ArrayList<Task>> call, Throwable t) {
                Log.i("TES","NYERAH PAK");
                t.printStackTrace();
                Toast.makeText(context, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displaySprintData(Sprint sprint) {
        String name = sprint.getTitle();
        int id = sprint.getId();

        String userData = "Name: " + name + "\nId: " + id;

        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }
}
