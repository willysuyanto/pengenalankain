package com.pirman.pengenalankain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pirman.pengenalankain.database.AppDatabase;
import com.pirman.pengenalankain.database.entities.User;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase appDatabase = AppDatabase.getInstance(this);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = etUsername.getText().toString();
                String pass = etPassword.getText().toString();

                if(uname.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "Username/Password Salah", Toast.LENGTH_SHORT).show();
                }else{
                    Disposable d = appDatabase.userDao().findByUsername(uname).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
                        if(user.password.equals(pass)){
                            if(user.roles.equals("admin")){
                                Intent intent = new Intent(MainActivity.this, MenuAdmin.class);
                                startActivity(intent);
                            }else{
                                Intent intent = new Intent(MainActivity.this, MenuPenjahit.class);
                                startActivity(intent);
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Username/Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    },throwable -> {
                        Toast.makeText(MainActivity.this, "Username/Password Salah", Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });


    }
}