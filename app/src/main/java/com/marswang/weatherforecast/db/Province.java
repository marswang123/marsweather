package com.marswang.weatherforecast.db;

import org.litepal.crud.DataSupport;

/**
 * Created by ${MarsWang} on 2017/4/6.
 */

public class Province  extends DataSupport{
    private int id;
    private String name; //省
    private int provinceCode;//省的编码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
