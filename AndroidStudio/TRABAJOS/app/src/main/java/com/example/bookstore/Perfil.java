package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void perfil(View v){
        Intent intent = new Intent(Perfil.this, Perfil.class);
        startActivity(intent);
    }

    public void home(View v){
        Intent intent = new Intent(Perfil.this, MainActivity3.class);
        startActivity(intent);
    }

    public void generos(View v){
        Intent intent = new Intent(Perfil.this, Generos.class);
        startActivity(intent);
    }
}
