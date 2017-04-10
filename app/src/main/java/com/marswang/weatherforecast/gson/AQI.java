package com.marswang.weatherforecast.gson;

/**
 * Created by ${MarsWang} on 2017/4/8.
 */

public class AQI {
    public AQICity city;

    public class AQICity{

        public String aqi; // 空气质量指数

        public String pm25;
    }
}
