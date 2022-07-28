package com.pirman.pengenalankain.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.pirman.pengenalankain.database.entities.Client;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ClientDao {

    @Query("SELECT * FROM client")
    Single<List<Client>> getAllClient();

    @Insert()
    Completable insertClient(Client client);

    @Update(onConflict = OnConflictStrategy.ABORT)
    Completable updateClient(Client client);

    @Delete()
    Completable deleteClient(Client client);
}
