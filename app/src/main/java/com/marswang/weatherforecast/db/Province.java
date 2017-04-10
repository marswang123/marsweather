package com.marswang.weatherforecast.db;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.DataSupport;

/**
 * Created by ${MarsWang} on 2017/4/6.
 */

public class Province  extends DataSupport{
    private int id;

    @SerializedName("name")
    private String provinceName; //省

    private int provinceCode;//省的编码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
