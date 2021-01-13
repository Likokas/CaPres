package com.example.capres.model;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("event_id")
    String event;
    @SerializedName("user_id")
    String user;
    @SerializedName("prestasi")
    String prestasi;
    @SerializedName("bukti")
    String bukti;
    @SerializedName("dosen_id")
    String dosen;
    @SerializedName("point_id")
    String point;
    @SerializedName("tanggal_input")
    String tanggal;
    @SerializedName("pesan")
    String pesan;
    @SerializedName("is_approved")
    String approved;


    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPrestasi() {
        return prestasi;
    }

    public void setPrestasi(String prestasi) {
        this.prestasi = prestasi;
    }

    public String getBukti() {
        return bukti;
    }

    public void setBukti(String bukti) {
        this.bukti = bukti;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }
}
