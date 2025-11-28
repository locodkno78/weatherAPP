package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setUpListView();

    }

    void setUpListView(){
        listView = (ListView) findViewById(R.id.listView);
        ciudades= new ArrayList<String>();

        ciudades.add("Cordoba");
        ciudades.add("Mendoza");
        ciudades.add("San Juan");
        ciudades.add("Rosario");
        ciudades.add("Bahia Blanca");

        /*ArrayAdapter arrayAdapter= new ArrayAdapter<String>
                (getApplicationContext(), android.R.layout.simple_list_item_1, ciudades);

        listView.setAdapter(arrayAdapter);*/

        MyAdapter adapter = new MyAdapter(this, ciudades);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                irDetalle((String) ciudades.get(position));

            }
        });
    }

    private void irDetalle(String ciudad) {
        Intent myIntent = new Intent(this, DetailActivity.class);
        myIntent.putExtra("nombreCiudad", ciudad);
        startActivity(myIntent);
    }
}