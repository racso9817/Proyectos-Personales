package com.example.proyectotema4pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    EditText name, buscar, apellido, fecha, temperatura;
    Button btnBuscar, ensenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        buscar = (EditText)findViewById(R.id.buscar);
        apellido = (EditText) findViewById(R.id.apellido);
        fecha = (EditText) findViewById(R.id.fecha);
        temperatura = (EditText) findViewById(R.id.tempt);
        btnBuscar=(Button)findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar("http://192.168.100.7:8008/proyecto/buscar.php?Cedula="+buscar.getText()+"");
            }
        });
    }

    public void ingreso(View v){
        Intent intent = new Intent(this, Ingreso.class);
        startActivity(intent);
    }

    public void inicio(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ensenar(View v){
        Intent intent = new Intent(this, Mostrar.class);
        startActivity(intent);
    }

    private void buscar(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        name.setText(jsonObject.getString("Nombre"));
                        apellido.setText(jsonObject.getString("Apellido"));
                        fecha.setText(jsonObject.getString("Fecha"));
                        temperatura.setText(jsonObject.getString("Temperatura"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"ERROR DE CONEXION",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}