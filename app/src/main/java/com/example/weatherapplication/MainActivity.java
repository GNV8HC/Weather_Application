package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapplication.Activities.Weekly;
import com.example.weatherapplication.Adapter.HourlyAdapter;
import com.example.weatherapplication.Domain.Hourly;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private HourlyAdapter adapterHourly;
    private RecyclerView rcView;
    ArrayList<Hourly> items;
    private TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcView = findViewById(R.id.rcView);
        initRecyclerView();
        adapterHourly = new HourlyAdapter(items, this);
        rcView.setAdapter(adapterHourly);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Weekly.class);
                startActivity(intent);
            }
        });
    }

    private void initRecyclerView() {
        items = new ArrayList<>();

        items.add(new Hourly("9 am", 28, "cloudy"));
        items.add(new Hourly("11 am", 30, "sun"));
        items.add(new Hourly("13 pm", 25, "wind"));
        items.add(new Hourly("15 pm", 20, "rain"));
        items.add(new Hourly("17 pm", 5, "storm"));
    }

}