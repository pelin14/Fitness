package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class SonucSayfasi extends AppCompatActivity {


    TextView sabahkcal_txt,oglekcal_txt,aksamkcal_txt,toplamkcal_txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_sayfasi);


        sabahkcal_txt = findViewById(R.id.sabahkcal_txt);
        oglekcal_txt = findViewById(R.id.oglekcal_txt);
        aksamkcal_txt = findViewById(R.id.aksamkcal_txt);
        toplamkcal_txt = findViewById(R.id.toplamkcal_txt);

        int sabahkalori = getIntent().getIntExtra("sabah",0);
        int oglekalori = getIntent().getIntExtra("ogle",0);
        int aksamkalori = getIntent().getIntExtra("aksam",0);
        int toplamkalori = getIntent().getIntExtra("toplam",0);


        sabahkcal_txt.setText(String.valueOf(sabahkalori));
        oglekcal_txt.setText(String.valueOf(oglekalori));
        aksamkcal_txt.setText(String.valueOf(aksamkalori));
        toplamkcal_txt.setText(String.valueOf(toplamkalori));





    }
}