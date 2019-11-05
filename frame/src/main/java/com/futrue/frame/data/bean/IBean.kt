package com.futrue.frame.data.bean

/**
 *  数据原型
 */
open class IBean {
    var status: Int = 0
    var msg: String = ""

    //判断list数据是否为空
    open fun isEmpty() = false
}