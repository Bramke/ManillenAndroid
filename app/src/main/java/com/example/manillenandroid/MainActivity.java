package com.example.manillenandroid;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String naamTeam1;
    public static String naamTeam2;
    private Button submit;
    private EditText et_naamTeam1;
    private EditText et_naamTeam2;
    private Button instellingen;
    private Button databaseIn;
    public int maxScore = Instellingen.maxScoreTotaal;

    //Instantie van databasehelper oproepen
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscherm);
        //Maken van databse en table
        myDb = new DatabaseHelper(this);


        submit = findViewById(R.id.btn_submitNaam);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_naamTeam1 = findViewById(R.id.et_naamTeam1);
                et_naamTeam2 = findViewById(R.id.et_naamTeam2);
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
                    addData();
                    openOpteller();
                }

            }
        });
        databaseIn = findViewById(R.id.btn_databaseIn);
        databaseIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0){
                    AlertDialog.Builder databaseLeeg = new AlertDialog.Builder(MainActivity.this);
                    databaseLeeg.setTitle("Let Op!");
                    databaseLeeg.setMessage("De database is leeg, je kan niks inladen.");
                    databaseLeeg.setPositiveButton("OK!",null);
                    databaseLeeg.show();
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id: " + res.getString(0) + "\n");
                    buffer.append("Team1: " + res.getString(1) + "\n");
                    buffer.append("Team2: "+ res.getString(2) + "\n");
                    buffer.append("MaxScore: "+ res.getString(3) + "\n");
                    AlertDialog.Builder indb = new AlertDialog.Builder(MainActivity.this);
                    indb.setTitle("Let Op!");
                    indb.setMessage(buffer.toString());
                    indb.setPositiveButton("OK!",null);
                    indb.show();
                    //TODO Laatste gegevens in databank weergeven in tekstvelden
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

    public void addData(){
        boolean isInserted = myDb.insertData(et_naamTeam1.getText().toString(), et_naamTeam1.getText().toString(), Instellingen.maxScoreTotaal);
        if (isInserted = true){
            Toast.makeText(MainActivity.this, "DATA naar databank", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "DATA NIET naar databank", Toast.LENGTH_LONG).show();
        }

    }
    private void openInstellingen(){
        Intent openInstellingen = new Intent(MainActivity.this, Instellingen.class);
        startActivity(openInstellingen);
    }
    protected void openOpteller() {
        Intent openOptellerKlasse = new Intent(this, ScoreOptellen.class);
        startActivity(openOptellerKlasse);
    }
}