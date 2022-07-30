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
    public String namaKain;

    @ColumnInfo()
    public String deskripsi;

    @ColumnInfo()
    public double harga;

    @ColumnInfo()
    public String ketebalan;

    @ColumnInfo()
    public String tekstur;

    public Kain(String gambar, String namakain, String deskripsi, double harga, String ketebalan, String tekstur) {
        this.gambar = gambar;
        this.namaKain = namakain;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.ketebalan = ketebalan;
        this.tekstur = tekstur;
    }

    public Kain() {

    }
}
