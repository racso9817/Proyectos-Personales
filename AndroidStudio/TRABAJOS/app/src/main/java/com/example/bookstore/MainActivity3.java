package com.example.bookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity{

    private EditText buscar;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24;
    private ImageView lb1, lb2, lb3, lb4;
    private ImageButton b1, b2, b3;
    private Button bt2, bt3, bt4, bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buscar = (EditText)findViewById(R.id.editTextTextPersonName);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView3);
        t3 = (TextView)findViewById(R.id.textView4);
        t4 = (TextView)findViewById(R.id.textView5);
        t5 = (TextView)findViewById(R.id.textView6);
        t6 = (TextView)findViewById(R.id.textView7);
        t7 = (TextView)findViewById(R.id.textView8);
        t8 = (TextView)findViewById(R.id.textView9);
        t9 = (TextView)findViewById(R.id.textView10);
        t10 = (TextView)findViewById(R.id.textView11);
        t11 = (TextView)findViewById(R.id.textView12);
        t12 = (TextView)findViewById(R.id.textView13);
        t13 = (TextView)findViewById(R.id.textView14);
        t14 = (TextView)findViewById(R.id.textView15);
        t15 = (TextView)findViewById(R.id.textView16);
        t16 = (TextView)findViewById(R.id.textView17);
        t17 = (TextView)findViewById(R.id.textView19);
        t18 = (TextView)findViewById(R.id.textView20);
        t19 = (TextView)findViewById(R.id.textView21);
        t20 = (TextView)findViewById(R.id.textView24);
        t21 = (TextView)findViewById(R.id.textView22);
        t22 = (TextView)findViewById(R.id.textView25);
        t23 = (TextView)findViewById(R.id.textView23);
        t24 = (TextView)findViewById(R.id.textView26);
        lb1 = (ImageView)findViewById(R.id.imageView2);
        lb2 = (ImageView)findViewById(R.id.imageView3);
        lb3 = (ImageView)findViewById(R.id.imageView4);
        lb4 = (ImageView)findViewById(R.id.imageView5);
        b1 = (ImageButton)findViewById(R.id.imageButton4);
        b2 = (ImageButton)findViewById(R.id.imageButton5);
        b3 = (ImageButton)findViewById(R.id.imageButton6);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
        bt4 = (Button)findViewById(R.id.button4);
        bt5 = (Button)findViewById(R.id.button5);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo1();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo2();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo3();
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Dialogo4();
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String busqueda = buscar.getText().toString();
                String antesdeti = t2.getText().toString();
                String elacuerdo = t8.getText().toString();
                String infierno = t14.getText().toString();
                String narnia = t20.getText().toString();
                if(busqueda.equals(antesdeti)){
                    t7.setVisibility(View.GONE);
                    t8.setVisibility(View.GONE);
                    t9.setVisibility(View.GONE);
                    t10.setVisibility(View.GONE);
                    t11.setVisibility(View.GONE);
                    t12.setVisibility(View.GONE);
                    t13.setVisibility(View.GONE);
                    t14.setVisibility(View.GONE);
                    t15.setVisibility(View.GONE);
                    t16.setVisibility(View.GONE);
                    t17.setVisibility(View.GONE);
                    t18.setVisibility(View.GONE);
                    t19.setVisibility(View.GONE);
                    t20.setVisibility(View.GONE);
                    t21.setVisibility(View.GONE);
                    t22.setVisibility(View.GONE);
                    t23.setVisibility(View.GONE);
                    t24.setVisibility(View.GONE);
                    lb2.setVisibility(View.GONE);
                    lb3.setVisibility(View.GONE);
                    lb4.setVisibility(View.GONE);
                    bt3.setVisibility(View.GONE);
                    bt5.setVisibility(View.GONE);
                    bt4.setVisibility(View.GONE);
                }
                if(busqueda.equals(elacuerdo)){
                    t1.setVisibility(View.GONE);
                    t2.setVisibility(View.GONE);
                    t3.setVisibility(View.GONE);
                    t4.setVisibility(View.GONE);
                    t5.setVisibility(View.GONE);
                    t6.setVisibility(View.GONE);
                    t13.setVisibility(View.GONE);
                    t14.setVisibility(View.GONE);
                    t15.setVisibility(View.GONE);
                    t16.setVisibility(View.GONE);
                    t17.setVisibility(View.GONE);
                    t18.setVisibility(View.GONE);
                    t19.setVisibility(View.GONE);
                    t20.setVisibility(View.GONE);
                    t21.setVisibility(View.GONE);
                    t22.setVisibility(View.GONE);
                    t23.setVisibility(View.GONE);
                    t24.setVisibility(View.GONE);
                    lb1.setVisibility(View.GONE);
                    lb3.setVisibility(View.GONE);
                    lb4.setVisibility(View.GONE);
                    bt2.setVisibility(View.GONE);
                    bt4.setVisibility(View.GONE);
                    bt5.setVisibility(View.GONE);
                }
                if(busqueda.equals(infierno)){
                    t1.setVisibility(View.GONE);
                    t2.setVisibility(View.GONE);
                    t3.setVisibility(View.GONE);
                    t4.setVisibility(View.GONE);
                    t5.setVisibility(View.GONE);
                    t6.setVisibility(View.GONE);
                    t7.setVisibility(View.GONE);
                    t8.setVisibility(View.GONE);
                    t9.setVisibility(View.GONE);
                    t10.setVisibility(View.GONE);
                    t11.setVisibility(View.GONE);
                    t12.setVisibility(View.GONE);
                    t19.setVisibility(View.GONE);
                    t20.setVisibility(View.GONE);
                    t21.setVisibility(View.GONE);
                    t22.setVisibility(View.GONE);
                    t23.setVisibility(View.GONE);
                    t24.setVisibility(View.GONE);
                    lb1.setVisibility(View.GONE);
                    lb2.setVisibility(View.GONE);
                    lb4.setVisibility(View.GONE);
                    bt2.setVisibility(View.GONE);
                    bt3.setVisibility(View.GONE);
                    bt5.setVisibility(View.GONE);
                }
                if(busqueda.equals(narnia)){
                    t1.setVisibility(View.GONE);
                    t2.setVisibility(View.GONE);
                    t3.setVisibility(View.GONE);
                    t4.setVisibility(View.GONE);
                    t5.setVisibility(View.GONE);
                    t6.setVisibility(View.GONE);
                    t7.setVisibility(View.GONE);
                    t8.setVisibility(View.GONE);
                    t9.setVisibility(View.GONE);
                    t10.setVisibility(View.GONE);
                    t11.setVisibility(View.GONE);
                    t12.setVisibility(View.GONE);
                    t13.setVisibility(View.GONE);
                    t14.setVisibility(View.GONE);
                    t15.setVisibility(View.GONE);
                    t16.setVisibility(View.GONE);
                    t17.setVisibility(View.GONE);
                    t18.setVisibility(View.GONE);
                    lb1.setVisibility(View.GONE);
                    lb2.setVisibility(View.GONE);
                    lb3.setVisibility(View.GONE);
                    bt2.setVisibility(View.GONE);
                    bt3.setVisibility(View.GONE);
                    bt4.setVisibility(View.GONE);
                }
            }
        });
    }

    private void Dialogo1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
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
    private void Dialogo4(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
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

    public void perfil(View v){
        Intent intent = new Intent(MainActivity3.this, Perfil.class);
        startActivity(intent);
    }

    public void home(View v){
        Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
        startActivity(intent);
    }

    public void generos(View v){
        Intent intent = new Intent(MainActivity3.this, Generos.class);
        startActivity(intent);
    }
}