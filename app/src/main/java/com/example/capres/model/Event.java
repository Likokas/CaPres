package com.example.capres.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Event implements Parcelable {

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


    protected Event(Parcel in) {
        event = in.readString();
        user = in.readString();
        prestasi = in.readString();
        bukti = in.readString();
        dosen = in.readString();
        point = in.readString();
        tanggal = in.readString();
        pesan = in.readString();
        approved = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(event);
        parcel.writeString(user);
        parcel.writeString(prestasi);
        parcel.writeString(bukti);
        parcel.writeString(dosen);
        parcel.writeString(point);
        parcel.writeString(tanggal);
        parcel.writeString(pesan);
        parcel.writeString(approved);
    }
}
