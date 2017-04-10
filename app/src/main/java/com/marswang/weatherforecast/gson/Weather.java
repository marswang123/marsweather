package com.marswang.weatherforecast.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ${MarsWang} on 2017/4/8.
 */

public class Weather {
    public String status;

    public Basic basic;

    public AQI  aqi;

    public now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
