package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void irAlistCiudades(View view) {
        Intent miIntent = new Intent(this, ListActivity.class);
        startActivity(miIntent);
    }

    public void irDetalle(View view) {
        Intent myIntent = new Intent(this, DetailActivity.class);
        /*myIntent.putExtra("nombreCiudad", "Roma");*/

        myIntent.putExtra("lat", 25.783333333333f);
        myIntent.putExtra("lon", -80.216666666667f);

       startActivity(myIntent);
    }
}