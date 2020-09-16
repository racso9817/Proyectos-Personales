package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Generos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generos);
    }

    public void perfil(View v){
        Intent intent = new Intent(Generos.this, Perfil.class);
        startActivity(intent);
    }

    public void home(View v){
        Intent intent = new Intent(Generos.this, MainActivity3.class);
        startActivity(intent);
    }

    public void generos(View v){
        Intent intent = new Intent(Generos.this, Generos.class);
        startActivity(intent);
    }

    public void romatico(View v){
        Intent intent = new Intent(Generos.this, Romantico.class);
        startActivity(intent);
    }

    public void terror(View v){
        Intent intent = new Intent(Generos.this, Terror.class);
        startActivity(intent);
    }

    public void cuento(View v){
        Intent intent = new Intent(Generos.this, Cuento.class);
        startActivity(intent);
    }

    public void fantasia(View v){
        Intent intent = new Intent(Generos.this, Fantasia.class);
        startActivity(intent);
    }
}