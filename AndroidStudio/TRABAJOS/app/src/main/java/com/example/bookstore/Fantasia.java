package com.example.bookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fantasia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fantasia);

        findViewById(R.id.button20).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo1();
            }
        });
        findViewById(R.id.button21).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo2();
            }
        });
        findViewById(R.id.button22).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo3();
            }
        });
    }

    private void Dialogo1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Las Crónicas de Narnia");
        builder.setMessage("Cuatro niños viajan a través de un ropero a la tierra de Narnia, donde vivirán increíbles aventuras con la ayuda del león Aslan.")
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
        builder.setTitle("Harry Potter y la Piedra Filosofal");
        builder.setMessage("El día de su cumpleaños, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos. Debe asistir a una famosa escuela de magia y hechicería, donde entabla una amistad con dos jóvenes que se convertirán en sus compañeros de aventura. Durante su primer año en Hogwarts, descubre que un malévolo y poderoso mago llamado Voldemort está en busca de una piedra filosofal que alarga la vida de quien la posee.")
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
        builder.setTitle("La Comunidad del Anillo");
        builder.setMessage("En la adormecida e idílica Comarca, un joven hobbit recibe un encargo: custodiar el Anillo Único y emprender el viaje para su destrucción en las Grietas del Destino")
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