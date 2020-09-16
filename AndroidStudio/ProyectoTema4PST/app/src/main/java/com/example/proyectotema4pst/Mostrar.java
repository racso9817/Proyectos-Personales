package com.example.proyectotema4pst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class Mostrar extends AppCompatActivity {

    String urladd="http://192.168.100.7:8008/proyecto/mostrar.php";
    String [] cedula;
    String [] nombre;
    String [] apellido;
    String [] temp;
    String [] gel;
    String [] fecha;
    String [] hora;
    String [] t;
    float tempt;
    ListView listView;
    BufferedInputStream bf;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        listView=(ListView)findViewById(R.id.ListView);
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView customListView= new CustomListView(this,cedula,nombre,apellido,temp,gel,fecha,hora);
        listView.setAdapter(customListView);
    }

    private void collectData(){
        try{
            URL url=new URL(urladd);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            bf=new BufferedInputStream(con.getInputStream());
        }catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(bf));
            StringBuilder sb = new StringBuilder();
            while((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            bf.close();
            result=sb.toString();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            JSONArray ja=new JSONArray(result);
            JSONObject jo = null;
            cedula = new String[ja.length()];
            nombre = new String[ja.length()];
            apellido = new String[ja.length()];
            temp = new String[ja.length()];
            gel = new String[ja.length()];
            fecha = new String[ja.length()];
            hora = new String[ja.length()];
            for(int i =0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                //tempt=Float.parseFloat(t[i]=jo.getString("Temperatura"));
                //if(tempt>38f) {
                    cedula[i] = jo.getString("Cedula");
                    nombre[i] = jo.getString("Nombre");
                    apellido[i] = jo.getString("Apellido");
                    temp[i] = jo.getString("Temperatura");
                    gel[i] = jo.getString("Gel");
                    fecha[i] = jo.getString("Fecha");
                    hora[i] = jo.getString("Hora");
                //}
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}