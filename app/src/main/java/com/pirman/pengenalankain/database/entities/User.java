package com.pirman.pengenalankain.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int id;

    @ColumnInfo()
    public String nama;

    @ColumnInfo()
    public String username;

    @ColumnInfo()
    public String password;

    @ColumnInfo()
    public String roles;

    public User(String nama, String username, String password, String roles) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }
}
