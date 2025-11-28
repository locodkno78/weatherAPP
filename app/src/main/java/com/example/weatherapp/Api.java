package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    String Token = "4156be3a8e9dd64cc41a514ed0eb1bf2";

    String Unidades = "metric";

    String Lenguaje = "es";

    @GET("weather")
    Call<Results> getActualWeather(
            @Query("lat") Float latitud,
            @Query("lon") Float longitud,
            @Query("appid") String token,
            @Query("units") String unidades,
            @Query("lang") String lenguaje
    );

}
