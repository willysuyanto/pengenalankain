package com.pirman.pengenalankain.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.pirman.pengenalankain.database.entities.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    Single<List<User>> getAllUser();

    @Query("SELECT * FROM user WHERE roles = 'penjahit'")
    Single<List<User>> getAllPenjahit();

    @Query("SELECT * FROM user WHERE username = :username")
    Single<User> findByUsername(String username);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    Completable insertUser(User user);

    @Update(onConflict = OnConflictStrategy.ABORT)
    Completable updateUser(User user);

    @Delete()
    Completable deleteUser(User user);

}
