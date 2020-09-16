package com.example.proyectotema4pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Ingreso extends AppCompatActivity {

    EditText nombre, apellido, cedula;
    Button aceptar, cancelar;
    Random r = new Random();
    float temp;
    String t;
    Date date;
    String fecha;
    Date hour;
    String hora;
    int gl;
    String gel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        cedula=(EditText)findViewById(R.id.cdl);
        aceptar = (Button)findViewById(R.id.aceptar);
        cancelar = (Button)findViewById(R.id.cancelar);
        //int i = r.nextInt(39 - 33)+33;
        gl = r.nextInt(5-1)+1;
        gel=Integer.toString(gl);
        temp = r.nextFloat()*(40f-35f)+35f;
        t = String.format(Locale.US,"%.1f",temp);
        //t = Float.toString(temp);
        date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha = dateFormat.format(date);
        hour = Calendar.getInstance().getTime();
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        hora = hourFormat.format(hour);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                servicio("http://192.168.100.7:8008/proyecto/insertar.php");
            }
        });

    }

    public void cancelar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void servicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("Cedula",cedula.getText().toString());
                parametros.put("Nombre",nombre.getText().toString());
                parametros.put("Apellido",apellido.getText().toString());
                parametros.put("Fecha",fecha);
                parametros.put("Hora",hora);
                parametros.put("Gel",gel+" ml");
                parametros.put("Temperatura",t+" C");
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}