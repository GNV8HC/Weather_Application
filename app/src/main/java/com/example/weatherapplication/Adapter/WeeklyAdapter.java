package com.example.weatherapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapplication.Domain.Days;
import com.example.weatherapplication.R;

import java.util.ArrayList;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.viewHolder> {
    private ArrayList<Days> days;
    private Context context;

    public WeeklyAdapter(Context context, ArrayList<Days> days)
    {
        this.context = context;
        this.days = days;
    }

    @NonNull
    @Override
    public WeeklyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_weekly, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyAdapter.viewHolder holder, int position) {
        holder.day.setText(days.get(position).getDay());
        holder.weather_stt.setText(days.get(position).getWeather_status());
        holder.morning_temp.setText(days.get(position).getMorning_temp());
        holder.night_temp.setText(days.get(position).getNight_temp());

        int imgID = holder.itemView.getResources().getIdentifier(days.get(position).getWeather_icon(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(imgID)
                .into(holder.icon_weather);
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView day,weather_stt, morning_temp, night_temp;
        ImageView icon_weather;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            weather_stt = itemView.findViewById(R.id.weather_day_status);
            morning_temp = itemView.findViewById(R.id.morning_temp);
            night_temp = itemView.findViewById(R.id.night_temp);
            icon_weather = itemView.findViewById(R.id.day_weather_icon);
        }
    }
}
