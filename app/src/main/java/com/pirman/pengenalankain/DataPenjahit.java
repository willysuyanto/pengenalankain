package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.pirman.pengenalankain.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataPenjahit extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    Button btnPenjahitAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_penjahit);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        btnPenjahitAdd = findViewById(R.id.btn_add_penjahit);

        Disposable d = appDatabase.userDao().getAllPenjahit().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(users -> {
            recyclerView = findViewById(R.id.rv_penjahit);
            recylerViewLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(recylerViewLayoutManager);
            recyclerViewAdapter = new PenjahitAdapter(this, users);
            recyclerView.setAdapter(recyclerViewAdapter);
        }, throwable -> {});
    }
}