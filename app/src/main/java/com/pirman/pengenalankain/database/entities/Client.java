package com.pirman.pengenalankain.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Client {
    @PrimaryKey
    public int id;

    @ColumnInfo()
    public String nama;

    @ColumnInfo()
    public String nohp;

    public Client(String nama, String nohp) {
        this.nama = nama;
        this.nohp = nohp;
    }

    public Client() {

    }
}
