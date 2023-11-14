package com.example.weatherapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.weatherapplication.Adapter.WeeklyAdapter;
import com.example.weatherapplication.Domain.Days;
import com.example.weatherapplication.R;

import java.util.ArrayList;

public class Weekly extends AppCompatActivity {
    private ArrayList<Days> days;
    private RecyclerView weekly;
    private WeeklyAdapter adapter;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        weekly = findViewById(R.id.weekly_weather);
        initTemp();
        adapter = new WeeklyAdapter(this, days);
        weekly.setAdapter(adapter);
        weekly.setLayoutManager(new LinearLayoutManager(this));

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initTemp()
    {
        days = new ArrayList<>();
        days.add(new Days("Sat", "Storm", "25°", "25°", "storm"));
        days.add(new Days("Sun", "Cloudy", "25°", "25°", "cloudy"));
        days.add(new Days("Mon", "Wind", "25°", "25°", "wind"));
        days.add(new Days("Tue", "Sun", "25°", "25°", "sun"));
        days.add(new Days("Wed", "Rain", "25°", "25°", "rain"));
        days.add(new Days("Thu", "Snowy", "25°", "25°", "snowy"));
    }
}