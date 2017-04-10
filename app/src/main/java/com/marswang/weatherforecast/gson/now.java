package com.marswang.weatherforecast.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ${MarsWang} on 2017/4/8.
 */

public class now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }

}
