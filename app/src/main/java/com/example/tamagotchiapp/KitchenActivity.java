package com.example.tamagotchiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class KitchenActivity extends AppCompatActivity {
    int drawableChosen;
    ImageView imagine;
    TextView txtExclamation;
    String[] exclamation = {"That was very good!", "Exquisite!", "I'm still hungry", "Can I get another one?", "Nice!"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        txtExclamation = (TextView) findViewById(R.id.txtExclamation);
        imagine =  (ImageView)findViewById(R.id.trasparent);
        Button btnFood = (Button) findViewById(R.id.btnFood);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(KitchenActivity.this);
                builder.setTitle("Choose the food");
                builder.setCancelable(true);
                builder.setItems(R.array.food, new DialogInterface.OnClickListener() {
                    @SuppressLint("UseCompatLoadingForDrawables")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) //swicth che mi permette di scegliere cosa dare da mangiare al mio Tamagotchi
                        {
                            case 0:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.apple));
                                TimerFood ();
                                break;
                            case 1:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.avocado));
                                TimerFood ();
                                break;
                            case 2:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.bento));
                                TimerFood ();
                                break;
                            case 3:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.blueberry));
                                TimerFood ();
                                break;
                            case 4:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.chocolate));
                                TimerFood ();
                                break;
                            case 5:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.fries));
                                TimerFood ();
                                break;
                            case 6:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.greeksalad));
                                TimerFood ();
                                break;
                            case 7:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.hamburger));
                                TimerFood ();
                                break;
                            case 8:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.icecream));
                                TimerFood ();
                                break;
                            case 9:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.donut));
                                TimerFood ();
                                break;
                            case 10:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.pretzel));
                                TimerFood ();
                                break;
                            case 11:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.rasberry));
                                TimerFood ();
                                break;
                            case 12:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.ricebowl));
                                TimerFood ();
                                break;
                            case 13:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.strawberry));
                                TimerFood ();
                                break;
                            case 14:
                                imagine.setImageDrawable(getResources().getDrawable(R.drawable.taco));
                                TimerFood ();
                                break;
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public void TimerFood () //Ogni tot secondi comparirà una frase tra quelle presenti nel vettore exclamation
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imagine.setImageDrawable(getResources().getDrawable(R.drawable.trasparente));
                        int n = new Random().nextInt(exclamation.length);
                        txtExclamation.setText(exclamation[n]);
                        TimerExclamation();
                    }
                });
            }
        }, 5000);
    }

    public void TimerExclamation () //La frase tra quelle presenti nel vettore exclamation rimarrà visibile per un tot di secondi
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtExclamation.setText("");
                    }
                });
            }
        }, 5000);
    }
}