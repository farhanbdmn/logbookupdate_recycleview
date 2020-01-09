package com.example.logbooklimaapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logbooklimaapplication.model.Sprint;
import com.example.logbooklimaapplication.network.GetDataService;
import com.example.logbooklimaapplication.network.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

//     TODO get id sprint yang dipilih dropdown
//     TODO get task by sprint id dan dimuat ke adapter

    GetDataService service;
    Spinner spinnerSprint;
    Context context;
    CheckBox task1, task2, task3;

    int sprintId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        service = UtilsApi.getAPIService();

        spinnerSprint = findViewById(R.id.spinner_sprint);
//        spinnerTask = findViewById(R.id.spinner_task);

        ambildata();

        spinnerSprint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Sprint sprint = (Sprint) parent.getSelectedItem();
//                displayUserData(sprint);

//                String selectedName = parent.getItemAtPosition(position).toString();
//                Toast.makeText(context, "Kamu memilih sprint " + selectedName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void ambildata(){
        Log.i("TES","memanggilapi");
        service.getAllSprint().enqueue(new Callback< ArrayList<Sprint>>() {
            @Override
            public void onResponse(Call< ArrayList<Sprint>> call, Response< ArrayList<Sprint>> response) {
                if (response.isSuccessful()) {
                    Log.i("TES","YEAYYYYYYYY");
                    ArrayList<Sprint> sprints = response.body();
//                    List<String> listSpinner = new ArrayList<String>();
//                    for (int i = 0; i < sprints.size(); i++){
//                        listSpinner.add(sprints.get(i).getTitle());
//                    }

                    ArrayAdapter<Sprint> adapter = new ArrayAdapter<Sprint>(context,
                            android.R.layout.simple_spinner_item, sprints);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerSprint.setAdapter(adapter);
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

    public void getSelectedUser(View v) {
        Sprint sprint = (Sprint) spinnerSprint.getSelectedItem();
        displayUserData(sprint);
    }

    private void displayUserData(Sprint sprint) {
        String name = sprint.getTitle();
        String desc = sprint.getDesc();

        String userData = "Name: " + name + "\nAge: " + desc;

        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }

}
