package com.marswang.weatherforecast.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.marswang.weatherforecast.db.City;
import com.marswang.weatherforecast.db.County;
import com.marswang.weatherforecast.db.Province;

import java.util.List;

/**
 * Created by ${MarsWang} on 2017/4/7.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            Gson gson = new Gson();
            List<Province> provinceData = gson.fromJson(response, new TypeToken<List<Province>>(){}.getType());

            for(Province provinceObject:provinceData){
                Province province = new Province();
                province.setName(provinceObject.getName());
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
                city.setName(cityObject.getName());
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
                county.setName(countyObject.getName());
                county.setWeatherId(countyObject.getWeatherId());
                county.setCityId(cityId);
                county.save();
            }

            return true;
        }
        return false;
    };
}
