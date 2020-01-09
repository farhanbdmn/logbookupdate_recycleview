package com.example.logbooklimaapplication.model;

import com.google.gson.annotations.SerializedName;

public class Laporan {

    @SerializedName("id")
    private int id;

    @SerializedName("sprint_id")
    private int sprintId;

    @SerializedName("hasil_log")
    private String hasilLog;

    @SerializedName("kendala")
    private String kendala;

    @SerializedName("tanggal")
    private String tanggal;

    public Laporan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getHasilLog() {
        return hasilLog;
    }

    public void setHasilLog(String hasilLog) {
        this.hasilLog = hasilLog;
    }

    public String getKendala() {
        return kendala;
    }

    public void setKendala(String kendala) {
        this.kendala = kendala;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
