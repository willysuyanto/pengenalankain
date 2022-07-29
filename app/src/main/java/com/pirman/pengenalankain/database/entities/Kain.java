package com.pirman.pengenalankain.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Kain {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo()
    public String gambar;

    @ColumnInfo()
    public String namakain;

    @ColumnInfo()
    public String deskripsi;

    public Kain(String gambar, String namakain, String deskripsi) {
        this.gambar = gambar;
        this.namakain = namakain;
        this.deskripsi = deskripsi;
    }

    public Kain() {

    }
}
