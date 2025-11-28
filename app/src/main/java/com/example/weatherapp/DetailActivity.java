package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView nombreCiudad, temperatura, descripcion, min, max;
    float latitud, longitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();
        latitud = myIntent.getFloatExtra("lat", 0F);
        longitud = myIntent.getFloatExtra("lon", 0F);

        nombreCiudad = findViewById(R.id.tvCiudad);
        temperatura = findViewById(R.id.tvTemp);
        descripcion = findViewById(R.id.tvDesc);
        min = findViewById(R.id.tvMin);
        max = findViewById(R.id.tvMax);

        getActualWeather();

       /* String ciudadElegida = myIntent.getStringExtra("nombreCiudad");

        TextView nombreCiudad = findViewById(R.id.tvCiudad);
        nombreCiudad.setText(ciudadElegida);*/
    }

    private void getActualWeather() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getActualWeather(latitud, longitud, Api.Token, Api.Unidades, Api.Language);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(@NonNull Call<Results> call, @NonNull Response<Results> response) {
                if (response.isSuccessful()) {
                    Results results = response.body();
                    nombreCiudad.setText(results.name);
                    temperatura.setText(results.main.temp.toString() + "°");
                    descripcion.setText(results.weather.get(0).description);
                    min.setText(results.main.temp_min.toString() + "°");
                    max.setText(results.main.temp_max.toString() + "°");
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<Results> call, @NonNull Throwable t) {
            }
        });
                }
    }
