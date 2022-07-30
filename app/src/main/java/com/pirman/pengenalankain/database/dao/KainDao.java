package com.pirman.pengenalankain.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.pirman.pengenalankain.database.entities.Client;
import com.pirman.pengenalankain.database.entities.Kain;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KainDao {

    @Query("SELECT * FROM kain")
    Single<List<Kain>> getAllKain();

    @Insert()
    Completable insertKain(Kain kain);

    @Update(onConflict = OnConflictStrategy.ABORT)
    Completable updateKain(Kain kain);

    @Delete()
    Completable deleteKain(Kain kain);
}
