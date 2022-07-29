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

import com.pirman.pengenalankain.database.AppDatabase;
import com.pirman.pengenalankain.database.entities.Client;
import com.pirman.pengenalankain.database.entities.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClientActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    Button btnClientAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        btnClientAdd = findViewById(R.id.btn_add_client);

        btnClientAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientActivity.this, TambahClient.class);
                startActivity(intent);
            }
        });


        Disposable d = appDatabase.clientDao().getAllClient().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(clients -> {
//            recyclerView = findViewById(R.id.rv_client);
//            recylerViewLayoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(recylerViewLayoutManager);
//            recyclerViewAdapter = new ClientAdapter(this, clients);
//            recyclerView.setAdapter(recyclerViewAdapter);
            for (Client client : clients){
                Log.d("DATACLIENT", client.nama);
            }
        }, throwable -> {});
    }

    void initData(Context context){
        AppDatabase appDatabase = AppDatabase.getInstance(context);

        Client client = new Client();

        client.nama = "Client Asih";
        client.nohp = "083218123456";
        Disposable d = appDatabase.clientDao().insertClient(client).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()
                ).subscribe();


    }
}