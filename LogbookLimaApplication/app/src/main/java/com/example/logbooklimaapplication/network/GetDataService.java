package com.example.logbooklimaapplication.network;


import com.example.logbooklimaapplication.model.Sprint;
import com.example.logbooklimaapplication.model.SprintList;
import com.example.logbooklimaapplication.model.Task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {
    @GET("log-book")
    Call<ArrayList<Sprint>> getAllSprint();

    @GET("get-task/{sprint_id}")
    Call<ArrayList<Task>> getTaskBySprintId(@Path("sprint_id") int sprintId);
}
