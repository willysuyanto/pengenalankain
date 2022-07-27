package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdmin extends AppCompatActivity {

    Button btnPenjahit, btnClient, btnKain, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        btnPenjahit = findViewById(R.id.btn_kelola_penjahit);
        btnClient = findViewById(R.id.btn_kelola_client);
        btnKain = findViewById(R.id.btn_kelola_kain);

        btnPenjahit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, DataPenjahit.class);
                startActivity(intent);
            }
        });

        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnKain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
