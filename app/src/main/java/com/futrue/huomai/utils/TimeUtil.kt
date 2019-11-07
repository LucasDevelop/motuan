package com.futrue.huomai.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

    //格式化时间
    fun formatTime(time:Long):String{
        val currentTimeMillis = System.currentTimeMillis()
        val diffTime = (currentTimeMillis - time)/1000
        if (diffTime in 0..60){
            return "${diffTime}秒前"
        }
        if (diffTime in 60..3600){
            return "${diffTime/60}分钟前"
        }
        if (diffTime in 3600..86400){
            return "${diffTime/3600}小时前"
        }
        val instance = SimpleDateFormat.getInstance() as SimpleDateFormat
        instance.applyPattern("MM-dd")
        return instance.format(Date(time))
    }
}