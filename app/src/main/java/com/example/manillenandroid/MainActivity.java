package com.example.manillenandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView scoreTeam1;
    private TextView scoreTeam2;
    private EditText scoreDezeRonde;
    private Button team1;
    private Button team2;
    private int totaalTeam1;
    private int totaalTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreDezeRonde = (EditText) findViewById(R.id.etScoreRonde);
        team1 = (Button) findViewById(R.id.btnTeam1);
        team2 = (Button) findViewById(R.id.btnTeam2);
        scoreTeam1 = (TextView) findViewById(R.id.tvTeam1);
        scoreTeam2 = (TextView) findViewById(R.id.tvTeam2);

        team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreRonde = Integer.parseInt(scoreDezeRonde.getText().toString());
                totaalTeam1 = totaalTeam1 + scoreRonde;
                scoreTeam1.setText("team1: " + String.valueOf(totaalTeam1));

            }


        });
        team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreRonde = Integer.parseInt(scoreDezeRonde.getText().toString());
                totaalTeam2 = totaalTeam2 + scoreRonde;
                scoreTeam2.setText("team1: " + String.valueOf(totaalTeam2));

            }


        });
    }
}
