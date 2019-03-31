package com.example.manillenandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String naamTeam1;
    public static String naamTeam2;
    private Button submit;
    private EditText et_naamTeam1;
    private EditText et_naamTeam2;


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
                naamTeam1 = et_naamTeam1.getText().toString();
                naamTeam2 = et_naamTeam2.getText().toString();
                openOpteller();
            }
        });
    }

    private void openOpteller() {
        Intent openOptellerKlasse = new Intent(this, ScoreOptellen.class);
        startActivity(openOptellerKlasse);
    }
}
