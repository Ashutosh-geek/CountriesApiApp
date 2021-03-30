package com.example.countriesapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

public class DetailActivity extends AppCompatActivity {
    private ImageView flagimage;
    private TextView name,capital,region,subregion,population,language;
    private String Cname,Ccapital,Cregion,Csubregion,Cpopulation,Clanguage,Cflagurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        flagimage = findViewById(R.id.flagimage);
        name = findViewById(R.id.name);
        capital = findViewById(R.id.capital);
        region = findViewById(R.id.region);
        subregion = findViewById(R.id.subregion);
        population = findViewById(R.id.population);
        language = findViewById(R.id.language);
        Intent intent = getIntent();
        Cflagurl = intent.getStringExtra("flagurl");
        Cname = intent.getStringExtra("name");
        Ccapital = intent.getStringExtra("capital");
        Cregion = intent.getStringExtra("region");
        Csubregion = intent.getStringExtra("subregion");
        Cpopulation = intent.getStringExtra("population");
        Clanguage = intent.getStringExtra("language");
        name.setText("Country Name:  " + Cname);
        capital.setText("Capital:  " + Ccapital);
        region.setText("Region:  " + Cregion);
        subregion.setText("Subregion:  " + Csubregion);
        population.setText("Population:  "+Cpopulation);
        language.setText("Language:  "+ Clanguage);
        SvgLoader.pluck().with(this).load(Cflagurl,flagimage);
    }
}
