package com.example.tamagotchiapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ThirdActivity extends AppCompatActivity {
    int drawableChosen = R.drawable.tamagotchi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        String name = intent.getStringExtra("key_nome");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        TextView txtWarningFood = (TextView) findViewById(R.id.txtWarningFood);
                        txtWarningFood.setVisibility(View.VISIBLE); //Ogni tot secondi mi comparirà un messaggio che comunicherà che il tamagotchi ha fame
                    }
                });
                Timer tempTimer = new Timer();
                tempTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run()
                            {
                                TextView txtWarningFood = (TextView) findViewById(R.id.txtWarningFood);
                                txtWarningFood.setText(name + " is hungry!");
                                txtWarningFood.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                }, 5000);
            }
        }, 10000, 10000);


        Button btnTimer = (Button) findViewById(R.id.btnTimer);
        btnTimer.setOnClickListener(new View.OnClickListener() { //Quando premo il pulsante SET TIMER...
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(ThirdActivity.this, TimerActivity.class);
                startActivity(i);
            }
        });

        Button btnRockPaperScissors = (Button) findViewById(R.id.btnRockPaperScissors);
        btnRockPaperScissors.setOnClickListener(new View.OnClickListener() { //Quando premo il pulsante PLAY ROCK PAPER SCISSORS...
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(ThirdActivity.this, RockPaperScissorsActivity.class);
                startActivity(i);
            }
        });

        Button btnClothes = (Button) findViewById(R.id.btnChangeClothes);
        btnClothes.setOnClickListener(new View.OnClickListener() { //Quando premo il pulsante CHANGE CLOTHES...
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(ThirdActivity.this, ClothesActivity.class);
                i.putExtra("key_imagine", drawableChosen);
                startActivityForResult(i, 3);

            }
        });

        Button btnEatFood = (Button) findViewById((R.id.btnEatFood));
        btnEatFood.setOnClickListener(new View.OnClickListener() { //Quando premo il pulsante EAT FOOD...
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(ThirdActivity.this, KitchenActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //Per salvare il capo d'abbigliamento scelto nell'apposita activity ClothesActivity
        ImageView imgTamagotchi = (ImageView) findViewById(R.id.imgTamagotchi);
        super.onActivityResult(requestCode, resultCode, data);
        imgTamagotchi.setImageDrawable(getResources().getDrawable(data.getIntExtra("key_imagine", R.drawable.tamagotchi)));
        drawableChosen=data.getIntExtra("key_imagine", R.drawable.tamagotchi);
       }
}