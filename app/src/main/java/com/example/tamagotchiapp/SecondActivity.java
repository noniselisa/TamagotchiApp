package com.example.tamagotchiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnNome = (Button) findViewById(R.id.btnNome);
        btnNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
                String nome = editTextNome.getText().toString(); //Salvo il nome dato al Tamagotchi
                if (nome.matches("")) //Se non viene assegnato un nome al Tamagotchi comparirà una schermata di errore
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                    builder.setTitle("ERROR");
                    builder.setMessage("Write a name!");
                    builder.setCancelable(true);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                else
                {
                    Intent j = new Intent(SecondActivity.this, ThirdActivity.class);
                    j.putExtra("key_nome", editTextNome.getText().toString()); //Passo il nome all'activity successiva ovvero la ThirdActivity
                    startActivity(j);
                }
            }
        });
    }
}