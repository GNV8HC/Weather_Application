package com.example.weatherapplication.Domain;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather {
    private final String url;
    private final Context context;

    public Weather(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    public void connectWeather(final WeatherCallback callback) {
        RequestQueue request = com.android.volley.toolbox.Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Success to connect to DataBase");
                callback.onSuccess(getData(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError("Unable to connect to Database");
            }
        });
        request.add(stringRequest);

    }

    public Bundle getData(String response) {
        Bundle tempBundle = new Bundle();
        try {
            JSONObject jsonObject = new JSONObject(response);
            String day = jsonObject.getString("dt");
            String name = jsonObject.getString("name");

            long l = Long.valueOf(day);
            Date date = new Date(l * 1000L);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd | hh:mm a");
            String today = simpleDateFormat.format(date);

            JSONArray weather = jsonObject.getJSONArray("weather");
            JSONObject weatherObject = weather.getJSONObject(0);
            String description = weatherObject.getString("description");
            String icon = weatherObject.getString("main");


            JSONObject mainObject = jsonObject.getJSONObject("main");
            Double temp = (mainObject.getDouble("temp") - 272.15);
            Double humid = mainObject.getDouble("humidity");
            Double prs = mainObject.getDouble("pressure");

            JSONObject windObject = jsonObject.getJSONObject("wind");
            Double speed = windObject.getDouble("speed");

            tempBundle.putString("name", name);
            tempBundle.putString("today", today);
            tempBundle.putString("description", description);
            tempBundle.putString("icon", icon);
            tempBundle.putDouble("temp", temp);
            tempBundle.putDouble("speed", speed);
            tempBundle.putDouble("prs", prs);
            tempBundle.putDouble("humid", humid);
            System.out.println(tempBundle);
            return tempBundle;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public interface WeatherCallback
    {
        void onSuccess(Bundle bundle);

        void onError(String errorMessage);
    }
}
