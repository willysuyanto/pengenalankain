package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pirman.pengenalankain.database.AppDatabase;
import com.pirman.pengenalankain.database.entities.Client;
import com.pirman.pengenalankain.database.entities.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClientActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    Button btn_add_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        AppDatabase appDatabase = AppDatabase.getInstance(this);

        recyclerView = findViewById(R.id.rv_client);
        btn_add_client = findViewById(R.id.btn_add_client);

        btn_add_client.setOnClickListener(v->{
            Intent intent = new Intent(ClientActivity.this, TambahClient.class);
            startActivity(intent);
        });

        Disposable d1 = appDatabase.clientDao().getAllClient().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(clients -> {
              for(Client client: clients){
                  Log.d( "onCreate: ", client.nama);
              }
            recyclerViewLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(recyclerViewLayoutManager);
            recyclerViewAdapter = new ClientAdapter(this, clients);
            recyclerView.setAdapter(recyclerViewAdapter);
        }, throwable -> {
            Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());

        Disposable d1 = appDatabase.clientDao().getAllClient().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(clients -> {
            for(Client client: clients){
                Log.d( "onCreate: ", client.nama);
            }
            recyclerViewLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(recyclerViewLayoutManager);
            recyclerViewAdapter = new ClientAdapter(this, clients);
            recyclerView.setAdapter(recyclerViewAdapter);
        }, throwable -> {
            Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}