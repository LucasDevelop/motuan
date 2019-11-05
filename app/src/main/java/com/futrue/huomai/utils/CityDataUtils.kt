package com.futrue.huomai.utils

import android.content.Context
import com.alibaba.fastjson.JSONArray
import com.futrue.huomai.main.my.usercenter.JsonBean
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList

object CityDataUtils {


    fun initJsonData(
        context: Context, result: (
            ArrayList<JsonBean>, ArrayList<ArrayList<String?>>,
            ArrayList<ArrayList<ArrayList<String>>>
        ) -> Unit
    ) {//解析数据

        val JsonData = getJson(context, "province.json")//获取assets目录下的json文件数据
        val jsonBean = parseData(JsonData)//用Gson 转成实体
        val options2Items = ArrayList<ArrayList<String?>>()
        val options3Items = ArrayList<ArrayList<ArrayList<String>>>()
        for (i in jsonBean.indices) {//遍历省份
            val cityList = ArrayList<String?>()//该省的城市列表（第二级）
            val province_AreaList = ArrayList<ArrayList<String>>()//该省的所有地区列表（第三极）

            for (c in jsonBean[i].city?.indices!!) {//遍历该省份的所有城市
                val cityName = jsonBean[i].city[c].name
                cityList.add(cityName)//添加城市
                val city_AreaList = ArrayList<String>()//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                jsonBean[i].city?.get(c)?.area?.apply {
                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (size == 0) {
                        city_AreaList.add("")
                    } else {
                        city_AreaList.addAll(this)
                    }
                }
                province_AreaList.add(city_AreaList)//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList)

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList)

        }
        result(jsonBean, options2Items, options3Items)
    }

    private fun getJson(context: Context, fileName: String): String {
        val stringBuilder = StringBuilder()
        try {
            val assetManager = context.assets
            val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
            var line: String?
            do {
                line = bf.readLine()
                if (line == null) {
                    break
                }
                stringBuilder.append(line)
            } while (true)

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }


    private fun parseData(result: String): ArrayList<JsonBean> {//Gson 解析
        val detail = ArrayList<JsonBean>()
        val data = JSONArray.parseArray(result)
        for (i in data.indices) {
            detail.add(data.getObject(i, JsonBean::class.java))
        }
        return detail
    }
}