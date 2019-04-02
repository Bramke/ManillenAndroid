package com.example.manillenandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreOptellen extends AppCompatActivity {
    private TextView scoreTeam1;
    private TextView scoreTeam2;
    private EditText scoreDezeRonde;
    private Button team1;
    private Button team2;
    private Button stop;
    private int totaalTeam1;
    private int totaalTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_optellen);

        scoreDezeRonde = (EditText) findViewById(R.id.etScoreRonde);
        team1 = findViewById(R.id.btnTeam1);
        team2 = findViewById(R.id.btnTeam2);
        scoreTeam1 = findViewById(R.id.tvTeam1Score);
        scoreTeam2 = findViewById(R.id.tvTeam2Score);
        team1.setText(String.valueOf(MainActivity.naamTeam1));
        team2.setText(String.valueOf(MainActivity.naamTeam2));
        stop = findViewById(R.id.btn_stop);

        final Builder scoreTeLaag = new Builder(ScoreOptellen.this);
        scoreTeLaag.setTitle("Let Op!");
        scoreTeLaag.setMessage("De ingevulde score moet boven 0 liggen.");
        scoreTeLaag.setPositiveButton("OK!",null);

        final Builder scoreTeLaag2 = new Builder(ScoreOptellen.this);
        scoreTeLaag2.setTitle("Let Op!");
        scoreTeLaag2.setMessage("De ingevulde score moet boven 0 liggen");
        scoreTeLaag2.setPositiveButton("OK!",null);

        team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (Integer.parseInt(scoreDezeRonde.getText().toString()) > 0 || scoreDezeRonde.getText().toString().equals("")) {
                        int scoreRonde = Integer.parseInt(scoreDezeRonde.getText().toString());
                        totaalTeam1 = totaalTeam1 + scoreRonde;
                        scoreTeam1.setText(String.valueOf(totaalTeam1));
                        if (totaalTeam1 >= Instellingen.maxScoreTotaal) {
                            Builder gewonnenTeam1 = new Builder(ScoreOptellen.this);
                            gewonnenTeam1.setTitle("Gewonnen");
                            gewonnenTeam1.setMessage("Gefeliciteerd team " + MainActivity.naamTeam1 + " je hebt gewonnen!");
                            gewonnenTeam1.setPositiveButton("OK!",null);
                            gewonnenTeam1.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    openStartscherm();
                                    totaalTeam1 = 0;
                                    totaalTeam2 = 0;
                                    MainActivity.naamTeam1 = null;
                                    MainActivity.naamTeam2 = null;
                                    scoreTeam1.setText("Team1: \n");
                                    scoreTeam2.setText("Team2: \n");
                                }
                            });
                            gewonnenTeam1.show();
                        }
                        //Geprobeerd om lege score te voorkomen, werkt niet.
                   // }else if (scoreDezeRonde.getText().toString().trim().isEmpty()){
                   //     Builder scoreNietIngevuld = new Builder(ScoreOptellen.this);
                   //     scoreNietIngevuld.setTitle("Let Op!");
                   //     scoreNietIngevuld.setMessage("De ingevulde score moet boven 0 liggen.");
                   //     scoreNietIngevuld.setPositiveButton("OK!",null);
                   //     scoreNietIngevuld.show();
                    }
                    else {
                        //POPUP KADER MET OK KNOP
                        scoreTeLaag.show();
                    }
                }
            });
        team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(scoreDezeRonde.getText().toString()) > 0){
                    int scoreRonde = Integer.parseInt(scoreDezeRonde.getText().toString());
                    totaalTeam2 = totaalTeam2 + scoreRonde;
                    scoreTeam2.setText(String.valueOf(totaalTeam2));
                    if (totaalTeam2 >= Instellingen.maxScoreTotaal) {
                        Builder gewonnenTeam2 = new Builder(ScoreOptellen.this);
                        gewonnenTeam2.setTitle("Gewonnen");
                        gewonnenTeam2.setMessage("Gefeliciteerd team " + MainActivity.naamTeam2 + " je hebt gewonnen!");
                        gewonnenTeam2.setPositiveButton("OK!",null);
                        gewonnenTeam2.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                openStartscherm();
                                totaalTeam1 = 0;
                                totaalTeam2 = 0;
                                MainActivity.naamTeam1 = null;
                                MainActivity.naamTeam2 = null;
                                scoreTeam1.setText("Team1: \n");
                                scoreTeam2.setText("Team2: \n");
                            }
                        });
                        gewonnenTeam2.show();
                    }
                } else {
                    //POPUP KADER MET OK KNOP
                    scoreTeLaag2.show();
                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartscherm();
                totaalTeam1 = 0;
                totaalTeam2 = 0;
                MainActivity.naamTeam1 = null;
                MainActivity.naamTeam2 = null;
                scoreTeam1.setText("Team1: \n");
                scoreTeam2.setText("Team2: \n");
            }
        });

    }

    public void openStartscherm() {
        Intent openStartschermKlasse = new Intent(this, MainActivity.class);
        startActivity(openStartschermKlasse);
    }
}
