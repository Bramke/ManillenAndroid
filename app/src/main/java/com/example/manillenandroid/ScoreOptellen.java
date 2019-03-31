package com.example.manillenandroid;

import android.content.Intent;
import android.os.Bundle;
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

        scoreDezeRonde = findViewById(R.id.etScoreRonde);
        team1 = findViewById(R.id.btnTeam1);
        team2 = findViewById(R.id.btnTeam2);
        scoreTeam1 = findViewById(R.id.tvTeam1);
        scoreTeam2 = findViewById(R.id.tvTeam2);
        team1.setText(String.valueOf(MainActivity.naamTeam1));
        team2.setText(String.valueOf(MainActivity.naamTeam2));
        stop = findViewById(R.id.btn_stop);

        team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreRonde = Integer.parseInt(scoreDezeRonde.getText().toString());
                totaalTeam1 = totaalTeam1 + scoreRonde;
                scoreTeam1.setText("Team1: \n" + String.valueOf(totaalTeam1));

            }


        });
        team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreRonde = Integer.parseInt(scoreDezeRonde.getText().toString());
                totaalTeam2 = totaalTeam2 + scoreRonde;
                scoreTeam2.setText("Team1: \n" + String.valueOf(totaalTeam2));

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

    private void openStartscherm() {
        Intent openStartschermKlasse = new Intent(this, MainActivity.class);
        startActivity(openStartschermKlasse);
    }
}
