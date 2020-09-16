package com.example.examenpracticojorgeayala;

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

public class MainActivity3 extends AppCompatActivity {

    String urladd="http://192.168.100.7:8008/examenpst/mostrar.php";
    String [] posicion;
    String [] fecha;
    ListView listView;
    BufferedInputStream bf;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView=(ListView)findViewById(R.id.ListView);
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView customListView= new CustomListView(this,posicion,fecha);
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
            posicion = new String[ja.length()];
            fecha = new String[ja.length()];
            for(int i =0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                posicion[i] = jo.getString("posicion");
                fecha[i] = jo.getString("fecha");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}