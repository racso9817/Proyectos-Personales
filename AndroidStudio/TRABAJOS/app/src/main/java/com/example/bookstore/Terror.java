package com.example.bookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Terror extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terror);

        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo1();
            }
        });
        findViewById(R.id.button15).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo2();
            }
        });
        findViewById(R.id.button16).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo3();
            }
        });
    }

    private void Dialogo1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Infierno");
        builder.setMessage("Cada vez que la llama de la esperanza emerge, trémula, el enemigo la abate con algún nuevo revés con un sencillo y potente soplo.  Dando tumbos por una América devastada, los escasos supervivientes intentan sobrevivir a una creciente Tormenta, enfrentándose exhaustos a unos enemigos cada vez más numerosos que se extienden ya por todo el mundo.\n" +
                "\n" +
                "El plan de Alkibiades no deja resquicios. Mientras los nueve Mogs de Tusla Edron aumentan imparables su poder, la perspectiva de un mañana se extingue. Un último y desesperado aliento les conduce hasta Villa Vanidad donde se preparan para intentar asestar un perentorio golpe a la terrible Elexia mientras un misterioso mensaje obtenido en sueños repetitivos, intranquilos y sofocantes les advierte: ¡El Infierno Desde Arriba! ")
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
        builder.setTitle("Rojo");
        builder.setMessage("En una base militar en Nueva Jersey mantienen custodiada a una vampira terriblemente poderosa. Cuando esta escapa, desata el terror y el apocalipsis en forma de plaga vampírica.")
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
        builder.setTitle("Tres Horas de Terror");
        builder.setMessage("Una pequeña vivencia narrada en primera persona por uno de los tres miembros de un apartamento. Una tarde, él solo en casa, le ocurre algo bastante alarmante mientras se encontraba en el baño hasta el punto de pensar que perdería su vida. Con la obsesión de averiguar lo que pasó, no duda en incluir a su amigo David en el plan, ambos deciden dar fin con aquello que viaja por la tubería pero para su sorpresa no era lo que se esperaban encontrar, sino algo mucho mas perturbador.")
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