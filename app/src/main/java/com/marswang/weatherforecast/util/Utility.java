package com.marswang.weatherforecast.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.marswang.weatherforecast.db.City;
import com.marswang.weatherforecast.db.County;
import com.marswang.weatherforecast.db.Province;
import com.marswang.weatherforecast.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ${MarsWang} on 2017/4/7.
 */

public class Utility {
    private static final String TAG = "Utility";

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            Gson gson = new Gson();
            List<Province> provinceData = gson.fromJson(response, new TypeToken<List<Province>>(){}.getType());

            for(Province provinceObject:provinceData){
                Province province = new Province();
                province.setProvinceName(provinceObject.getProvinceName());
                province.setProvinceCode(provinceObject.getId());
                province.save();
            }
            return true;
        }
        return false;
    };

    /**
     * 解析服务器返回的市数据
     *
     * @param response
     * @param provinceId
     * @return
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            Gson gson = new Gson();
            List<City> cityData = gson.fromJson(response, new TypeToken<List<City>>(){}.getType());
            for (City cityObject:cityData){
                City city = new City();
                city.setCityName(cityObject.getCityName());
                city.setCityCode(cityObject.getId());
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }

        return false;
    };


    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            Gson gson = new Gson();
            List<County> countyData = gson.fromJson(response,new TypeToken<List<County>>(){}.getType() );
            for (County countyObject :countyData){
                County county = new County();
                county.setCountyName(countyObject.getCountyName());
                county.setWeatherId(countyObject.getWeatherId());
                county.setCityId(cityId);
                county.save();
            }

            return true;
        }
        return false;
    };

    /**
     * 将JOS解析成weather实体类
     * @param response
     * @return
     */
     public static Weather handleWeatherResponse(String response){
         try {
             JSONObject jsonObject = new JSONObject(response);
             JSONArray jsonArray =jsonObject.getJSONArray("HeWeather");
             String weatherContent = jsonArray.getJSONObject(0).toString();
             return  new Gson().fromJson(weatherContent,Weather.class);

         } catch (JSONException e) {
             e.printStackTrace();
         }
         return null;
     };

}
