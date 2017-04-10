package com.marswang.weatherforecast.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ${MarsWang} on 2017/4/8.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;  //城市名

    @SerializedName("id")
    public String weatherId; // 天气Id

    public Update update;  //更新

    public class Update{
        @SerializedName("loc")
        public String updateTime; // 更新时间
    }
}
