package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pirman.pengenalankain.database.AppDatabase;
import com.pirman.pengenalankain.database.entities.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainMenu extends AppCompatActivity {

    Button btnRecomend, btnJenisKain, btnTentang, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        //initData(this);

        btnRecomend = findViewById(R.id.btn_recoment);
        btnJenisKain = findViewById(R.id.btn_jenis_kain);
        btnTentang = findViewById(R.id.btn_tentang);
        btnLogin = findViewById(R.id.btn_login);

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, TentangActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void initData(Context context){
        AppDatabase appDatabase = AppDatabase.getInstance(context);

        User user = new User();
        user.id = 1;
        user.nama = "Admin Pirman";
        user.username = "admin";
        user.password = "password123";
        user.roles = "admin";

        User penjahit = new User();
        penjahit.id = 2;
        penjahit.nama = "Penjahit Pirman";
        penjahit.username = "penjahit";
        penjahit.password = "password123";
        penjahit.roles = "penjahit";
        Disposable d = appDatabase.userDao().insertUser(user).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()
             ).subscribe();
        Disposable d1 = appDatabase.userDao().insertUser(penjahit).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe();

    }
}