package com.example.bookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Romantico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romantico);

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo1();
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo2();
            }
        });
        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo3();
            }
        });
    }

    private void Dialogo1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Antes de ti");
        builder.setMessage("La vida de Louisa Clark, una chica alegre y alocada, que va empalmando un trabajo con otro para ayudar a su familia a subsistir, cambia por completo cuando comienza a trabajar como cuidadora de un joven millonario, quien quedó paralítico tras un accidente. Poco a poco, se va estableciendo entre ellos una conexión cada vez más íntima.")
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
        builder.setTitle("El Acuerdo");
        builder.setMessage("Un tirano por el día, un playboy por la noche. Esa es la reputación que precede a Richard VanRyan. Él vive su vida de la manera que quiere, sin importarle las opiniones de otros. No se preocupa ni por nada ni por nadie, y no tiene intención de cambiar su manera de ser.")
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
        builder.setTitle("Sombras de los Hombres");
        builder.setMessage("Un cuerpo lleno de cicatrices y pesadillas cada noche es todo lo que le queda a Smoky. La mejor jefa de equipo del FBI nunca imaginó que ella también sería una víctima, que una noche un maníaco entraría en su casa y mataría a su marido y su hija.")
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