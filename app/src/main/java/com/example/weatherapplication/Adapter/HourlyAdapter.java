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
import com.example.weatherapplication.Domain.Hourly;
import com.example.weatherapplication.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.viewHolder> {

    private ArrayList<Hourly> items;
    private Context context;

    public HourlyAdapter(ArrayList<Hourly> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public HourlyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_hourly, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.viewHolder holder, int position) {
        holder.hourTxt.setText(items.get(position).getHour());
        holder.tempTxt.setText(items.get(position).getTemp());

        int imgID = holder.itemView.getResources().getIdentifier(items.get(position).getImgPath(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(imgID)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView hourTxt, tempTxt;
        ImageView img;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            hourTxt = itemView.findViewById(R.id.hour_text);
            tempTxt = itemView.findViewById(R.id.hour_temp);
            img = itemView.findViewById(R.id.weather_hour_icon);
        }
    }
}
