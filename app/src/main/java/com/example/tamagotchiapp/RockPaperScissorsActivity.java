package com.example.tamagotchiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class RockPaperScissorsActivity extends AppCompatActivity {
    ImageView imgup = null;
    ImageView imgdown = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        imgup = (ImageView) findViewById(R.id.imgup);
        imgdown = (ImageView) findViewById(R.id.imgdown);

        Button btnPaper = (Button) findViewById(R.id.btnPaper); //0
        Button btnScissors = (Button) findViewById(R.id.btnScissors); //1
        Button btnRock = (Button) findViewById(R.id.btnRock); //2

        btnPaper.setOnClickListener(new View.OnClickListener() { //Quando premo sul pulsante paper...
            @Override
            public void onClick(View v)
            {
                int sceltaAvversario = new Random().nextInt(3);
                imgup.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                if(sceltaAvversario == 2) {
                    allertVictory("rock");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                }
                else if (sceltaAvversario == 0) {
                    allertEquality("paper");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                }
                else {
                    allertLost("scissors");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                }
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() { //Quando premo sul pulsante scissors...
            @Override
            public void onClick(View v)
            {
                int sceltaAvversario = new Random().nextInt(3);
                imgup.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                if(sceltaAvversario == 2) {
                    allertLost("rock");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                }
                else if (sceltaAvversario == 0) {
                    allertVictory("paper");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                }
                else {
                    allertEquality("scissors");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                }
            }
        });

        btnRock.setOnClickListener(new View.OnClickListener() { //Quando premo sul pulsante rock...
            @Override
            public void onClick(View v)
            {
                int sceltaAvversario = new Random().nextInt(3);
                imgup.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                if(sceltaAvversario == 2) {
                    allertEquality("rock");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.rock));
                }
                else if (sceltaAvversario == 0) {
                    allertLost("paper");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.paper));
                }
                else {
                    allertVictory("scissors");
                    imgdown.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                }
            }
        });

    }

    public void allertVictory  (String hand) //Allert che comucherà al giocare ti aver vinto
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(RockPaperScissorsActivity.this);
        builder.setTitle("YOU WIN!");
        builder.setMessage("Your opponent has chosen " + hand);
        builder.setCancelable(true);
        builder.setNeutralButton("CLOSE", new
                DialogInterface.OnClickListener() {
                    public void onClick(
                            DialogInterface dialog, int id) {
                        dialog.dismiss();  // quit AlertDialog
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void allertEquality (String hand) //Allert che comucherà al giocare ti aver pareggiato
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(RockPaperScissorsActivity.this);
        builder.setTitle("EXEQUO!");
        builder.setMessage("Your opponent has chosen the same as you: " + hand);
        builder.setCancelable(true);
        builder.setNeutralButton("CLOSE", new
                DialogInterface.OnClickListener() {
                    public void onClick(
                            DialogInterface dialog, int id) {
                        dialog.dismiss();  // quit AlertDialog
                        //finish();  // quit activity
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void allertLost (String hand) //Allert che comucherà al giocare ti aver perso
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(RockPaperScissorsActivity.this);
        builder.setTitle("YOU LOST!");
        builder.setMessage("Your opponent has chosen " + hand);
        builder.setCancelable(true);
        builder.setNeutralButton("CLOSE", new
                DialogInterface.OnClickListener() {
                    public void onClick(
                            DialogInterface dialog, int id) {
                        dialog.dismiss();  // quit AlertDialog
                        //finish();  // quit activity
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}