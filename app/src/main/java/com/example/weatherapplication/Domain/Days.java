package com.example.weatherapplication.Domain;

public class Days {
    private String day;
    private String weather_status;
    private String morning_temp;
    private String night_temp;
    private String weather_icon;

    public Days(String day, String weather_status, String morning_temp, String night_temp, String weather_icon) {
        this.day = day;
        this.weather_status = weather_status;
        this.morning_temp = morning_temp;
        this.night_temp = night_temp;
        this.weather_icon = weather_icon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather_status() {
        return weather_status;
    }

    public void setWeather_status(String weather_status) {
        this.weather_status = weather_status;
    }

    public String getMorning_temp() {
        return morning_temp;
    }

    public void setMorning_temp(String morning_temp) {
        this.morning_temp = morning_temp;
    }

    public String getNight_temp() {
        return night_temp;
    }

    public void setNight_temp(String night_temp) {
        this.night_temp = night_temp;
    }

    public String getWeather_icon() {
        return weather_icon;
    }

    public void setWeather_icon(String weather_icon) {
        this.weather_icon = weather_icon;
    }
}
