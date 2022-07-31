package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.pirman.pengenalankain.database.AppDatabase;
import com.pirman.pengenalankain.database.entities.Kain;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KainActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//    RecyclerView.Adapter recyclerViewAdapter;
//    RecyclerView.LayoutManager recyclerViewLayoutManager;
//
//    Button btn_add_kain;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_kain);
//
//        AppDatabase appDatabase = AppDatabase.getInstance(this);
//
//        recyclerView = findViewById(R.id.rv_kain);
//        btn_add_kain = findViewById(R.id.btn_add_kain);
//
//        btn_add_kain.setOnClickListener(v -> {
//            Intent intent = new Intent(KainActivity.this, TambahKain.class);
//            startActivity(intent);
//        });
//
//        Disposable d1 = appDatabase.kainDao().getAllKain().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(kains -> {
//            for (Kain kain : kains) {
//                Log.d("onCreate: ", kain.namaKain);
//            }
//            recyclerViewLayoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(recyclerViewLayoutManager);
//            recyclerViewAdapter = new KainAdapter(this, kains);
//            recyclerView.setAdapter(recyclerViewAdapter);
//        }, throwable -> {
//            Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
//        });
//    }
//        @Override
//        protected void onResume() {
//            super.onResume();
//            AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
//
//            Disposable d1 = appDatabase.kainDao().getAllKain().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(kains -> {
//                for(Kain kain: kains){
//                    Log.d( "onCreate: ", kain.namaKain);
//                }
//                recyclerViewLayoutManager = new LinearLayoutManager(this);
//                recyclerView.setLayoutManager(recyclerViewLayoutManager);
//                recyclerViewAdapter = new KainAdapter(this, kains);
//                recyclerView.setAdapter(recyclerViewAdapter);
//            }, throwable -> {
//                Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
//            });
//        }

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    Button btn_add_kain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kain);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        btn_add_kain = findViewById(R.id.btn_add_kain);

        Disposable d = appDatabase.kainDao().getAllKain().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(kains -> {
            recyclerView = findViewById(R.id.rv_kain);
            recyclerViewLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(recyclerViewLayoutManager);
            recyclerViewAdapter = new KainAdapter(this, kains);
            recyclerView.setAdapter(recyclerViewAdapter);
        }, throwable -> {});
    }


}