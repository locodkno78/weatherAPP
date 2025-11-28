package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> ciudades;

    public MyAdapter(Context context, ArrayList<String> ciudades){
        this.context = context;
        this.ciudades = ciudades;
    }

    @Override
    public int getCount() {
        return ciudades.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ciudades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v= convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.list_item, null);

        String currentName = ciudades.get(position);

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);

        return v;
    }
}
