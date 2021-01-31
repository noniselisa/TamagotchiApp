package com.example.tamagotchiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ClothesActivity extends AppCompatActivity {
    int drawableChosen; //Per salvarmi il capo d'abbigliamento scelto
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        ImageView immagine =  (ImageView)findViewById(R.id.tamagotchi);
        Intent intent = getIntent();
        drawableChosen = intent.getIntExtra("key_imagine", R.drawable.tamagotchi);
        immagine.setImageDrawable(getResources().getDrawable(drawableChosen));

        Button btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(ClothesActivity.this);
                builder.setTitle("Choose a shirt");
                builder.setCancelable(true);
                builder.setItems(R.array.colors, new DialogInterface.OnClickListener() {
                    @SuppressLint("UseCompatLoadingForDrawables")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) //swicth che mi permette di sceglie il capo d'abbigliamento da far indossare al mio tamagotchi
                        {
                            case 0:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.magliaazzurra));
                                drawableChosen=R.drawable.magliaazzurra;
                                break;
                            case 1:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.magliaarancione));
                                drawableChosen=R.drawable.magliaarancione;
                                break;
                           case 2:
                               immagine.setImageDrawable(getResources().getDrawable(R.drawable.magliahippie));
                               drawableChosen=R.drawable.magliahippie;
                                break;
                            case 3:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.magliaviola));
                                drawableChosen=R.drawable.magliaviola;
                                break;
                            case 4:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.magliagatti));
                                drawableChosen=R.drawable.magliagatti;
                                break;
                            case 5:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.magliasootsprite));
                                drawableChosen=R.drawable.magliasootsprite;
                                break;
                            case 6:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.maglialibri));
                                drawableChosen=R.drawable.maglialibri;
                                break;
                            case 7:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.camicetta));
                                drawableChosen=R.drawable.camicetta;
                                break;
                            case 8:
                                immagine.setImageDrawable(getResources().getDrawable(R.drawable.tamagotchi));
                                drawableChosen=R.drawable.tamagotchi;
                                break;

                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        Button btnBack = (Button) findViewById(R.id.btnBack); //Bottone per tornare indietro
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("key_imagine", drawableChosen); //Passo l'immagine del vestito scelto tra le activity
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}