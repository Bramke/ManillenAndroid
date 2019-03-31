package com.example.manillenandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String naamTeam1;
    public static String naamTeam2;
    //public static int maxScoreTotaal;
    private Button submit;
    private EditText et_naamTeam1;
    private EditText et_naamTeam2;
    private Button instellingen;
    //private EditText et_maxScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscherm);

        submit = findViewById(R.id.btn_submitNaam);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_naamTeam1 = findViewById(R.id.et_naamTeam1);
                et_naamTeam2 = findViewById(R.id.et_naamTeam2);
                //et_maxScore = findViewById(R.id.et_maxScore);
                String isLeeg1 = et_naamTeam1.getText().toString();
                String isleeg2 = et_naamTeam2.getText().toString();
                if (isLeeg1.trim().isEmpty() || isleeg2.trim().isEmpty()){
                    AlertDialog.Builder naamLeeg = new AlertDialog.Builder(MainActivity.this);
                    naamLeeg.setTitle("Let Op!");
                    naamLeeg.setMessage("Je moet een naam invullen.");
                    naamLeeg.setPositiveButton("OK!",null);
                    naamLeeg.show();
                }else{
                    naamTeam1 = et_naamTeam1.getText().toString();
                    naamTeam2 = et_naamTeam2.getText().toString();
                   // maxScoreTotaal = Integer.parseInt(et_maxScore.getText().toString());
                    openOpteller();
                }

            }
        });
        instellingen = findViewById(R.id.btn_instellingen);
        instellingen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstellingen();
            }
    });

    }

    private void openInstellingen(){
        Intent openInstellingen = new Intent(this, Instellingen.class);
        startActivity(openInstellingen);
    }
    private void openOpteller() {
        Intent openOptellerKlasse = new Intent(this, ScoreOptellen.class);
        startActivity(openOptellerKlasse);
    }
}