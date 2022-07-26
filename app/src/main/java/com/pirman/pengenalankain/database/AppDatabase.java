package com.pirman.pengenalankain.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pirman.pengenalankain.database.dao.UserDao;
import com.pirman.pengenalankain.database.entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract UserDao userDao();

    public static AppDatabase getInstance(Context c){
        if(appDatabase == null) {
            appDatabase = Room.databaseBuilder(c, AppDatabase.class,
                            "DBPengenalanKain")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }

}
