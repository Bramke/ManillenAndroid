package com.example.manillenandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Instellingen extends AppCompatActivity {
    public static int maxScoreTotaal;
    private EditText et_maxScore;
    private Button opslaanInstellingen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        et_maxScore = findViewById(R.id.et_maxScore);
        maxScoreTotaal = 120;
        opslaanInstellingen = findViewById(R.id.btn_opslaanInstellingen);
        opslaanInstellingen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxScoreTotaal = Integer.parseInt(et_maxScore.getText().toString());
            }

        });
    }
}