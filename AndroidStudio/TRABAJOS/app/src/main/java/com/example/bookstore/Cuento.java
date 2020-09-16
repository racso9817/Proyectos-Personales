package com.example.bookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cuento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuento);

        findViewById(R.id.button17).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo1();
            }
        });
        findViewById(R.id.button18).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo2();
            }
        });
        findViewById(R.id.button19).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo3();
            }
        });
    }

    private void Dialogo1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Las Mil y Una Noches");
        builder.setMessage("Es una recopilación de cuentos del Oriente medieval narrados, supuestamente, por Sherezade. Según la leyenda, existió un sultán persa que, en venganza por la traición de su primera esposa, se casaba una mujer cada noche y al día siguiente la mandaba decapitar.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
    private void Dialogo2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Doce Cuentos Peregrinos");
        builder.setMessage("Irreales, inquietantes, tocados con el hálito de lo fatal, estos doce relatos son un viaje por diversas ciudades de un mundo que se ve trastocado por la nostalgia, el desarraigo del exiliado o la simple presencia de lo insólito.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
    private void Dialogo3(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cuentos Completos");
        builder.setMessage("Una absoluta lucidez y una encendida pasión desplegó Carlos Fuentes en su siempre asombrosa obra narrativa. Fue un novelista formidable, sin duda, y sus cuentos no están a la zaga. En ellos corre con maestría la línea quebradiza y única del tiempo, dentro de atmósferas delineadas con perfección y sin falta sorprendentes. Está a la vez el dominio del lenguaje, la maravillosa capacidad de recrear sus ritmos, sus acentos, de sacar de las palabras sus luces y sus ecos todos El presente volumen es una recopilación cronológica y documentada de los cuentos que Carlos Fuentes publicó en colecciones, antologías y revis-tas: desde el primero, titulado \"Pastel rancio\" (El mañana, 1949), hasta los que formaban parte del último libro de relatos que publicó en su vida, Carolina Grau (2010).")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }

    public void perfil(View v){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    public void home(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void generos(View v){
        Intent intent = new Intent(this, Generos.class);
        startActivity(intent);
    }

}