package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pirman.pengenalankain.database.AppDatabase;
import com.pirman.pengenalankain.database.entities.Client;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TambahClient extends AppCompatActivity {

    EditText et_nama, et_nohp;
    Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_client);

        AppDatabase appDatabase = AppDatabase.getInstance(this);

        et_nama = findViewById(R.id.et_nama);
        et_nohp = findViewById(R.id.et_nohp);
        btn_simpan = findViewById(R.id.btn_simpan);

        btn_simpan.setOnClickListener(v->{
            String nama = et_nama.getText().toString();
            String nohp = et_nohp.getText().toString();
            Toast.makeText(this, nama, Toast.LENGTH_SHORT).show();

            Client client = new Client();
            client.nama = nama;
            client.nohp = nohp;

            Disposable d = appDatabase.clientDao().insertClient(client).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(()->{
                        Toast.makeText(this, "Berhasil Menambahkan Data Client", Toast.LENGTH_SHORT).show();
                        finish();
            },
                    throwable -> {
                        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        });
    }

}