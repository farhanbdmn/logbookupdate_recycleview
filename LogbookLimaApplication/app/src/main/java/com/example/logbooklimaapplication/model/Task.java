package com.example.logbooklimaapplication.model;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("id")
    private int id;

    @SerializedName("sprint_id")
    private String sprintId;

    @SerializedName("nama_task")
    private String namaTask;

    @SerializedName("desc_task")
    private String descTask;

    @SerializedName("tgl_mulai")
    private String dateStart;

    @SerializedName("tgl_selesai")
    private String dateEnd;

    @SerializedName("status")
    private int status;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public String getNamaTask() {
        return namaTask;
    }

    public void setNamaTask(String namaTask) {
        this.namaTask = namaTask;
    }

    public String getDescTask() {
        return descTask;
    }

    public void setDescTask(String descTask) {
        this.descTask = descTask;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
