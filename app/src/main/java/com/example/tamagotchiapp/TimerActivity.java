package com.example.tamagotchiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity {
    Timer timer = new Timer();
    MediaPlayer player; //Variabile che mi permetterà di utilizzare una suoneria al termine del timer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        player = MediaPlayer.create(this, R.raw.android); //Assegno alla mia variabile player la suoneria che voglio utilizzare

        ProgressBar progressBarTimer = (ProgressBar) findViewById(R.id.progressBar); //Progressbar che scorrerà in apri col timer
        Button btnAvvioTimer = (Button) findViewById(R.id.btnAvvioTimer);
        EditText editTextTimer = (EditText) findViewById(R.id.editTextTimer);
        TextView txtMinuti = (TextView) findViewById(R.id.txtMinuti);
        TextView txtSecondi = (TextView) findViewById(R.id.txtSecondi);
        //ProgressBar progressBarTimer = (ProgressBar) findViewById(R.id.progressBarTimer);

        btnAvvioTimer.setOnClickListener(new View.OnClickListener() { //Quando premo il pulsante START...
            @Override
            public void onClick(View v) {
                int tempo = Integer.parseInt(String.valueOf(editTextTimer.getText())) * 60; //tempo in secondi
                editTextTimer.setText("");
                progressBarTimer.setMax(tempo);
                progressBarTimer.setProgress(tempo);
                txtSecondi.setText(String.valueOf(tempo%60));
                txtMinuti.setText(String.valueOf(tempo/60));

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        final int secRimanenti=Integer.parseInt(String.valueOf(txtSecondi.getText()))-1;
                        final int minRimanenti=Integer.parseInt(String.valueOf(txtMinuti.getText()));
                        //txtMinuti.setText();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtSecondi.setText(String.valueOf(secRimanenti%60));

                                progressBarTimer.setProgress(progressBarTimer.getProgress()-1);
                                System.out.println(progressBarTimer.getProgress());


                                if (secRimanenti<=0) {
                                    if(minRimanenti==0)
                                    {
                                        timer.cancel();
                                        timer.purge();
                                        player.start();
                                        toastTimer ();
                                    }
                                    else
                                    {
                                        txtSecondi.setText("59");
                                        txtMinuti.setText(String.valueOf(Integer.parseInt(txtMinuti.getText().toString())-1));
                                    }
                                }
                            }
                        });
                    }
                }, 1000, 1000);

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer.purge();
    }

    public void toastTimer () //Una volta terminato il timer comparirà un toast che avvertirà di ciò insieme ad una suoneria
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(TimerActivity.this);
        builder.setTitle("TIMER");
        builder.setMessage("The timer has run out");
        builder.setCancelable(true);
        builder.setNeutralButton("Close", new
                DialogInterface.OnClickListener() {
                    public void onClick(
                        DialogInterface dialog, int id) {
                        player.stop();
                        dialog.dismiss();  // quit AlertDialog
                        finish();  // quit activity
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}