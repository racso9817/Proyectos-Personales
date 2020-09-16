package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private EditText PlainText1, pswd1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PlainText1 = (EditText) findViewById(R.id.PlainText1);
        pswd1 = (EditText) findViewById(R.id.pswd1);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String usr = PlainText1.getText().toString();
        String pswd = pswd1.getText().toString();

        switch (view.getId()){
            case R.id.button:
                if(usr.equals("usuario1")&&pswd.equals("contraseña1")){
                    Toast.makeText(this, "Sesión Iniciada correctamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show();
                }
        }
    }

}